package com.anki.statistics.service;

import com.anki.statistics.model.MailInfo;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Iurii Ivanov
 */

@Component
@AllArgsConstructor
//@EnableScheduling
public class MailProducer {

    private final MailSender mailSender;
    private final Faker faker = new Faker();

//    @Scheduled(fixedDelay = 1000)
    public void generateMail() {
        MailInfo mailInfo = MailInfo.builder()
                .content(faker.chuckNorris().fact())
                .templateCode(String.valueOf(faker.random().nextInt(3) + 1))
                .build();

        mailSender.send(mailInfo);
    }
}
