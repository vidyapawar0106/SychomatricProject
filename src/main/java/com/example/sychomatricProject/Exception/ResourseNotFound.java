package com.example.sychomatricProject.Exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourseNotFound extends RuntimeException {
    private String resourcename;
    private String fieldname;
    private Long fieldvalue;

    public ResourseNotFound(String resourcename, String fieldname, Long fieldvalue) {
        super(String.format("%s not found with %s:'S'", resourcename, fieldname, fieldvalue));
        this.resourcename = resourcename;
        this.fieldname = fieldname;
        this.fieldvalue = fieldvalue;


    }

    public String getResourcename() {
        return resourcename;
    }

    public String getFieldname() {
        return fieldname;
    }

    public Long getFieldvalue() {
        return fieldvalue;
    }
}