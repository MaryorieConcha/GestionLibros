package com.example.gestionlibros.model.data.dao;

import com.example.gestionlibros.model.Libro;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class LibroDao {
    public static void agregarLibro(DSLContext query, Libro libro){
        Table tablaLibro = table(name("Libro"));
        Field[] columnas = tablaLibro.fields("id_libro","nombre","editorial","categoria","año","tipo_libro");
        query.insertInto(tablaLibro,columnas[0],columnas[1],columnas[2],columnas[3],columnas[4],columnas[5])
                .values(libro.getId_libro(),libro.getNombre(),libro.getEditorial(),libro.getCategoria(),libro.getAño(),libro.getTipo_libro())
                .execute();
    }

    public static List obtenerLibro(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Libro")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaLibros(resultados);
    }

    private static List obtenerListaLibros(Result resultados){
        List<Libro> libros= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            int id = (int) resultados.getValue(fila,"id_libro");
            String nombre = (String) resultados.getValue(fila,"nombre");
            String editorial = (String) resultados.getValue(fila,"editorial");
            String categoria = (String) resultados.getValue(fila,"categoria");
            int año = (int) resultados.getValue(fila,"año");
            String tipo = (String) resultados.getValue(fila,"tipo_libro");
            libros.add(new Libro(id,nombre,editorial,categoria,año,tipo));
        }
        return libros;
    }
}
