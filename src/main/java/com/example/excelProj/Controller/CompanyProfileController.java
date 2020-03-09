package com.example.excelProj.Controller;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.CompanyProfileDTO;
import com.example.excelProj.Model.CompanyProfile;
import com.example.excelProj.Service.CompanyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/companyprofile")
public class CompanyProfileController {

    @Autowired
    CompanyProfileService companyProfileService;

    @PostMapping("/")
    public ApiResponse<CompanyProfile> saveCompanyProfile(@RequestBody CompanyProfileDTO companyProfileDTO){
        return companyProfileService.saveCompanyProfile(companyProfileDTO);
    }
}
