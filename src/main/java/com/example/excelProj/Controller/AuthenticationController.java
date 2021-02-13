package com.example.excelProj.Controller;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Commons.AuthToken;
import com.example.excelProj.Config.JwtTokenUtil;
import com.example.excelProj.Dto.LoginUser;
import com.example.excelProj.Dto.RegisterDTO;
import com.example.excelProj.Dto.UserDto;
import com.example.excelProj.Model.ApplicantForm;
import com.example.excelProj.Model.Register;
import com.example.excelProj.Model.User;
import com.example.excelProj.Service.ApplicationFormService;
import com.example.excelProj.Service.RegisterService;
import com.example.excelProj.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ApplicationFormService applicationFormService;

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ApiResponse<AuthToken> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));

        final User user = userService.findOne(loginUser.getUsername());
        if(user!=null){
            final String token = jwtTokenUtil.generateToken(user);

            return new ApiResponse<>(200, "success",new AuthToken(user.getId(),token,user.getName(),user.getUserType(),user.getEmail(),user.getOrganizationName(),user.getUserImage(),user.getPaid()));
        }

      return new ApiResponse<>(404, "RECORD NOT FOUND",new AuthToken("","","",""));
    }


    @PostMapping("/user")
    public ApiResponse<User> saveUser(@RequestBody UserDto user){

        return userService.save(user);
    }

    @RequestMapping(value = "/getusers", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return this.userService.findAll();
    }

    @PutMapping("/update/{id}")
    public ApiResponse<User> updateUser(@PathVariable("id") Long id,@RequestBody UserDto user){

        return new ApiResponse<>(HttpStatus.OK.value(),"User updated successfully",userService.update(user,id));
    }

//    @DeleteMapping("/delete/{id}")
//    public  ApiResponse<User> getActiveUsers(@PathVariable("id") Long id){
//        return userService.delete(id);
//    }

    @DeleteMapping("/delete/{id}")
    public List<User> deleteUserById(@PathVariable Long id){
        return this.userService.getActiveUsers(id);

    }

    @GetMapping("/view-portfolio/{id}")
    public ApiResponse<ApplicantForm> getPortfolio(@PathVariable("id") Long id){
        return applicationFormService.getPortfolio(id);

    }

    @GetMapping("/")
    public String getdata(){
        return "hello runing";
    }

    @PostMapping("/register")
    public ApiResponse<Register> saveRegister(@RequestBody RegisterDTO registerDTO){
        return registerService.saveRegistration(registerDTO);
    }

    @GetMapping("/{organizationName}")
    public ApiResponse<User> getSupervisors(@PathVariable("organizationName") String organizationName){
        return userService.getSupervisorsByOrganizationName(organizationName);
    }

    @GetMapping("/user/{email}")
    public User getUserByEmail(@PathVariable("email") String email){
        return userService.findOne(email);
    }

    @GetMapping("/getusers/{organizationName}")
    public ApiResponse getUsersByOrganizationName(@PathVariable("organizationName") String organizationName){
        return userService.getUsersByOrganizationName(organizationName);
    }

    @DeleteMapping("/deleteusers/{id}")
    public ApiResponse deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }

    @GetMapping("/getbyid/{id}")
    public ApiResponse getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/registeradmin")
    public ApiResponse<User> registerUser(@RequestBody UserDto userDto){
        return userService.registerUser(userDto);
    }


}
