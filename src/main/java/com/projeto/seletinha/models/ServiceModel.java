package com.projeto.seletinha.models;

import jdk.jfr.ContentType;

public class ServiceModel {
    private int status;
    private String response;
    private ContentType contentType;


    public ServiceModel(int status, String response) {
        this.status = status;
        this.response = response;
    }


    public ServiceModel(int status, String response, ContentType contentType) {
        this.status = status;
        this.response = response;
        this.contentType = contentType;
    }

    public int getStatus() {
        return status;
    }

    public String getResponse() {
        return response;
    }

    public ContentType getContentType() {
        return contentType;
    }
}
