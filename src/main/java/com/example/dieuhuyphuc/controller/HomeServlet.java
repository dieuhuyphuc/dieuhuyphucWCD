package com.example.dieuhuyphuc.controller;

import com.example.dieuhuyphuc.dao.phonedao;
import com.example.dieuhuyphuc.model.phone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = "/Home")
public class HomeServlet extends HttpServlet {
    phonedao dao = new phonedao();

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("phones",getListPhone());
            request.getRequestDispatcher("list.jsp").forward(request,response);
        }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{

        phone u = new phone();
        u.setName(request.getParameter("name"));
        u.setBrand(request.getParameter("price"));
        u.setPrice(request.getParameter("brand"));
        u.setDescription(request.getParameter("description"));
        dao.insertUser(u);
        request.setAttribute("phones",getListPhone());
        request.getRequestDispatcher("list.jsp").forward(request,response);

    }
    protected List<phone> getListPhone(){
        return dao.getListPhone();
    }
    protected String insertUser() {
        phone u = new phone();
        u.setName("xs");
        u.setBrand("apple");
        u.setPrice("400");
        u.setDescription("ojdsfh");
        return dao.insertUser(u);
    }
    protected String deleteUser() {
        return dao.deleteUser(14);
    }
}
