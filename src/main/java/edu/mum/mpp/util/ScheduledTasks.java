package edu.mum.mpp.util;


import edu.mum.mpp.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Lukman.Arogundade on 8/22/2016.
 */
@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);


    @Autowired
    AsyncService asyncService;


    @Scheduled(fixedRateString = "${email-sender-scheduler-rate}")
    public void SendQueuedEmails() {
        logger.debug("Sending Queued Emails Scheduler called");
        this.asyncService.sendQueuedEmails();
    }


}
