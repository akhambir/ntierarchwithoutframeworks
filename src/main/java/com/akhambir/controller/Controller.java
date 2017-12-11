package com.akhambir.controller;

import com.akhambir.web.ViewModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

    ViewModel process(HttpServletRequest request, HttpServletResponse response);

}
