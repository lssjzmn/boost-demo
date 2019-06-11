package com.lssjzmn.kilin.boost.mail.msg;

import java.util.ArrayList;
import java.util.List;

public class Message implements java.io.Serializable {
    private static final long serialVersionUID = 3667504049218729082L;

    protected List<String> receivers;

    protected String title;

    protected String content;

    protected Message() {

    }

    public List<String> getReceivers() {
        return receivers;
    }

    public Message setReceivers(List<String> receivers) {
        this.receivers = receivers;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Message setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    public Message addReceiver(String receiver) {
        if (this.receivers == null) {
            this.receivers = new ArrayList<>();
        }
        this.receivers.add(receiver);
        return this;
    }

    public Message addReceivers(List<String> receivers) {
        if (this.receivers == null) {
            this.receivers = new ArrayList<>();
        }
        this.receivers.addAll(receivers);
        return this;
    }

    public Message clearReceivers() {
        if (this.receivers != null) {
            this.receivers.clear();
        }
        return this;
    }
}
