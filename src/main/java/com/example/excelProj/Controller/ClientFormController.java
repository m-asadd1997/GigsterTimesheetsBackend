package com.example.excelProj.Controller;

import com.example.excelProj.Dto.ClientFormDTO;
import com.example.excelProj.Model.ActivityLogs;
import com.example.excelProj.Model.ClientData;
import com.example.excelProj.Service.ClientFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/data")
public class ClientFormController {

    @Autowired
    ClientFormService dataService;


    @PostMapping(value = "/")
    public String postUser(@RequestBody ClientFormDTO clientFormDTO){
        return dataService.saveUserData(clientFormDTO);
    }

    @DeleteMapping(value = "/{id}")
    public List<ClientData> deleteUser(@PathVariable Long id)
    {
        return dataService.deleteUser(id);
    }

    @DeleteMapping(value = "/user/{id}")
    public List<ClientData> deleteUserData(@PathVariable Long id)
    {
        return dataService.deleteUserDataIfUserLoggedIn(id);
    }

    @GetMapping(value ="/")
    public List<ClientData> getUsersData()
    {
        return dataService.getUsersData();

    }

    @GetMapping(value ="/active")
    public List<ClientData> getActive()
    {
        return dataService.getActiveUserData();

    }
    @PutMapping( value = "/{id}")
    public String updateUser(@PathVariable Long id , @RequestBody ClientFormDTO clientFormDTO)
    {
        return this.dataService.updateUser(id , clientFormDTO);
    }

    @GetMapping( value = "/{id}")
    public ClientData getUserById(@PathVariable Long id)
    {
        return this.dataService.getUserById(id);
    }

    @GetMapping(value = "/activityLogs/{id}")
    public List<ActivityLogs> getActivityLogs(@PathVariable Long id){
        return this.dataService.getActivityLogs(id);
    }

    @DeleteMapping(value = "/reactive/{id}")
    public List<ClientData> reactiveUser(@PathVariable Long id)
    {
        return dataService.reactiveUser(id);
    }

//    @GetMapping(value ="/")
//    public List<UserData> getUserDataByIfUserIs()
//    {
//        return dataService.getUsersData();
//
//    }
}
