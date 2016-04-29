package com.sainath.services.beens;

/**
 * Created by babjik on 19/4/16.
 */
public class Message {
    private String name;
    private String text;

    public Message(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}
