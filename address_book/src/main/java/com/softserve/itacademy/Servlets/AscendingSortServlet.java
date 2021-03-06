package com.softserve.itacademy.Servlets;

import com.softserve.itacademy.Model.AddressBookDto;
import com.softserve.itacademy.Model.SortOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AscendingSortServlet", value = "/records/ascending")
public class AscendingSortServlet extends HttpServlet {

    private AddressBookDto dto;

    @Override
    public void init() throws ServletException {
        dto = AddressBookDto.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dto.sortedBy(SortOrder.ASC);
        response.sendRedirect("/records/list");
    }
}
