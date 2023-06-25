package com.charliehustle.beans;

import java.util.ArrayList;
import java.util.List;

public class RequestContext {

    private String completionMessage;
    private RequestInfo requestInfo;
    private ResponseInfo responseInfo;

    public RequestContext(){
        requestInfo = new RequestInfo();
    }

    public RequestInfo getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
    }

    public ResponseInfo getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(ResponseInfo responseInfo) {
        this.responseInfo = responseInfo;
    }

    public boolean hasRequestErrors() {
        if(requestInfo.getRequestErrors().size() > 0 ){
            return true;
        }
        return false;
    }

    public boolean hasResponseErrors() {
        if(responseInfo.getResponseErrors().size() > 0 ){
            return true;
        }
        return false;
    }

    public String getCompletionMessage() {
        return completionMessage;
    }

    public void setCompletionMessage(String completionMessage) {
        this.completionMessage = completionMessage;
    }


    public class RequestInfo{
        private List<String> requestErrors;
        private String sport;
        private String dataType;
        private String overWrite;
        private String year;
        private String week;
        private String date;

        public RequestInfo(){
            requestErrors = new ArrayList<>();
        }

        public String getSport() {
            return sport;
        }

        public void setSport(String sport) {
            this.sport = sport;
        }

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public String getOverWrite() {
            return overWrite;
        }

        public void setOverWrite(String overWrite) {
            this.overWrite = overWrite;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public List<String> getRequestErrors() {
            return requestErrors;
        }

        public void setRequestErrors(List<String> requestErrors) {
            this.requestErrors = requestErrors;
        }

    }

    public class ResponseInfo {
        private List<String> responseErrors;

        public List<String> getResponseErrors() {
            return responseErrors;
        }

        public void setResponseErrors(List<String> responseErrors) {
            this.responseErrors = responseErrors;
        }
    }
}
