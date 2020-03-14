package com.example.excelProj.Service;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.ClientFormDTO;
import com.example.excelProj.Model.ActivityLogs;
import com.example.excelProj.Model.ApplicantForm;
import com.example.excelProj.Model.ClientData;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.ActivityLogsRepository;
import com.example.excelProj.Repository.ApplicantFormRepository;
import com.example.excelProj.Repository.ClientDataRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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



    public ApplicantForm save(ApplicantForm applicantForm) {
        User user = userDaoRepository.findByEmail(applicantForm.getCheckEmail());

        ApplicantForm applicantForm1 = applicationFormRepository.getApplicantFormByEmail(applicantForm.getCheckEmail());
        if (applicantForm1 == null){
            user.setUserImage(applicantForm.getUserImage());
            userDaoRepository.save(user);
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
            user.setUserImage(applicantForm.getUserImage());
            userDaoRepository.save(user);
            return applicationFormRepository.save(applicantForm1);
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

    public ApiResponse<String> trigerEmail(Long id, String recevierEmail) {
        Optional<ApplicantForm> applicantForm=applicationFormRepository.findById(id);
        if(applicantForm.isPresent()){
            sendEmail(recevierEmail);
            return new ApiResponse<>(200,"Email Send Successfully",null);
        }
        return new ApiResponse<>(404,"Applicant doesnot exsist","didnot Find the Applicant");


    }

    void sendEmail(String recevierEmail) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(recevierEmail);

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }


    public ApiResponse<ApplicantForm> getPortfolio(Long id){
        Optional<ApplicantForm> applicantForm=applicationFormRepository.findById(id);
        if(applicantForm.isPresent()){
            return new ApiResponse<>(200,"Applicant found successfully",applicantForm.get());
        }
        return new ApiResponse<ApplicantForm>(404,"Applicant not Found",null);
    }

    public ApiResponse getByCheckEmail(String checkEmail){
        return new ApiResponse<>(200,"Profile found",applicationFormRepository.getApplicantFormByEmail(checkEmail));
    }

}
