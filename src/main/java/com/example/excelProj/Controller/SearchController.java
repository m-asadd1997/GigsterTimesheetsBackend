package com.example.excelProj.Controller;

import com.example.excelProj.Dto.SearchDTO;
import com.example.excelProj.Model.ClientData;
import com.example.excelProj.Service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/search")

public class SearchController {
    @Autowired
    SearchService searchService;

    @PostMapping("/data")
    public List<ClientData> searchData(@RequestBody SearchDTO searchDTO){

    return this.searchService.searchAllData(searchDTO);
    }
}
