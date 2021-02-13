//package com.example.excelProj;
//
//import com.example.excelProj.Model.User;
//import com.example.excelProj.Repository.UserDaoRepository;
//import com.example.excelProj.Service.UserServiceImpl;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ExcelProjApplicationTests {
//
////	@Autowired
////	UserServiceImpl userService;
////
////	@MockBean
////	UserDaoRepository userDaoRepository;
//
//
////	@Test
////	public void getUsersTest(){
////		when(userDaoRepository.getUsersByOrganizationName("testOrg1")).thenReturn(Stream
////				.of(new User(1L,"abc.com","test1","123",true,"EMPLOYEE","testOrg1",null,true),
////					new User(2L,"abcdefg.com","test2","123",true,"SUPERVISOR","testOrg1",null,true)).collect(Collectors.toList()));
////
////		assertEquals(2,userDaoRepository.getUsersByOrganizationName("testOrg1").size());
////	}
//
//
////	@Test
////	public void contextLoads() {
////	}
//
//}
