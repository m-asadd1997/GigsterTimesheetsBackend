package com.example.excelProj.Service;

import com.example.excelProj.Dto.ClientFormDTO;
import com.example.excelProj.Model.ActivityLogs;
import com.example.excelProj.Model.ClientData;
import com.example.excelProj.Model.User;

import com.example.excelProj.Repository.ActivityLogsRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import com.example.excelProj.Repository.ClientDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.text.DateFormat;


@Service
public class ClientFormService {


    @Autowired
    ClientDataRepository clientDataRepository;


    @Autowired
    ActivityLogsRepository activityLogsRepository;

    @Autowired
    UserDaoRepository userDaoRepository;




    public String saveUserData(ClientFormDTO clientFormDTO){

        ClientData userData = new ClientData();
        populateUserData(clientFormDTO, userData);
        userData = clientDataRepository.save(userData);

        //ActivityLogs
        String shortDate = short_Date(new Date());

        ActivityLogs activityLogs = new ActivityLogs();
        populateActivityLogs(userData,activityLogs);

        activityLogs.setCreatedAt(shortDate);
        activityLogs.setCreatedBy(username());
        activityLogs.setUpdatedBy(username());
        activityLogs.setUpdatedAt(shortDate);
        activityLogsRepository.save(activityLogs);

        return "{\"Added successfully\":1}";

    }

    private String short_Date(Date date) {
        DateFormat getDate = DateFormat.getDateInstance(DateFormat.SHORT);
        DateFormat getTime = DateFormat.getTimeInstance(DateFormat.SHORT);
        String formattedDate =  getDate.format(date) +" " + getTime.format(date) ;
        return  formattedDate;
    }

    private void populateActivityLogs(ClientData userData, ActivityLogs activityLogs) {


        activityLogs.setUserDataId(userData.getId());
        activityLogs.setActivityStatus("Active");
        activityLogs.setName(userData.getName());
        activityLogs.setTitle(userData.getTitle());
        activityLogs.setSurname(userData.getSurname());
        activityLogs.setEmail1(userData.getEmail1());
        activityLogs.setEmail2(userData.getEmail2());
        activityLogs.setPhoneNo1(userData.getPhoneNo1());
        activityLogs.setPhoneNo2(userData.getPhoneNo2());
        activityLogs.setCompany(userData.getCompany());
        activityLogs.setNationality(userData.getNationality());
        activityLogs.setCountryOfResidence(userData.getCountryOfResidence());
        activityLogs.setStatus1(userData.getStatus1());
        activityLogs.setStatus2(userData.getStatus2());
        activityLogs.setStatus3(userData.getStatus3());
        activityLogs.setDateOffc(userData.getDateOffc());
        activityLogs.setCheckinDate(userData.getCheckinDate());
        activityLogs.setCheckoutDate(userData.getCheckoutDate());
        activityLogs.setDaysOfRental(userData.getDaysOfRental());
        activityLogs.setFirstPointOfContact(userData.getFirstPointOfContact());
        activityLogs.setDetails(userData.getDetails());
        activityLogs.setoEmbassyGardens(userData.isoEmbassyGardens());
        activityLogs.setoTheGallery(userData.isoTheGallery());
        activityLogs.setoTheResidence(userData.isoTheResidence());
        activityLogs.setoCliftonCourt(userData.isoCliftonCourt());
        activityLogs.setoCliftonPlace(userData.isoCliftonPlace());
        activityLogs.setoKaiVillas(userData.isoKaiVillas());
        activityLogs.setoAddyVillas(userData.isoAddyVillas());
        activityLogs.setTotal(userData.getTotal());
        activityLogs.settEmbassyGardens(userData.istEmbassyGardens());
        activityLogs.settTheGallery(userData.istTheGallery());
        activityLogs.settTheResidence(userData.istTheResidence());
        activityLogs.settCliftonCourt(userData.istCliftonCourt());
        activityLogs.settCLiftonPalace(userData.istCliftonPlace());
        activityLogs.settKaiVillas(userData.istKaiVillas());
        activityLogs.settAddyVillas(userData.istAddyVillas());
        activityLogs.setoLennox(userData.isoLennox());
        activityLogs.settLennox(userData.istLennox());

//        activityLogs.setCreatedAt(new Date());
//        activityLogs.setCreatedBy("System");
//        activityLogs.setUpdatedAt(new Date());
//        activityLogs.setUpdatedBy("System");

    }


    private void populateUserData(ClientFormDTO clientFormDTO, ClientData userData) {
        userData.setActivityStatus("Active");
        userData.setName(clientFormDTO.getName());
        userData.setSurname(clientFormDTO.getSurname());
        userData.setTitle(clientFormDTO.getTitle());
        userData.setEmail1(clientFormDTO.getEmail1());
        userData.setEmail2(clientFormDTO.getEmail2());
        userData.setPhoneNo1(clientFormDTO.getPhoneNo1());
        userData.setPhoneNo2(clientFormDTO.getPhoneNo2());
        userData.setCompany(clientFormDTO.getCompany());
        userData.setNationality(clientFormDTO.getNationality());
        userData.setCountryOfResidence(clientFormDTO.getCountryOfResidence());
        userData.setStatus1(clientFormDTO.getStatus1());
        userData.setStatus2(clientFormDTO.getStatus2());
        userData.setStatus3(clientFormDTO.getStatus3());
        userData.setDateOffc(clientFormDTO.getDateOffc());
        userData.setCheckinDate(clientFormDTO.getCheckinDate());
        userData.setCheckoutDate(clientFormDTO.getCheckoutDate());
        userData.setDaysOfRental(clientFormDTO.getDaysOfRental());
        userData.setFirstPointOfContact(clientFormDTO.getFirstPointOfContact());
        userData.setDetails(clientFormDTO.getDetails());
        userData.setoEmbassyGardens(clientFormDTO.isoEmbassyGardens());
        userData.setoTheGallery(clientFormDTO.isoTheGallery());
        userData.setoTheResidence(clientFormDTO.isoTheResidence());
        userData.setoCliftonCourt(clientFormDTO.isoCliftonCourt());
        userData.setoCliftonPlace(clientFormDTO.isoCliftonPlace());
        userData.setoKaiVillas(clientFormDTO.isoKaiVillas());
        userData.setoAddyVillas(clientFormDTO.isoAddyVillas());
        userData.setTotal(clientFormDTO.getTotal());
        userData.settEmbassyGardens(clientFormDTO.istEmbassyGardens());
        userData.settTheGallery(clientFormDTO.istTheGallery());
        userData.settTheResidence(clientFormDTO.istTheResidence());
        userData.settCliftonCourt(clientFormDTO.istCliftonCourt());
        userData.settCliftonPlace(clientFormDTO.istCliftonPlace());
        userData.settKaiVillas(clientFormDTO.istKaiVillas());
        userData.settAddyVillas(clientFormDTO.istAddyVillas());
        userData.setoLennox(clientFormDTO.isoLennox());
        userData.settLennox(clientFormDTO.istLennox());
    }

    public List<ClientData> deleteUser(Long id)
    {
        Optional<ClientData> userData = this.clientDataRepository.findById(id);
        if(userData.isPresent()){
            String createdBy = "";
            ClientData data = userData.get();
                data.setActivityStatus("InActive");
                if(data.getId()!=null){
                  List<ActivityLogs> activityLogs = this.activityLogsRepository.findByUserDataId(data.getId());
                    for (ActivityLogs a:activityLogs){
                        if(a.getCreatedBy()!=null){
                            createdBy = a.getCreatedBy();
                            break;
                        }

                    }
                }
                data= clientDataRepository.save(data);
            ActivityLogs activityLogs = new ActivityLogs();
            activityLogs.setUpdatedAt(short_Date(new Date()));
            activityLogs.setUpdatedBy(username());
            activityLogs.setCreatedBy(createdBy);
            populateActivityLogs(data,activityLogs);
            activityLogsRepository.save(activityLogs);

        }
        return this.getUsersData();

    }


    public List<ClientData> deleteUserDataIfUserLoggedIn(Long id)
    {
        Optional<ClientData> userData = this.clientDataRepository.findById(id);
        if(userData.isPresent()){
            String createdBy = "";
            ClientData data = userData.get();
            data.setActivityStatus("InActive");
            if(data.getId()!=null){
                List<ActivityLogs> activityLogs = this.activityLogsRepository.findByUserDataId(data.getId());
                for (ActivityLogs a:activityLogs){
                    if(a.getCreatedBy()!=null){
                        createdBy = a.getCreatedBy();
                        break;
                    }

                }
            }
            data= clientDataRepository.save(data);
            ActivityLogs activityLogs = new ActivityLogs();
            activityLogs.setUpdatedAt(short_Date(new Date()));
            activityLogs.setUpdatedBy(username());
            activityLogs.setCreatedBy(createdBy);
            populateActivityLogs(data,activityLogs);
            activityLogsRepository.save(activityLogs);

        }

       return  this.getActiveUserData();


    }

    public ClientData getUserById(Long id)
    {
        Optional <ClientData> userData = this.clientDataRepository.findById(id);
        if(userData.isPresent())
        {
            ClientData data = userData.get();

            return data;

        }


        return null;
    }
    public List<ClientData> getUsersData()
    {
            List <ClientData> userData = clientDataRepository.findAll();
            return userData;
    }

    public List<ClientData> getActiveUserData()
    {
        List <ClientData> userData = clientDataRepository.findByActivityStatus("Active");
        return userData;
    }



    public String updateUser(Long id , ClientFormDTO clientFormDTO)
    {
        String createdBy = "";
       // UserData userData = new UserData();
        Optional<ClientData> optionalUserData = this.clientDataRepository.findById(id);
        if(optionalUserData.isPresent())
        {
            ClientData userData = optionalUserData.get();

            userData.setName(clientFormDTO.getName());
            userData.setSurname(clientFormDTO.getSurname());
            userData.setTitle(clientFormDTO.getTitle());
            userData.setEmail1(clientFormDTO.getEmail1());
            userData.setEmail2(clientFormDTO.getEmail2());
            userData.setPhoneNo1(clientFormDTO.getPhoneNo1());
            userData.setPhoneNo2(clientFormDTO.getPhoneNo2());
            userData.setCompany(clientFormDTO.getCompany());
            userData.setNationality(clientFormDTO.getNationality());
            userData.setCountryOfResidence(clientFormDTO.getCountryOfResidence());
            userData.setStatus1(clientFormDTO.getStatus1());
            userData.setStatus2(clientFormDTO.getStatus2());
            userData.setStatus3(clientFormDTO.getStatus3());
            userData.setDateOffc(clientFormDTO.getDateOffc());
            userData.setFirstPointOfContact(clientFormDTO.getFirstPointOfContact());
            userData.setDetails(clientFormDTO.getDetails());
            userData.setoEmbassyGardens(clientFormDTO.isoEmbassyGardens());
            userData.setoTheGallery(clientFormDTO.isoTheGallery());
            userData.setoTheResidence(clientFormDTO.isoTheResidence());
            userData.setoCliftonCourt(clientFormDTO.isoCliftonCourt());
            userData.setoCliftonPlace(clientFormDTO.isoCliftonPlace());
            userData.setoKaiVillas(clientFormDTO.isoKaiVillas());
            userData.setoAddyVillas(clientFormDTO.isoAddyVillas());
            userData.setTotal(clientFormDTO.getTotal());
            userData.settEmbassyGardens(clientFormDTO.istEmbassyGardens());
            userData.settTheGallery(clientFormDTO.istTheGallery());
            userData.settTheResidence(clientFormDTO.istTheResidence());
            userData.settCliftonCourt(clientFormDTO.istCliftonCourt());
            userData.settCliftonPlace(clientFormDTO.istCliftonPlace());
            userData.settKaiVillas(clientFormDTO.istKaiVillas());
            userData.settAddyVillas(clientFormDTO.istAddyVillas());
            userData.setoLennox(clientFormDTO.isoLennox());
            userData.settLennox(clientFormDTO.istLennox());
            userData = clientDataRepository.save(userData);

            if(userData.getId()!=null){
                List<ActivityLogs> activityLogs = this.activityLogsRepository.findByUserDataId(userData.getId());
                for (ActivityLogs a:activityLogs){
                    if(a.getCreatedBy()!=null){
                        createdBy = a.getCreatedBy();
                        break;
                    }

                }
            }

            ActivityLogs activityLogs = new ActivityLogs();
            activityLogs.setCreatedBy(createdBy);
            activityLogs.setUpdatedBy(username());
            activityLogs.setUpdatedAt(short_Date(new Date()));
            populateActivityLogs(userData,activityLogs);
            activityLogsRepository.save(activityLogs);
            return "{\"Updated successfully\":1}";

        }
        else
        {
            return "{\"No User with This ID\":0}";
        }
    }

    public List<ActivityLogs> getActivityLogs(Long id){
        List<ActivityLogs> activityLogs = activityLogsRepository.findByUserDataId(id);
        return activityLogs;
    }

    public List<ClientData> reactiveUser(Long id)
    {
        Optional<ClientData> userData = this.clientDataRepository.findById(id);
        if(userData.isPresent()){
            String createdBy = "";
            ClientData data = userData.get();
            data.setActivityStatus("Active");
            if(data.getId()!=null){
                List<ActivityLogs> activityLogs = this.activityLogsRepository.findByUserDataId(data.getId());
                for (ActivityLogs a:activityLogs){
                    if(a.getCreatedBy()!=null){
                        createdBy = a.getCreatedBy();
                        break;
                    }

                }
            }
            data= clientDataRepository.save(data);
            ActivityLogs activityLogs = new ActivityLogs();
            activityLogs.setUpdatedAt(short_Date(new Date()));
            activityLogs.setUpdatedBy(username());
            activityLogs.setCreatedBy(createdBy);
            populateActivityLogs(data,activityLogs);
            activityLogsRepository.save(activityLogs);

        }
        return this.getUsersData();

    }
    public String username()
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        User user = userDaoRepository.findByEmail(username);
        return  user.getName();

    }


}
