package com.akhambir.web;

import java.util.Objects;

public class Request {

    private String uri;
    private String method;

    public Request(String uri, String method) {
        this.uri = uri;
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(uri, request.uri) &&
                Objects.equals(method, request.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri, method);
    }
}
