package com.softserve.itacademy.Servlets;

import com.softserve.itacademy.Model.Address;
import com.softserve.itacademy.Model.AddressBookDto;
import com.softserve.itacademy.Model.AlreadyExist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateAddressServlet", value = "/records/create")
public class CreateAddressServlet extends HttpServlet {

    private AddressBookDto dto;

    @Override
    public void init() throws ServletException {
        dto = AddressBookDto.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/address_create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");

        Address newAddress = new Address(firstName, lastName, address);

        try {
            dto.create(newAddress);
            response.sendRedirect("/records/list");
        } catch (AlreadyExist alreadyExist) {
           response.sendRedirect("/records/create?error=Records already exist!");
        }
    }
}
