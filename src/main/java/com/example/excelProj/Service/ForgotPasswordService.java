package com.example.excelProj.Service;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.ForgotPasswordDTO;
import com.example.excelProj.Model.ForgotPassword;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.ForgotPasswordRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class ForgotPasswordService {

    @Autowired
    UserDaoRepository userDaoRepository;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    ForgotPasswordRepository forgotPasswordRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public ApiResponse getUserTypeAndMail(ForgotPasswordDTO forgotPasswordDTO) {
        String password = "";
        User user = userDaoRepository.findByEmail(forgotPasswordDTO.getEmail());
        if (user != null) {
            if (!user.getUserType().equals("ADMIN")) {
                password = getAlphaNumericString(6);
                user.setPassword(bcryptEncoder.encode(password));
                userDaoRepository.save(user);
                mailToEmpAndSup(forgotPasswordDTO.getEmail(), password);
                return new ApiResponse<>(200, "Your new password for timesheets is sent to your email.", null);
            } else {
                ForgotPassword forgotPassword = new ForgotPassword();
                String token = generateUUID();
                forgotPassword.setToken(token);
                forgotPassword.setDate(new Date());
                forgotPassword.setEmail(forgotPasswordDTO.getEmail());
                forgotPasswordRepository.save(forgotPassword);
                mailToAdmin(forgotPasswordDTO.getEmail(), token.toString());
                return new ApiResponse<>(200, "Password reset link is sent to your email kindly check it.", forgotPassword);
            }

        } else {
            return new ApiResponse<>(404, "User not found", null);
        }
    }

    public ApiResponse checkTokenExpiry(ForgotPasswordDTO forgotPasswordDTO){
        ForgotPassword forgotPassword = forgotPasswordRepository.findByToken(forgotPasswordDTO.getToken());
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Long expiryTime =  getTimeDifference(df.format(forgotPassword.getDate()),df.format(forgotPasswordDTO.getDate()));

        if(expiryTime > 3){
            return new ApiResponse(404,"Token Expired",null);
        }
        else{
            return new ApiResponse(200,"Token valid",forgotPassword);
        }
    }

    public ApiResponse saveNewPassword(ForgotPasswordDTO forgotPasswordDTO){
        User user = userDaoRepository.findByEmail(forgotPasswordDTO.getEmail());
        user.setPassword(bcryptEncoder.encode(forgotPasswordDTO.getPassword()));
        userDaoRepository.save(user);
        return new ApiResponse(200,"Password reset successfully",null);
    }

    void mailToEmpAndSup(String recevierEmail, String password) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(recevierEmail);

        msg.setSubject("New Password Received For Timesheets");
        msg.setText("Your new password is: " + password);

        javaMailSender.send(msg);

    }

    void mailToAdmin(String recevierEmail, String token) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(recevierEmail);

        msg.setSubject("Reset your password");
        msg.setText("link to reset your password is : http://localhost:4200/#/resetlink/" + token);

        javaMailSender.send(msg);

    }

    public String getAlphaNumericString(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public String generateUUID() {
        return   UUID.randomUUID().toString();
    }

    public Long getTimeDifference(String start,String end){
        String dateStart = start;
        String dateEnd = end;
        long diffMinutes = 0;

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateEnd);

            //in milliseconds
            long diff = d2.getTime() - d1.getTime();

            diffMinutes = diff / (60 * 1000) % 60;

            return diffMinutes;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return diffMinutes;
    }

}
