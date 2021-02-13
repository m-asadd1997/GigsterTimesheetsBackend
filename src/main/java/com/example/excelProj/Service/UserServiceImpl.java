package com.example.excelProj.Service;

import com.example.excelProj.Commons.EmailTemplate;
import com.example.excelProj.Dto.MessageDto;
import com.example.excelProj.Model.ApplicantForm;

import com.example.excelProj.Repository.ApplicantFormRepository;

import com.example.excelProj.Repository.UserDaoRepository;
import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.UserDto;
import com.example.excelProj.Model.User;


import com.example.excelProj.Service.impl.NotificationService;
import com.example.excelProj.util.Util;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.*;


@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService {
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private UserDaoRepository userDaoRepository;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Autowired
	private ApplicantFormRepository applicantFormRepository;

	@Autowired
	private NotificationService notificationService;

	@Value("${spring.mail.username}")
	private String username;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDaoRepository.findByEmail(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user.getUserType()));
	}

	private List<SimpleGrantedAuthority> getAuthority(String role) {
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDaoRepository.findByActive().iterator().forEachRemaining(list::add);
		return list;
	}

	public ApiResponse<List<User>> delete(Long id) {
		Optional<User> userOptional = userDaoRepository.findById(id);
		if(userOptional.isPresent()){
			userDaoRepository.deleteById(id);
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",	userDaoRepository.findAll());
	}

	public User findOne(String username) {

		User user = userDaoRepository.findByEmailAndActive(username,Boolean.TRUE);
		return user;

	}

	public User findById(Long id) {
		Optional<User> optionalUser = userDaoRepository.findById(id);

		return optionalUser.isPresent() ?  optionalUser.get() : null;
	}

	public UserDto update(UserDto userDto, Long id) {
		User user = findById(id);
		if(user != null) {
			BeanUtils.copyProperties(userDto, user, "password");
			userDaoRepository.save(user);
		}
		return userDto;
	}

	public ApiResponse registerUser(UserDto userDto){
		User founduser = userDaoRepository.findByEmail(userDto.getEmail());
		User user1 = userDaoRepository.getAdminOfOrganization(userDto.getOrganizationName());
		if(founduser == null && user1 == null) {
			User newUser = new User();
			newUser.setEmail(userDto.getEmail());
			newUser.setName(userDto.getName());
			newUser.setOrganizationName(userDto.getOrganizationName());
			newUser.setUserType(userDto.getUserType());
			newUser.setPaid(userDto.getPaid());
			newUser.setActive(true);
			try{
				newUser.setPassword(userDto.getPassword());
				trigerEmail(newUser);
			}catch(Exception e){
				System.out.println(e);
			}
			newUser.setPassword(bcryptEncoder.encode(userDto.getPassword()));
			return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",	userDaoRepository.save(newUser));//return ;
		}else if(founduser != null){
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "User Already exsist.",null);//return ;
		}
		else if(user1 != null){
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Organization Already exsist.",null);//return ;
		}
		else{
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Error adding user",null);//return ;
		}
	}



    public ApiResponse save(UserDto user) {
		User userExists = userDaoRepository.findByEmail(user.getEmail());

		if(userExists == null) {
			User newUser = new User();
			String password = getAlphaNumericString(8);
			newUser.setEmail(user.getEmail());
			newUser.setName(user.getName());
			newUser.setOrganizationName(user.getOrganizationName());
			newUser.setUserType(user.getUserType());
			newUser.setPaid(user.getPaid());
			newUser.setActive(true);
			if(Strings.isNotBlank(user.getUserType()) && user.getUserType().toLowerCase().equals("employee")  || user.getUserType().toLowerCase().equals("supervisor")){
				try{
					newUser.setPassword(password);
					trigerEmail(newUser);
				}catch (Exception e){
					e.printStackTrace();
				}
			}
			newUser.setPassword(bcryptEncoder.encode(password));

			return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",	userDaoRepository.save(newUser));//return ;
	}else if(userExists != null){
		return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "User Already exsist.",null);//return ;
	}
		else{
		return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Error adding user",null);//return ;
	}
}



	public List<User> getActiveUsers(Long id){
		Optional<User> user = userDaoRepository.findById(id);
		if(user.isPresent()){
			User user1 = user.get();
			user1.setActive(false);
			userDaoRepository.save(user1);

			List<User> activeUsers = userDaoRepository.findByActive();
			return activeUsers;
		}

		return null;
	}

	public ApiResponse getSupervisorsByOrganizationName(String organizationName){
		return new ApiResponse<>(HttpStatus.OK.value(), "Supervisor Found successfully.",userDaoRepository.getSupervisorsByOrganizationName(organizationName));
	}


	public ApiResponse<String> trigerEmail(User user) {
		if(!userDaoRepository.existsByEmail(user.getEmail())){
			sendEmail(user);
			return new ApiResponse<>(200,"Email Send Successfully",null);
		}
		return new ApiResponse<>(404,"User Already Exists","User Already Exists");
	}


	private void sendEmail(User newUser) {
		MessageDto messageDto = new MessageDto();
		messageDto.setSendTo(newUser.getEmail());
		messageDto.setSubject("Credentials For Timesheet");

		Map<String,Object> map = new HashMap<>();
		map.put("company",newUser.getOrganizationName());
		map.put("email",newUser.getEmail());
		map.put("password",newUser.getPassword());
		messageDto.setTextBody(Util.populateMessageBodyByTemplate(EmailTemplate.REGISTER_EMAIL.getPath(),map));
		notificationService.sendEmail(messageDto);
	}


	public ApiResponse<User> getUsersByOrganizationName(String organizationName){
		List<User> users = userDaoRepository.getUsersByOrganizationName(organizationName);
		if(users != null){
			return new ApiResponse<>(200,"Users found",users);
		}
		else{
			return new ApiResponse<>(404,"Users not found",null);
		}
	}

	public ApiResponse deleteUser(Long id){
		Optional<User> user = userDaoRepository.findById(id);
		if(user.isPresent()){
			ApplicantForm applicantForm = applicantFormRepository.getApplicantFormByEmail(user.get().getEmail());
			if(applicantForm != null){
				applicantFormRepository.deleteById(applicantForm.getId());
			}
			userDaoRepository.deleteById(id);
			return new ApiResponse(200,"User Deleted successfully",null);
		}
		else{
			return new ApiResponse(404,"User not found",null);
		}
	}

	public ApiResponse<User> getUserById(Long id){
		Optional<User> user = userDaoRepository.findById(id);
		if(user.isPresent()){

			return new ApiResponse<>(200,"User found",user.get());
		}
		else{
			return new ApiResponse<>(404,"User not found",null);
		}
	}

	public String getAlphaNumericString(int n) {

		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index
					= (int) (AlphaNumericString.length()
					* Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString
					.charAt(index));
		}

		return sb.toString();
	}




}
