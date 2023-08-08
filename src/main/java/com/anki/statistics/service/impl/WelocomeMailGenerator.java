package com.anki.statistics.service.impl;

import com.anki.statistics.model.MailInfo;
import com.anki.statistics.service.MailGenerator;
import org.springframework.stereotype.Component;

/**
 * @author Iurii Ivanov
 */

//@Component("1")
@Component
public class WelocomeMailGenerator implements MailGenerator {
    @Override
    public String generate(MailInfo mailInfo) {
        return mailInfo.getContent() + "\n welcome mail" ;
    }

    @Override
    public String getMyCode() {
        return "1";
    }
}
