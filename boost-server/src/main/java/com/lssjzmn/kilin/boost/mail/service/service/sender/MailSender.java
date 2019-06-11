package com.lssjzmn.kilin.boost.mail.service.service.sender;

import com.lssjzmn.kilin.boost.mail.msg.Message;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by 212466128 on 2016/6/18.
 */
public class MailSender {
    private JavaMailSender mailSender;
    private String from;

    private static MailSender instance = new MailSender();

    private MailSender() {
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("mail-config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setDefaultEncoding("UTF-8");
        javaMailSender.setHost(properties.getProperty("host"));
        javaMailSender.setUsername(properties.getProperty("username"));
        javaMailSender.setPassword(properties.getProperty("password"));
        Properties mailProperties = new Properties();
        mailProperties.setProperty("mail.smtp.auth", "true");
        mailProperties.setProperty("mail.smtp.timeout", "25000");
        javaMailSender.setJavaMailProperties(mailProperties);
        this.mailSender = javaMailSender;
        this.from = properties.getProperty("from");
    }

    public static MailSender getInstance() {
        return instance;
    }

    public void send(Message message) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = null;
        try {
            messageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            messageHelper.setFrom(this.from);
            messageHelper.setSubject(message.getTitle());
            messageHelper.setTo(message.getReceivers().toArray(new String[message.getReceivers().size()]));
            messageHelper.setText(message.getContent(), true);

            mailSender.send(mimeMessage);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
