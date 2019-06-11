package com.lssjzmn.kilin.boost.mail.service.service;

import com.lssjzmn.kilin.boost.mail.msg.Message;

/**
 * Created by 212466128 on 2016/6/18.
 */
public interface MessageService {
    /**
     * Send a message.
     *
     * @param message The message object
     */
    void send(Message message);
}
