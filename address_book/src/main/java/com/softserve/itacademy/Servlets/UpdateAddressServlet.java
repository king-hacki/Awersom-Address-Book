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

@WebServlet(name = "UpdateAddressServlet", value = "/records/update")
public class UpdateAddressServlet extends HttpServlet {

    private AddressBookDto dto;
    private Address address;
    private String firstName;
    private String lastName;

    @Override
    public void init() throws ServletException {
        dto = AddressBookDto.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            firstName = request.getParameter("firstName");
            lastName = request.getParameter("lastName");

            address = dto.read(firstName, lastName);

            request.setAttribute("address", address);
            request.getRequestDispatcher("/WEB-INF/address_update.jsp").forward(request, response);
        } catch (NotSuchAddress notSuchAddress) {
            notSuchAddress.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        Address updatedAddress = new Address(
                request.getParameter("first"),
                request.getParameter("last"),
                request.getParameter("address"));

        System.out.println("updatedAddress = " + updatedAddress);

        try {
            dto.update(firstName, lastName, updatedAddress);
            response.sendRedirect("/records/list");
        } catch (NotSuchAddress notSuchAddress) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "/records/error");
        }



    }
}
