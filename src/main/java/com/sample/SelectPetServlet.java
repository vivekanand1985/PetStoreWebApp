package com.sample;

import com.sample.model.PetType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(
        name = "selectpetservlet",
        urlPatterns = "/SelectPet"
)
public class SelectPetServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String petType = req.getParameter("Type");

        PetService petService = new PetService();
        PetType l = PetType.valueOf(petType);

        List petBreeds = petService.getAvailableBreeds(l);

        req.setAttribute("breeds", petBreeds);
        RequestDispatcher view = req.getRequestDispatcher("result.jsp");
        view.forward(req, resp);

    }
}