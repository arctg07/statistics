package com.anki.statistics.service.impl;

import com.anki.statistics.model.MailInfo;
import com.anki.statistics.service.MailGenerator;
import org.springframework.stereotype.Component;

/**
 * @author Iurii Ivanov
 */

//@Component("2")
@Component
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generate(MailInfo mailInfo) {
        return mailInfo.getContent() +
                "\n don't call us Nicolas" ;
    }

    @Override
    public String getMyCode() {
        return "2";
    }
}
