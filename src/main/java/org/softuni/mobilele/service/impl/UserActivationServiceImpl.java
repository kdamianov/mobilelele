package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.events.UserRegisteredEvent;
import org.softuni.mobilele.service.EmailService;
import org.softuni.mobilele.service.UserActivationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class UserActivationServiceImpl implements UserActivationService {

    private final EmailService emailService;

    public UserActivationServiceImpl(EmailService emailService) {
        this.emailService = emailService;
    }

    @EventListener(UserRegisteredEvent.class)             //анотираме, за да се разбира, че е EventListener
    @Override
    public void userRegistered(UserRegisteredEvent event) {
        emailService.sendRegistrationEmail(event.getUserEmail(), event.getUserNames());  //изпраща mail
    }
}
