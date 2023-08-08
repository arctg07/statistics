package com.anki.statistics.service.impl;

import com.anki.statistics.model.MailInfo;
import com.anki.statistics.service.MailGenerator;
import org.springframework.stereotype.Component;

/**
 * @author Iurii Ivanov
 */

//@Component("3")
@Component
public class HappyBirthdayMailGenerator implements MailGenerator {
    @Override
    public String generate(MailInfo mailInfo) {
        return mailInfo.getContent() +
                "\n Happy birthday!" ;
    }

    @Override
    public String getMyCode() {
        return "3";
    }
}
