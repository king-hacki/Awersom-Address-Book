package com.softserve.itacademy.Servlets;

import com.softserve.itacademy.Model.AddressBookDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NoSuchAddressExceptionHandlerServlet", value = "/error")

public class NoSuchAddressExceptionHandlerServlet extends HttpServlet {

    private AddressBookDto dto;

    @Override
    public void init() throws ServletException {
        dto = AddressBookDto.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/error.jsp");
        request.setAttribute("firstName", request.getParameter("firstName"));
        request.setAttribute("lastName", request.getParameter("lastName"));
        requestDispatcher.forward(request, response);

//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
//        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
//        String requestURI = (String) request.getAttribute("javax.servlet.error.request_uri");
//
//        PrintWriter writer = response.getWriter();


    }

}
