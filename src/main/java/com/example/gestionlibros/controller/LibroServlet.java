package com.example.gestionlibros.controller;

import com.example.gestionlibros.model.Libro;
import com.example.gestionlibros.model.data.DBGenerator;
import com.example.gestionlibros.model.data.dao.LibroDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "libroServlet", value = "/libro")
public class LibroServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("BibliotecaBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher respuesta = request.getRequestDispatcher("/agregarLibro.jsp");
        respuesta.forward(request,response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        RequestDispatcher respuesta = req.getRequestDispatcher("/agregarLibro.jsp");
        if (req.getParameter("id_libro").length() != 0){
            int id_libro = Integer.parseInt(req.getParameter("id_libro"));
            String nombre = req.getParameter("nombre");
            String editorial = req.getParameter("editorial");
            String categoria = req.getParameter("categoria");
            int año = Integer.parseInt(req.getParameter("año"));
            String tipo_libro = req.getParameter("tipo_libro");
            Libro libro = new Libro(id_libro,nombre,editorial,categoria,año,tipo_libro);
            try {
                if(agregarLibro(libro)){
                    req.setAttribute("libro",libro);
                    respuesta = req.getRequestDispatcher("/registroExitoso.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }

    private boolean agregarLibro(Libro libro) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("BibliotecaBD");
        List<Libro> libros = LibroDao.obtenerLibro(query,"id_libro",libro.getId_libro());
        if(libros.size()!=0){
            return false;
        }
        else{
            LibroDao.agregarLibro(query,libro);
            return true;
        }
    }
}
