package com.eulernetongt.definitions;

/**
 * Created by netoeuler on 1/8/16.
 */
public class MailMessage {

    private String message;
    private String title;
    private boolean readed;

    public MailMessage(String title, String msg){
        this.title = title;
        message = msg;
        readed = false;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    public boolean isReaded() {
        return readed;
    }

    public void setReaded(boolean readed) {
        this.readed = readed;
    }


}
