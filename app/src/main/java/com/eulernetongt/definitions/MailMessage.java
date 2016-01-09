package com.eulernetongt.definitions;

/**
 * Created by netoeuler on 1/8/16.
 */
public class MailMessage {

    private String message;
    private boolean readed;

    public MailMessage(String msg){
        message = msg;
        readed = false;
    }

    public String getMessage() {
        return message;
    }

    public boolean isReaded() {
        return readed;
    }

    public void setReaded(boolean readed) {
        this.readed = readed;
    }
}
