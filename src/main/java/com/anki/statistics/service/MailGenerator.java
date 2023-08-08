package com.anki.statistics.service;


import com.anki.statistics.model.MailInfo;

/**
 * @author Iurii Ivanov
 */

public interface MailGenerator {

    String generate(MailInfo mailInfo);

    String getMyCode();
}
