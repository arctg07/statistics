package com.anki.statistics.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author Iurii Ivanov
 */

@Data
@Builder
public class MailInfo {

    String templateCode;

    String content;
}
