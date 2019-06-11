package com.lssjzmn.kilin.boost.mail.msg;

import java.util.List;

public class MailMessage extends Message {
    private static final long serialVersionUID = -8964733383636152697L;

    public static Message createInstance() {
        return createInstance(null, null, null);
    }

    public static Message createInstance(List<String> receivers, String title, String content) {
        MailMessage message = new MailMessage();
        message.setReceivers(receivers);
        message.setTitle(title);
        message.setContent(content);
        return message;
    }
}
