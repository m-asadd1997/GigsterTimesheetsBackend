package com.example.excelProj.Service;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.CompanyProfileDTO;
import com.example.excelProj.Model.CompanyProfile;
import com.example.excelProj.Repository.CompanyProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CompanyProfileService {

    @Autowired
    CompanyProfileRepository companyProfileRepository;

    public ApiResponse saveCompanyProfile(CompanyProfileDTO companyProfileDTO){
        CompanyProfile companyProfile = new CompanyProfile();
        companyProfile.setCompanyName(companyProfileDTO.getCompanyName());
        companyProfile.setBillingAddress(companyProfileDTO.getBillingAddress());
        companyProfile.setContactName(companyProfileDTO.getContactName());
        companyProfile.setContactTitle(companyProfileDTO.getContactTitle());
        companyProfile.setCorporateAddress(companyProfileDTO.getCorporateAddress());
        companyProfile.setRoles(companyProfileDTO.getRoles());
        companyProfile.setStartingDayOfWeek(companyProfileDTO.getStartingDayOfWeek());
        companyProfile.setCompanyimage(companyProfileDTO.getCompanyimage());

        return new ApiResponse<>(HttpStatus.OK.value(), "Company Profile saved successfully.",companyProfileRepository.save(companyProfile));

    }
}
