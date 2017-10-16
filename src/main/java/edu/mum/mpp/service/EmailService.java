package edu.mum.mpp.service;


import edu.mum.mpp.dao.AbstractDao;
import edu.mum.mpp.dao.EmailDao;
import edu.mum.mpp.model.EmailDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;


@Service
public class EmailService extends AbstractService<EmailDetails> {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
    private final static String httpMethod = "POST";

    //@Value("${client.id}")
    private String clientId;
    //@Value("${client.secret}")
    private String clientSecret;


    @Autowired
    public EmailService(@Qualifier("emailDao") AbstractDao<EmailDetails> dao) {
        super(dao);
    }


    public void queueEmail(String sender, String recipient, String subject, String contentType, String content) {

        EmailDao emailDao = (EmailDao) this.dao;
        emailDao.QueueMessage(sender, recipient, subject, contentType, content);
    }

    public void sendQueuedEmails() {


        EmailDao emailDao = (EmailDao) this.dao;
        List<EmailDetails> emails = emailDao.GetEmailsToSend();
        if (null != emails) {
            for (EmailDetails email : emails) {
                try {
                    // AuthConfig config = new AuthConfig(httpMethod, "", clientId, clientSecret, "", AuthConfig.SHA1);
                    //  Email mail = new Email(email.getSender(), email.getRecipient(), email.getContent(), email.getSubject(), email.getContentType());
                    //  EmailClient client = new EmailClient(config);
                    logger.info("Sending email to " + email.getRecipient());
                    // client.send(mail, urls.getUrl());
                    //emailDao.UpdateEmailStatus(email.getId(), 1);
                } catch (Exception ex) {
                    emailDao.UpdateEmailStatus(email.getId(), 0);
                    StringWriter sw = new StringWriter();
                    ex.printStackTrace(new PrintWriter(sw));
                    logger.error(sw.toString());
                }
            }
        }
    }

    public void updateEmailStatus(long id, int status) {

        EmailDao emailDao = (EmailDao) this.dao;
        emailDao.UpdateEmailStatus(id, status);
    }
}
