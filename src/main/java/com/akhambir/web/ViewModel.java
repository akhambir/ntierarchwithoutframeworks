package com.akhambir.web;

import java.util.HashMap;
import java.util.Map;

public class ViewModel {

    private final String PREFIX = "/WEB-INF/";
    private final String SUFFIX = ".jsp";

    private Map<String, Object> argumentsMap = new HashMap<>();
    private String view;

    public ViewModel(String view) {
        this.view = view;
    }

    public ViewModel(Map<String, Object> argumentsMap, String view) {
        this.argumentsMap = argumentsMap;
        this.view = view;
    }

    public Map<String, Object> getArgumentsMap() {
        return argumentsMap;
    }

    public void setArgument(String argName, Object arg) {
        this.argumentsMap.put(argName, arg);
    }

    public String getView() {
        return String.format("%s%s%s", PREFIX, view, SUFFIX);
    }

    public void setView(String view) {
        this.view = view;
    }
}
