package com.example.excelProj.Service.impl;

import com.example.excelProj.Dto.MessageDto;

public interface NotificationService {

    void sendEmail(MessageDto messageDto);
}
