package com.softserve.itacademy.Servlets;

import com.softserve.itacademy.Model.Address;
import com.softserve.itacademy.Model.AddressBookDto;
import com.softserve.itacademy.Model.NotSuchAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReadAddressServlet", value = "/records/read")
public class ReadAddressServlet extends HttpServlet {

    private AddressBookDto dto;

    @Override
    public void init() throws ServletException {
        dto = AddressBookDto.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            Address address = dto.read(firstName, lastName);

            request.setAttribute("address", address);
            request.getRequestDispatcher("/WEB-INF/address_read.jsp").forward(request, response);
        } catch (NotSuchAddress notSuchAddress) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "/records/error");
        }

    }
}
