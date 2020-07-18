package com.softserve.itacademy.Servlets;

import com.softserve.itacademy.Model.AddressBookDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddressListServlet", value = "/records/list")
public class AddressListServlet extends HttpServlet {

    private AddressBookDto dto;

    @Override
    public void init() throws ServletException {
        dto = AddressBookDto.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/address_list.jsp");
        request.setAttribute("addressBook", dto.readAll());
        requestDispatcher.forward(request, response);

    }
}
