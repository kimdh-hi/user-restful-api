package com.devblog.mobileappws.exception.entity;

public enum ErrorMessage {

    MISSING_REQUIRED_FIELD("Missing required field."),
    RESOURCE_ALREADY_EXISTS("Resources already exists."),
    INTERNAL_SERVER_ERROR("internal server error."),
    RESOURCE_NOT_FOUND("Resource not founded."),
    AUTHENTICATION_FAILED("Failed to Authenticate."),
    COULD_NOT_UPDATE_RESOURCE("Could not update resource."),
    COULD_NOT_DELETE_RESOURCE("Could not delete resource."),
    EMAIL_ADDRESS_NOT_VERIFIED("Email address not be verified.");


    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
