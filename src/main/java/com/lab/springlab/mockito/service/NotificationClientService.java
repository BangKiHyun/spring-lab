package com.lab.springlab.mockito.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationClientService {

    public void notifyToEmail(){
        System.out.println("i'm real notification client email service!");
    }

    public void notifyToMobile() {
        System.out.println("i'm real notification client mobile service!");
    }
}
