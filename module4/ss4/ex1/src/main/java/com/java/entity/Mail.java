package com.java.entity;



import java.util.Arrays;
import java.util.List;


public class Mail {
    int page;
    String language;
    String spam;
    String signature;

    public Mail(int page, String language, String spam, String signature) {
        this.page = page;
        this.language = language;
        this.spam = spam;
        this.signature = signature;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSpam() {
        return spam;
    }

    public void setSpam(String spam) {
        this.spam = spam;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
