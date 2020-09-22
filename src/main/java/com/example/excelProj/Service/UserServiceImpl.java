package com.example.excelProj.Service;

import com.example.excelProj.Model.ApplicantForm;

import com.example.excelProj.Repository.ApplicantFormRepository;

import com.example.excelProj.Repository.UserDaoRepository;
import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.UserDto;
import com.example.excelProj.Model.User;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


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
			newUser.setPassword(bcryptEncoder.encode(userDto.getPassword()));
			newUser.setUserType(userDto.getUserType());
			newUser.setActive(true);
			trigerEmail(userDto.getEmail(),userDto.getPassword(),userDto.getUserType());
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
		User founduser = userDaoRepository.findByEmail(user.getEmail());

		if(founduser == null) {
		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setName(user.getName());
		newUser.setOrganizationName(user.getOrganizationName());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setUserType(user.getUserType());
		newUser.setActive(true);
		if(user.getUserType().toLowerCase().equals("employee")  || user.getUserType().toLowerCase().equals("supervisor")){
			trigerEmail(user.getEmail(),user.getPassword(),user.getUserType());
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",	userDaoRepository.save(newUser));//return ;
	}else if(founduser != null){
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


	public ApiResponse<String> trigerEmail(String recevierEmail,String password,String userType) {
		User user=userDaoRepository.findByEmail(recevierEmail);
		if(user == null){
			sendEmail(recevierEmail,password,userType);
			return new ApiResponse<>(200,"Email Send Successfully",null);
		}
		return new ApiResponse<>(404,"User Already Exists","User Already Exists");


	}

	void sendEmail(String recevierEmail,String password,String userType) {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(recevierEmail);

		msg.setSubject("Credentials For Timesheet Application as "+userType);
		msg.setText("Email: "+ recevierEmail + "\n " +"Password: " + password);


		javaMailSender.send(msg);

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




}
