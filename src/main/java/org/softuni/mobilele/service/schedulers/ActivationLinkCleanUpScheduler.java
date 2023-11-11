package org.softuni.mobilele.service.schedulers;

import org.softuni.mobilele.service.UserActivationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ActivationLinkCleanUpScheduler {

    private final UserActivationService userActivationService;

    public ActivationLinkCleanUpScheduler(UserActivationService userActivationService) {
        this.userActivationService = userActivationService;
    }

    @Scheduled(cron = "*/2 * * * * *")
    public void cleanUp() {
        this.userActivationService.cleanUpObsoleteActivationCode();
    }
}
