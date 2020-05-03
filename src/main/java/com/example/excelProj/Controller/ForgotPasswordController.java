package com.example.excelProj.Controller;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.ForgotPasswordDTO;
import com.example.excelProj.Service.ForgotPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/forgotpassword")
public class ForgotPasswordController {

    @Autowired
    ForgotPasswordService forgotPasswordService;

    @PostMapping("/empandsup")
    public ApiResponse getPasswordForEmpAndSup(@RequestBody ForgotPasswordDTO forgotPasswordDTO){
        return forgotPasswordService.getUserTypeAndMail(forgotPasswordDTO);
    }

    @PostMapping("/checkexpiry")
    public ApiResponse checkTokenExpiry(@RequestBody ForgotPasswordDTO forgotPasswordDTO){
        return  forgotPasswordService.checkTokenExpiry(forgotPasswordDTO);
    }

    @PostMapping("/savepass")
    public ApiResponse saveNewPassword(@RequestBody ForgotPasswordDTO forgotPasswordDTO){
        return forgotPasswordService.saveNewPassword(forgotPasswordDTO);
    }


}
