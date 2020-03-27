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

    @GetMapping("/{organizationName}")
    public  ApiResponse getCompany(@PathVariable("organizationName") String organizationName){
        return  companyProfileService.getCompanyById(organizationName);
    }

    @PutMapping("/{id}")
    public ApiResponse editCompany(@PathVariable("id") Long id,@RequestBody CompanyProfileDTO companyProfileDTO){
        return companyProfileService.editCompanyProfile(id,companyProfileDTO);
    }
}
