package com.eulernetongt.definitions;

import java.util.ArrayList;

/**
 * Created by netoeuler on 1/8/16.
 */
public class MailList {

    private static ArrayList<MailMessage> list;
    private static int unreadMessages = 0;

    public static void generate(){
        list = new ArrayList<MailMessage>(10);
    }

    public static void addMessage(String title, String msg){
        if (list.size() < 10){
            list.add(new MailMessage(title, msg));
            unreadMessages++;
        }
    }

    public static void addWelcomeMessage(){
        String title = String.format("Welcome to %s",GeneralDefinitions.getTeam());
        String msg= String.format("Welcome to %s!\nThe president and all the soccer department hope that " +
                "this is a yer with many trophies to the club.",GeneralDefinitions.getTeam());

        addMessage(title, msg);
    }

    public static MailMessage getByTitle(String title){
        for (MailMessage mm : list){
            if (mm.getTitle().equals(title))
                return mm;
        }

        return null;
    }

    public static ArrayList<MailMessage> getList() {
        return list;
    }

    public static int getUnreadMessages() {
        return unreadMessages;
    }
}

