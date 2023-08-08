package com.anki.statistics.service;

import com.anki.statistics.model.MailInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

/**
 * @author Iurii Ivanov
 */

@Service
public class MailSender {

    Map<String, MailGenerator> map;

    @Autowired
    public MailSender(List<MailGenerator> mailGenerators) {
        map = mailGenerators.stream()
                .collect(toMap(MailGenerator::getMyCode, Function.identity()));
    }

    public void send(MailInfo mailInfo) {
        String code = mailInfo.getTemplateCode();
        MailGenerator generator = map.get(code);

        if (generator == null) {
            throw new UnsupportedOperationException(code + "not supported yet");
        }

        String html = generator.generate(mailInfo);
        
        sendMail(html);
    }

    private void sendMail(String html) {
        System.out.println(html + " was sent");
    }
}
