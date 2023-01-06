package com.chan.sherlock.exception;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

//error response
public class ErrorDetails {

    @JsonProperty("error_code")
    private ErrorCode errorCode;
    @JsonProperty("error_message")
    private String errorMsg;
    private Instant timeStamp;

    public ErrorDetails(){}
    public ErrorDetails(ErrorCode errorCode, String errorMsg,Instant timeStamp){
        this.errorCode=errorCode;
        this.errorMsg=errorMsg;
        this.timeStamp=timeStamp;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }
}
