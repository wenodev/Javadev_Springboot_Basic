package com.tutorial.javadev;

import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JavaEmailService {

    private JavaMailSender mailSender;

    public void sendEmail(){
        MimeMessagePreparator messagePreparator = mimeMessage -> {

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setFrom("noreply@www.javadevjournal.com");
            helper.setTo("e2342@naver.com");
            helper.setSubject("Sample mail subject");
            helper.setText("Test Email");
        };

        mailSender.send(messagePreparator);
    }


}
