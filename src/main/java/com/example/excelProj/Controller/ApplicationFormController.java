package com.example.excelProj.Controller;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.ClientFormDTO;
import com.example.excelProj.Model.ActivityLogs;
import com.example.excelProj.Model.ApplicantForm;
import com.example.excelProj.Model.ClientData;
import com.example.excelProj.Service.ApplicationFormService;
import com.example.excelProj.Service.ClientFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApplicationFormController {

    @Autowired
    private ApplicationFormService applicationFormService;



    @PostMapping("/applicant-form")
    public ApiResponse<ApplicantForm> createApplicantForm(@RequestBody ApplicantForm applicantForm)  {
        if (applicantForm.getId() != null) {
              // throw new BadRequestAlertException("A new applicantForm cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ApplicantForm result = applicationFormService.save(applicantForm);

        return new ApiResponse<>(200,"success",result);
    }


    @GetMapping("/applicant-form")
    public List<ApplicantForm> getAllApplicantForm(){
        //this.sendEmail();
        return this.applicationFormService.getAllApplicantForm();
    }

    @PutMapping("/applicant-form/{id}")
    public ApiResponse<ApplicantForm> update(@PathVariable ("id") Long id, @RequestBody ApplicantForm applicantForm){


        return applicationFormService.update(id,applicantForm);


    }
    @DeleteMapping("/applicant-form/{id}")
    public ApiResponse<ApplicantForm> delete(@PathVariable ("id") Long id){
        return applicationFormService.delete(id);
    }


    @PostMapping("/applicant-form/{id}/{email}")
    public ApiResponse<String> trigerEmail(@PathVariable("id") Long id, @PathVariable("email") String recevierEmail){
        return  applicationFormService.trigerEmail(id,recevierEmail);
    }
    @GetMapping("/applicant-form/{id}")
    public ApiResponse<ApplicantForm> getPortfolio(@PathVariable("id") Long id){
        return applicationFormService.getPortfolio(id);

    }

    @GetMapping("/checkemail/{checkEmail}")
    public ApiResponse<ApplicantForm> getByCheckEmail(@PathVariable("checkEmail") String checkEmail){
        return  applicationFormService.getByCheckEmail(checkEmail);
    }




}
