package com.eulernetongt.definitions;

/**
 * Created by netoeuler on 1/8/16.
 */
public class MailList {

    private static MailMessage[] list;
    private static int unreadMessages = 0;

    public static MailMessage[] getList() {
        return list;
    }

    public static void generate(){
        list = new MailMessage[10];
        for (int i=0 ; i<10 ; i++)
            list[i] = null;
    }

    public static void addMessage(String msg){
        for (int i=0 ; i<10 ; i++){
            if (list[i] == null) {
                list[i] = new MailMessage(msg);
                unreadMessages++;
                break;
            }
        }
    }

    public static int getUnreadMessages() {
        return unreadMessages;
    }
}

