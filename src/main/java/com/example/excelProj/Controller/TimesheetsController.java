package com.example.excelProj.Controller;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.TimesheetsDTO;
import com.example.excelProj.Model.Timesheets;
import com.example.excelProj.Service.TimesheetsService;
import com.itextpdf.text.pdf.codec.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Time;

@RestController
@CrossOrigin
@RequestMapping("/api/timesheets")
public class TimesheetsController {

    @Autowired
    TimesheetsService timesheetsService;

    @PostMapping("/")
    public ApiResponse<Timesheets> saveTimesheets(@RequestBody TimesheetsDTO timesheetsDTO){
        return timesheetsService.saveTimesheets(timesheetsDTO);
    }

    @GetMapping("/user/{organizationName}")
    public ApiResponse<Timesheets> getTimesheets(@PathVariable("organizationName") String organizationName){
        return timesheetsService.getTimesheetsByOrganizationName(organizationName);
    }

    @PutMapping("/{id}")
    public ApiResponse<Timesheets> modifyTimesheets(@PathVariable("id") Long id,@RequestBody TimesheetsDTO timesheetsDTO){
        return timesheetsService.modifyTimesheets(id,timesheetsDTO);
    }

    @GetMapping("/employee/{id}")
    public ApiResponse<Timesheets> getForEmployee(@PathVariable("id") Long id){
        return timesheetsService.getTimeSheetsForLoggedinEmployee(id);
    }

    @GetMapping("/supervisor/{id}")
    public ApiResponse<Timesheets> getForSupervisor(@PathVariable("id") Long id){
        return timesheetsService.getTimeSheetsForLoggedinSupervisor(id);
    }

    @GetMapping("/{changeStatus}/{id}")
        public ApiResponse<Time> modifyStatusOnly(@PathVariable("id") Long id,@PathVariable("changeStatus") String changeStatus) {
        return timesheetsService.modifyStatusOnly(id,changeStatus);
    }

    @GetMapping("/addcomment/{comment}/{id}")
    public ApiResponse<Time> modifyStatusAndCommentOnly(@PathVariable("id") Long id,@PathVariable("comment") String comment) {
        return timesheetsService.disapproveAndAddComment(id,comment);
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable("id") Long id){
        return timesheetsService.getById(id);
    }

    @GetMapping("/weekid/{id}/{userId}")
    public ApiResponse getTimesheetsByWeekId(@PathVariable("id") Long id,@PathVariable("userId") Long userId){
        return timesheetsService.getTimesheetsByWeekId(id,userId);
    }


    @PutMapping("/sendtosupervisor/{id}")
    public ApiResponse sendToSupervisor(@PathVariable("id") Long id,@RequestBody TimesheetsDTO timesheetsDTO){
        return timesheetsService.sendTimesheetToSupervisor(id,timesheetsDTO);
    }

    @GetMapping("/approved/{id}")
    public ApiResponse getApprovedTimesheets(@PathVariable("id") Long id){
        return timesheetsService.getApprovedTimesheets(id);
    }


    @GetMapping("/downloadpdf/{IsAll}/{id}")
    public ResponseEntity<InputStreamResource> getPDFForTimesheet(@PathVariable("id") Long id,@PathVariable("IsAll") String isAll) throws IOException {
        return timesheetsService.getPDFForTimesheet(id,isAll);
    }





}
