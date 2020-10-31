package com.example.excelProj.Service;

import com.example.excelProj.Dto.MessageDto;
import com.example.excelProj.Service.impl.NotificationService;
import com.example.excelProj.util.Util;
import org.antlr.stringtemplate.StringTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private JavaMailSender sender;

    @Value("${spring.mail.username}")
    private String username;

    @Override
    public void sendEmail(MessageDto messageDto) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setFrom(username);
            helper.setTo(messageDto.getSendTo());
            helper.setSubject(messageDto.getSubject());
            helper.setText(messageDto.getTextBody(), true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);
    }
}
