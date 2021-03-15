package com.example.omninos.modelClasses;

import java.util.List;

public class ResponseClass {
    String success;
    String message;
    List<DetailsClass> details;
    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DetailsClass> getDetails() {
        return details;
    }

    public void setDetails(List<DetailsClass> details) {
        this.details = details;
    }





}
