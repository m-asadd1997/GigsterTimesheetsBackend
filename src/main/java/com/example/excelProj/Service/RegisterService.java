package com.example.excelProj.Service;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.RegisterDTO;
import com.example.excelProj.Model.Register;
import com.example.excelProj.Repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public ApiResponse<Register> saveRegistration(RegisterDTO registerDTO){
        Register register = new Register();
        register.setEmail(registerDTO.getEmail());
        register.setOrganizationName(registerDTO.getOrganizationName());
        register.setPassword(bcryptEncoder.encode(registerDTO.getPassword()));

        return new ApiResponse<>(HttpStatus.OK.value(), "User registered successfully.",registerRepository.save(register));
    }
}
