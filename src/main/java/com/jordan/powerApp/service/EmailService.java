package com.jordan.powerApp.service;

import com.jordan.powerApp.email.EmailSender;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender {

    private final static Logger LOG = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender mailSender;

    @Override
    @Async
    public void send(String to, String email){
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
            mimeMessageHelper.setText(email, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject("Confirm your Account");
            mimeMessageHelper.setFrom(new InternetAddress("NoReply@powerapp.com", "NoReplyJordan"));
            mailSender.send(mimeMessage);

        }catch (MessagingException e) {
            LOG.error(e.getMessage());
            throw new IllegalStateException("Failed to send email");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
