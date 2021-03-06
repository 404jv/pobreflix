/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.MVC.Controllers;

import br.edu.ifpr.MVC.Models.RentalModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author julia
 */
@WebServlet(name = "CreateRentalController", urlPatterns = {"/rentals"})
public class CreateRentalController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        request.getRequestDispatcher("rentals.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String client_cpf = request.getParameter("client_cpf");
        String movie_title = request.getParameter("movie_title");
        String start_date = request.getParameter("start_date");
        String end_date = request.getParameter("end_date");

        RentalModel rentalModel = new RentalModel();
 
        try {
            rentalModel.create(client_cpf, movie_title, start_date, end_date);

            response.sendRedirect("/locadora/rentals");
        } catch (Exception e) {
            response.sendRedirect("/locadora/rentals?mensagem=" + e.getMessage());
        }
    }
}
