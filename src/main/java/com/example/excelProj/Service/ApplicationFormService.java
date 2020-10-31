package com.example.excelProj.Service;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.ClientFormDTO;
import com.example.excelProj.Model.*;
import com.example.excelProj.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//import java.text.SimpleDateFormat;


@Service
public class ApplicationFormService {

 @Autowired
 private ApplicantFormRepository applicationFormRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    UserDaoRepository userDaoRepository;

    @Autowired
    TimesheetsRepository timesheetsRepository;

    @Value("${spring.mail.username}")
    private String username;

    public ApplicantForm save(ApplicantForm applicantForm) {
        User user = userDaoRepository.findByEmail(applicantForm.getCheckEmail());

        ApplicantForm applicantForm1 = applicationFormRepository.getApplicantFormByEmail(applicantForm.getCheckEmail());
        if (applicantForm1 == null){
            user.setUserImage(applicantForm.getUserImage());
            userDaoRepository.save(user);
            setModifierImage(user.getId(),applicantForm.getUserImage());
            return applicationFormRepository.save(applicantForm);
        }
        else{
            applicantForm1.setUserImage(applicantForm.getUserImage());
            applicantForm1.setAddress(applicantForm.getAddress());
            applicantForm1.setCitizenship(applicantForm.getCitizenship());
            applicantForm1.setDateOfBirth(applicantForm.getDateOfBirth());
            applicantForm1.setPlaceOfBirth(applicantForm.getPlaceOfBirth());
            applicantForm1.setEmail(applicantForm.getEmail());
            applicantForm1.setEmployeeApplication(applicantForm.getEmployeeApplication());
            applicantForm1.setEmployeeIdentification(applicantForm.getEmployeeIdentification());
            applicantForm1.setEmployeeOrientation(applicantForm.getEmployeeOrientation());
            applicantForm1.setVisaDetails(applicantForm.getVisaDetails());
            applicantForm1.setMedicalClearance(applicantForm.getMedicalClearance());
            applicantForm1.setEmployeeWellness(applicantForm.getEmployeeWellness());
            applicantForm1.setGender(applicantForm.getGender());
            applicantForm1.setName(applicantForm.getName());
            applicantForm1.setEmergencyContact(applicantForm.getEmergencyContact());
            applicantForm1.setResume(applicantForm.getResume());
            applicantForm1.setResumeContentType(applicantForm.getResumeContentType());
            applicantForm1.setUserImageContentType(applicantForm.getUserImageContentType());
            applicantForm1.setPhone(applicantForm.getPhone());
            applicantForm1.setUserImage(applicantForm.getUserImage());
            user.setUserImage(applicantForm.getUserImage());
            setModifierImage(user.getId(),applicantForm1.getUserImage());
            userDaoRepository.save(user);
            return applicationFormRepository.save(applicantForm1);
        }


    }


    public void setModifierImage(Long id,byte[] image){
        List<Timesheets> timesheets = timesheetsRepository.getTimesheetsByModifiedId(id);
        if(!timesheets.isEmpty()){
            for (Timesheets timesheets1 : timesheets){
                timesheets1.setModifiedByImage(image);
                timesheetsRepository.save(timesheets1);
            }
        }
    }


    public List<ApplicantForm> getAllApplicantForm(){
       List<ApplicantForm>  applicantForm=applicationFormRepository.findAll();
        return applicantForm;

    }


    public ApiResponse<ApplicantForm> update(Long id,ApplicantForm applicantForm){
        Optional<ApplicantForm> updatedRecord=applicationFormRepository.findById(id);
        if(updatedRecord.isPresent()){
            applicantForm.setId(id);
            return new ApiResponse<ApplicantForm>(200,"updated",applicationFormRepository.save(applicantForm));

        }
        return new ApiResponse<ApplicantForm>(404,"Record Not Found",null);
    }

    public ApiResponse<ApplicantForm> delete(Long id){
        Optional<ApplicantForm> applicantForm=applicationFormRepository.findById(id);
        if(applicantForm.isPresent()){
            applicationFormRepository.deleteById(id);
            return new ApiResponse<ApplicantForm>(200,"Deleted",null);
        }
        else{

            return new ApiResponse<ApplicantForm>(404,"Record not found",null);

        }

    }


    public ApiResponse<ApplicantForm> getPortfolio(Long id){
        Optional<ApplicantForm> applicantForm=applicationFormRepository.findById(id);
        if(applicantForm.isPresent()){
            return new ApiResponse<>(200,"Applicant found successfully",applicantForm.get());
        }
        return new ApiResponse<ApplicantForm>(404,"Applicant not Found",null);
    }

    public ApiResponse getByCheckEmail(String checkEmail){
        ApplicantForm applicantForm = applicationFormRepository.getApplicantFormByEmail(checkEmail);
        if(applicantForm != null) {
            return new ApiResponse<>(200, "Profile found", applicantForm);
        }else{
            return new ApiResponse<>(400, "Profile not found", null);
        }
    }

}
