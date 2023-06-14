package com.example.gestionlibros.controller;

import java.io.*;
import java.util.List;

import com.example.gestionlibros.model.data.DBGenerator;
import com.example.gestionlibros.model.data.dao.CategoriaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.jooq.DSLContext;

@WebServlet(name = "categoriaServlet", value = "/categoria")
public class CategoriaServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("BibliotecaBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher respuesta = request.getRequestDispatcher("/agregarCategoria.jsp");
        respuesta.forward(request,response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        RequestDispatcher respuesta = req.getRequestDispatcher("/agregarCategoria.jsp");

        if (req.getParameter("categoria").length() != 0){
            String categoria = req.getParameter("categoria");
            try {
                if(agregarCategoria(categoria)){
                    req.setAttribute("categoria",categoria);
                    respuesta = req.getRequestDispatcher("/registroExitoso.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }

    private boolean agregarCategoria(String categoria) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("BibliotecaBD");
        List categorias = CategoriaDao.obtenerCategorias(query);
        if(categorias.size()!=0){
            return false;
        }
        else{
            CategoriaDao.agregarCategoria(query,categoria);
            return true;
        }
    }
}