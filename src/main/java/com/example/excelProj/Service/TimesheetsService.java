package com.example.excelProj.Service;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.TimesheetsDTO;
import com.example.excelProj.Model.Timesheets;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.TimesheetsRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class TimesheetsService {

    @Autowired
    TimesheetsRepository timesheetsRepository;

    @Autowired
    UserDaoRepository userDaoRepository;

   @Autowired
   JavaMailSender javaMailSender;

    public ApiResponse saveTimesheets(TimesheetsDTO timesheetsDTO){

        Timesheets timesheets = new Timesheets();

        timesheets.setMondayStartTime(timesheetsDTO.getMondayStartTime());
        timesheets.setMondayEndTime(timesheetsDTO.getMondayEndTime());
        timesheets.setTuesdayStartTime(timesheetsDTO.getTuesdayStartTime());
        timesheets.setTuesdayEndTime(timesheetsDTO.getTuesdayEndTime());
        timesheets.setWednesdayStartTime(timesheetsDTO.getWednesdayStartTime());
        timesheets.setWednesdayEndTime(timesheetsDTO.getWednesdayEndTime());
        timesheets.setThursdayStartTime(timesheetsDTO.getThursdayStartTime());
        timesheets.setThursdayEndTime(timesheetsDTO.getThursdayEndTime());
        timesheets.setFridayStartTime(timesheetsDTO.getFridayStartTime());
        timesheets.setFridayEndTime(timesheetsDTO.getFridayEndTime());
        timesheets.setSaturdayStartTime(timesheetsDTO.getSaturdayStartTime());
        timesheets.setSaturdayEndTime(timesheetsDTO.getSaturdayEndTime());
        timesheets.setSundayStartTime(timesheetsDTO.getSundayStartTime());
        timesheets.setSundayEndTime(timesheetsDTO.getSundayEndTime());
        timesheets.setStatus(timesheetsDTO.getStatus());
        timesheets.setUser(timesheetsDTO.getUser());
        timesheets.setOrganizationName(getOrganizationNameOfLoggedInUser());
        timesheets.setWeekId(timesheetsDTO.getWeekId());
        timesheets.setModifiedBy(getNameOfModifier());
        timesheets.setDateSubmitted(timesheetsDTO.getDateSubmitted());
        timesheets.setSupervisor(null);
        timesheets.setModifiedId(getIdOfLoggedInUser());
        timesheets.setModifiedByImage(getImageOfModifier());
        timesheets.setSendFlag("NO");
        return new ApiResponse(HttpStatus.OK.value(), "Timesheet saved successfully.",timesheetsRepository.save(timesheets));


    }


    public String getOrganizationNameOfLoggedInUser()
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        User user = userDaoRepository.findByEmail(username);
        return  user.getOrganizationName();

    }

    public Long getIdOfLoggedInUser()
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        User user = userDaoRepository.findByEmail(username);
        return user.getId();
    }

    public String getNameOfModifier()
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        User user = userDaoRepository.findByEmail(username);
        return  user.getName();

    }

    public byte[] getImageOfModifier()
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        User user = userDaoRepository.findByEmail(username);
        return  user.getUserImage();

    }



    public ApiResponse getTimesheetsByOrganizationName(String organizationName){
        return new ApiResponse(HttpStatus.OK.value(), "Timesheets found successfully",timesheetsRepository.getByOrganizationName(organizationName));
    }

    public ApiResponse modifyTimesheets(Long id, TimesheetsDTO timesheetsDTO){
        Optional<Timesheets> timesheets1 = timesheetsRepository.findById(id);
        if(timesheets1.isPresent()) {
            Timesheets timesheets = timesheets1.get();

            timesheets.setMondayStartTime(timesheetsDTO.getMondayStartTime());
            timesheets.setMondayEndTime(timesheetsDTO.getMondayEndTime());
            timesheets.setTuesdayStartTime(timesheetsDTO.getTuesdayStartTime());
            timesheets.setTuesdayEndTime(timesheetsDTO.getTuesdayEndTime());
            timesheets.setWednesdayStartTime(timesheetsDTO.getWednesdayStartTime());
            timesheets.setWednesdayEndTime(timesheetsDTO.getWednesdayEndTime());
            timesheets.setThursdayStartTime(timesheetsDTO.getThursdayStartTime());
            timesheets.setThursdayEndTime(timesheetsDTO.getThursdayEndTime());
            timesheets.setFridayStartTime(timesheetsDTO.getFridayStartTime());
            timesheets.setFridayEndTime(timesheetsDTO.getFridayEndTime());
            timesheets.setSaturdayStartTime(timesheetsDTO.getSaturdayStartTime());
            timesheets.setSaturdayEndTime(timesheetsDTO.getSaturdayEndTime());
            timesheets.setSundayStartTime(timesheetsDTO.getSundayStartTime());
            timesheets.setSundayEndTime(timesheetsDTO.getSundayEndTime());
            timesheets.setStatus(timesheetsDTO.getStatus());
            timesheets.setUser(timesheetsDTO.getUser());
            timesheets.setOrganizationName(getOrganizationNameOfLoggedInUser());
            timesheets.setWeekId(timesheetsDTO.getWeekId());
            timesheets.setModifiedBy(getNameOfModifier());
            timesheets.setModifiedId(getIdOfLoggedInUser());
            timesheets.setModifiedByImage(getImageOfModifier());
            timesheets.setSupervisor(timesheetsDTO.getSupervisor());
            timesheets.setComments(timesheetsDTO.getComments());
            timesheets.setDateSubmitted(timesheetsDTO.getDateSubmitted());


            return new ApiResponse((HttpStatus.OK.value()), "Timesheet modified successfully.", timesheetsRepository.save(timesheets));
        }
        else
            {
                return new ApiResponse((HttpStatus.NOT_FOUND.value()), "Error Modifying Timesheet.", null
                );
        }

    }

    public ApiResponse getTimeSheetsForLoggedinEmployee(Long id){
        return new ApiResponse<>((HttpStatus.OK.value()), "Timesheets for Employee found successfully.",timesheetsRepository.getTimeSheetsForLoggedinEmployee(id));
    }

    public ApiResponse getTimeSheetsForLoggedinSupervisor(Long id){
        return new ApiResponse<>((HttpStatus.OK.value()), "Timesheets for Supervisor found successfully.",timesheetsRepository.getTimeSheetsForLoggedinSupervisor(id));
    }

    public ApiResponse getApprovedTimesheets(Long id){
        return new ApiResponse<>((HttpStatus.OK.value()), "Approved Timesheets found successfully.",timesheetsRepository.getApprovedTimesheets(id));
    }

    public ApiResponse modifyStatusOnly(Long id,String changeStatus){
        Optional<Timesheets> timesheets1 = timesheetsRepository.findById(id);
        if(timesheets1.isPresent()){
        Timesheets timesheets = timesheets1.get();
        timesheets.setStatus(changeStatus);
        return  new ApiResponse((HttpStatus.OK.value()), "Status modified successfully.",timesheetsRepository.save(timesheets));
    }
        else{
            return  new ApiResponse((HttpStatus.NOT_FOUND.value()), "Error Modifying Status.",null);
        }
    }

    public  ApiResponse getById(Long id){
        Optional<Timesheets> timesheets = timesheetsRepository.findById(id);
            if (timesheets.isPresent()){
                return new ApiResponse((HttpStatus.OK.value()), "Timesheet found successfully.",timesheets.get());

            }
            else{
                return new ApiResponse((HttpStatus.NOT_FOUND.value()), "Timesheet Not found.",null);
            }

    }

    public ApiResponse getTimesheetsByWeekId(Long id, Long userId){
        Timesheets timesheets = timesheetsRepository.getTimesheetsByWeekId(id,userId);
        if(timesheets != null){
            return new ApiResponse<>((HttpStatus.OK.value()), "Timesheet found successfully.",timesheets);
        }
        else{
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(),"Timesheet not found",null);
        }
    }

    void sendEmail(String recevierEmail) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(recevierEmail);

        msg.setSubject("Timesheet Received");
        msg.setText("Timesheet received for status update");

        javaMailSender.send(msg);

    }

    public ApiResponse sendTimesheetToSupervisor(Long id, TimesheetsDTO timesheetsDTO){
        Optional<Timesheets> timesheets1 = timesheetsRepository.findById(id);
        if(timesheets1.isPresent()) {
            Timesheets timesheets = timesheets1.get();
            timesheets.setSendFlag("YES");
            timesheets.setSupervisor(timesheetsDTO.getSupervisor());
            timesheets.setStatus(timesheetsDTO.getStatus());
            timesheets.setDateSubmitted(timesheetsDTO.getDateSubmitted());
            sendEmail(timesheetsDTO.getSupervisor().getEmail());


            return new ApiResponse((HttpStatus.OK.value()), "Timesheet send successfully.", timesheetsRepository.save(timesheets));

        }
        else{
            return new ApiResponse((HttpStatus.NOT_FOUND.value()), "Timesheet Not found.",null);

        }
    }

}
