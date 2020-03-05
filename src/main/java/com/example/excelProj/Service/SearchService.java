package com.example.excelProj.Service;

import com.example.excelProj.Dto.SearchDTO;

import com.example.excelProj.Model.ClientData;
import com.example.excelProj.Repository.ClientDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SearchService {
    @Autowired
    ClientDataRepository clientDataRepository;

    public List<ClientData> searchAllData(SearchDTO searchDTO){
        List<ClientData> userData= clientDataRepository.findAll();
        List<ClientData> resultList = new ArrayList<>();
        resultList.addAll(userData);

        if(!StringUtils.isEmpty(searchDTO.getName())){
            resultList = resultList.stream()
                    .filter(p->p.getName().equalsIgnoreCase(searchDTO.getName()))
                    .collect(Collectors.toList());
        }
        if(!StringUtils.isEmpty(searchDTO.getSurname())){
            resultList=resultList.stream()
                    .filter(p->p.getSurname().equalsIgnoreCase(searchDTO.getSurname()))
                    .collect(Collectors.toList());
        }

        if(!StringUtils.isEmpty(searchDTO.getEmail())){
            resultList = resultList.stream()
                    .filter(p->(p.checkAllEmail(searchDTO.getEmail()))                                )
                    .collect(Collectors.toList());
        }

        if(!StringUtils.isEmpty(searchDTO.getStatus())){
            resultList=resultList.stream()
                    .filter(data->data.checkAllStatus(searchDTO.getStatus()))
                    .collect(Collectors.toList());
        }
        if (!StringUtils.isEmpty(searchDTO.getPhoneNumber())){
            resultList=resultList.stream()
                    .filter(data->data.checkAllPhoneNumber(searchDTO.getPhoneNumber()))
                    .collect(Collectors.toList());


        }
        if(!StringUtils.isEmpty(searchDTO.getDate())){
          resultList=resultList.stream()
                    .filter(data->data.getDateOffc().equalsIgnoreCase(searchDTO.getDate()))
                    .collect(Collectors.toList());
        }
        if(!StringUtils.isEmpty(searchDTO.getCheckinDate())){
            resultList=resultList.stream()
                    .filter(data->data.getCheckinDate()!=null && data.getCheckinDate().equalsIgnoreCase(searchDTO.getCheckinDate()))
                    .collect(Collectors.toList());
        }
        if(!StringUtils.isEmpty(searchDTO.getCheckoutDate())){
            resultList=resultList.stream()
                    .filter(data->data.getCheckoutDate()!=null && data.getCheckoutDate().equalsIgnoreCase(searchDTO.getCheckoutDate()))
                    .collect(Collectors.toList());
        }
        if(!StringUtils.isEmpty(searchDTO.getDaysOfRental())){
            resultList=resultList.stream()
                    .filter(data->data.getDaysOfRental()!=null && data.getDaysOfRental().equalsIgnoreCase(searchDTO.getDaysOfRental()))
                    .collect(Collectors.toList());
        }
        if(searchDTO.getoAddyVillas()){
          resultList= resultList.stream()
           .filter(data->searchDTO.getoAddyVillas().equals(data.isoAddyVillas()))
           .collect(Collectors.toList());

        }
        if(searchDTO.getoCliftonCourt()){       // ocliftoncourt
            resultList= resultList.stream()
                    .filter(data->searchDTO.getoCliftonCourt().equals(data.isoCliftonCourt()))
                    .collect(Collectors.toList());

        }
        if(searchDTO.getoCliftonPlace()){                      //
            resultList= resultList.stream()
                    .filter(data->searchDTO.getoCliftonPlace().equals(data.isoCliftonPlace()))
                    .collect(Collectors.toList());

        }
        if(searchDTO.getoEmbassyGardens()){
            resultList= resultList.stream()
                    .filter(data->searchDTO.getoEmbassyGardens().equals(data.isoEmbassyGardens()))
                    .collect(Collectors.toList());

        }
        if(searchDTO.getoKaiVillas()){
            resultList= resultList.stream()
                    .filter(data->searchDTO.getoKaiVillas().equals(data.isoKaiVillas()))
                    .collect(Collectors.toList());

        }
        if(searchDTO.getoTheGallery()){
            resultList= resultList.stream()
                    .filter(data->searchDTO.getoTheGallery().equals(data.isoTheGallery()))
                    .collect(Collectors.toList());

        }
        if(searchDTO.getoTheResidence()){
            resultList= resultList.stream()
                    .filter(data->searchDTO.getoTheResidence().equals(data.isoTheResidence()))
                    .collect(Collectors.toList());

        }
        if(searchDTO.gettAddyVillas()){
            resultList= resultList.stream()
                    .filter(data->searchDTO.gettAddyVillas().equals(data.istAddyVillas()))
                    .collect(Collectors.toList());

        }
        if(searchDTO.gettCliftonCourt()){
            resultList= resultList.stream()
                    .filter(data->searchDTO.gettCliftonCourt().equals(data.istCliftonCourt()))
                    .collect(Collectors.toList());

        }
        if(searchDTO.gettCliftonPlace()){
            resultList= resultList.stream()
                    .filter(data->searchDTO.getoCliftonPlace().equals(data.istCliftonPlace()))
                    .collect(Collectors.toList());

        }
        if(searchDTO.gettEmbassyGardens()){
            resultList= resultList.stream()
                    .filter(data->searchDTO.gettEmbassyGardens().equals(data.istEmbassyGardens()))
                    .collect(Collectors.toList());

        }
        if(searchDTO.gettKaiVillas()){
            resultList= resultList.stream()
                    .filter(data->searchDTO.gettKaiVillas().equals(data.istKaiVillas()))
                    .collect(Collectors.toList());

        }
        if(searchDTO.gettTheGallery()){
            resultList= resultList.stream()
                    .filter(data->searchDTO.gettTheGallery().equals(data.istTheGallery()))
                    .collect(Collectors.toList());

        }
        if(searchDTO.gettTheResidence()){
            resultList= resultList.stream()
                    .filter(data->searchDTO.gettTheResidence().equals(data.istTheResidence()))
                    .collect(Collectors.toList());

        }
        if(searchDTO.gettLennox()){
            resultList= resultList.stream()
                    .filter(data->searchDTO.gettLennox().equals(data.istLennox()))
                    .collect(Collectors.toList());

        }
        if(searchDTO.getoLennox()){
            resultList= resultList.stream()
                    .filter(data->searchDTO.getoLennox().equals(data.isoLennox()))
                    .collect(Collectors.toList());

        }






        return resultList;
    }
}
