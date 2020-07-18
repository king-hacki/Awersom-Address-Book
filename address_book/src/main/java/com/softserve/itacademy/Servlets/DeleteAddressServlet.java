package com.softserve.itacademy.Servlets;

import com.softserve.itacademy.Model.AddressBookDto;
import com.softserve.itacademy.Model.NotSuchAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteAddressServlet", value = "/records/delete")
public class DeleteAddressServlet extends HttpServlet {

    private AddressBookDto dto;

    @Override
    public void init() throws ServletException {
        dto = AddressBookDto.getInstance();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            dto.delete(firstName, lastName);

            response.sendRedirect("/records/list");

        } catch (NotSuchAddress notSuchAddress) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "/records/error");
        }
    }

}
