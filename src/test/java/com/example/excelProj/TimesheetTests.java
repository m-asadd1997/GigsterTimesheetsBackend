//package com.example.excelProj;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.TimesheetsDTO;
import com.example.excelProj.Dto.UserDto;
import com.example.excelProj.Model.Timesheets;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.TimesheetsRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import com.example.excelProj.Service.TimesheetsService;
import com.example.excelProj.Service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TimesheetTests {


//    TimesheetsService timesheetsService = new TimesheetsService();

//    @Autowired
//    private UserServiceImpl userService;
//
//    @MockBean
//    private UserDaoRepository userDaoRepository;

//    @MockBean
//    private TimesheetsRepository repository;

//    @Test
//    public void testSaveTimesheetMethod(){
//        TimesheetsDTO timesheet = new TimesheetsDTO(1L,"00:00","00:00","00:00","00:00","00:00","00:00","00:00","00:00","00:00","00:00","00:00",
//                "00:00","00:00","00:00","Pending",new User("a.com","asad","123",true,"EMPLOYEE","Org",null,false),null
//                ,"1/1/2021","no",null,"00:00","00:00","00:00","00:00","00:00","00:00"
//                ,"00:00","00:00","00:00","00:00","00:00","00:00","00:00","00:00","00:00","00:00","00:00","00:00","00:00","00:00","00:00","00:00");
//
////      Timesheets timesheetsModel = new Timesheets()  doReturn(timesheet).when(repository).save(any());
//     //   when(repository.save(Mockito.any(Timesheets.class))).thenReturn(new Timesheets());
//        ApiResponse returnedResponse = timesheetsService.saveTimesheets(timesheet);
////        assertNotNull(returnedResponse, "Null Error");
//        assertEquals(200,returnedResponse.getStatus());
//    }

//    @Test
//    public void testSaveUser(){
//        User user = new User("qureshiasad1000@gmail.com","Asad","123",true,"ADMIN","Org",null,false);
//        UserDto userDto = new UserDto("qureshiasad1000@gmail.com","Asad","123",true,"ADMIN","Org",false);
//        when(userDaoRepository.save(user)).thenReturn(user);
//        assertEquals(200,userService.save(userDto).getStatus());
//    }
//}
