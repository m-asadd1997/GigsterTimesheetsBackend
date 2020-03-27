package com.example.excelProj.Service;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.CompanyProfileDTO;
import com.example.excelProj.Model.CompanyProfile;
import com.example.excelProj.Repository.CompanyProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyProfileService {

    @Autowired
    CompanyProfileRepository companyProfileRepository;

    public ApiResponse saveCompanyProfile(CompanyProfileDTO companyProfileDTO){
        CompanyProfile companyProfile = companyProfileRepository.findByCompanyName(companyProfileDTO.getCompanyName());

        if(companyProfile != null){
            return new ApiResponse(400,"Already Exists",null);
        }
        else{
            CompanyProfile companyProfile2 = new CompanyProfile();
            companyProfile2.setCompanyName(companyProfileDTO.getCompanyName());
            companyProfile2.setBillingAddress(companyProfileDTO.getBillingAddress());
            companyProfile2.setContactName(companyProfileDTO.getContactName());
            companyProfile2.setContactTitle(companyProfileDTO.getContactTitle());
            companyProfile2.setCorporateAddress(companyProfileDTO.getCorporateAddress());
            companyProfile2.setRoles(companyProfileDTO.getRoles());
            companyProfile2.setStartingDayOfWeek(companyProfileDTO.getStartingDayOfWeek());
            companyProfile2.setCompanyimage(companyProfileDTO.getCompanyimage());

            return new ApiResponse<>(HttpStatus.OK.value(), "Company Profile saved successfully.",companyProfileRepository.save(companyProfile2));
        }



    }

    public ApiResponse getCompanyById(String oranizationName){
        CompanyProfile company = companyProfileRepository.findByCompanyName(oranizationName);
        if(company != null){
            return new ApiResponse(200,"Company found",company);
        }
        else{
            return new ApiResponse(403,"Company Not Found",null);
        }

    }

    public ApiResponse editCompanyProfile(Long id,CompanyProfileDTO companyProfileDTO){
        Optional<CompanyProfile> companyProfile = companyProfileRepository.findById(id);
        if(companyProfile.isPresent()){
            CompanyProfile companyProfile2 = companyProfile.get();
            companyProfile2.setCompanyName(companyProfileDTO.getCompanyName());
            companyProfile2.setBillingAddress(companyProfileDTO.getBillingAddress());
            companyProfile2.setContactName(companyProfileDTO.getContactName());
            companyProfile2.setContactTitle(companyProfileDTO.getContactTitle());
            companyProfile2.setCorporateAddress(companyProfileDTO.getCorporateAddress());
            companyProfile2.setRoles(companyProfileDTO.getRoles());
            companyProfile2.setStartingDayOfWeek(companyProfileDTO.getStartingDayOfWeek());
            companyProfile2.setCompanyimage(companyProfileDTO.getCompanyimage());
            return new ApiResponse<>(HttpStatus.OK.value(), "Company Profile modified successfully.",companyProfileRepository.save(companyProfile2));
        }

        else{
            return new ApiResponse<>(HttpStatus.OK.value(), "Company Profile not found.",null);
        }
    }
}
