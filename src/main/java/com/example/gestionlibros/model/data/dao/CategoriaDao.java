package com.example.gestionlibros.model.data.dao;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class CategoriaDao {

    public static void agregarCategoria(DSLContext query, String categoria){
        Table tablaCategorias = table(name("Categorias"));
        Field[] columnas = tablaCategorias.fields("categoria");
        query.insertInto(tablaCategorias, columnas[0])
                .values(categoria)
                .execute();
    }
    public static List obtenerCategoria(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Categorias")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaCategorias(resultados);
    }
    public static List obtenerCategorias(DSLContext query) {
        Result resultados = query.select().from(DSL.table("Categorias")).fetch();
        return obtenerListaCategorias(resultados);
    }

    private static List obtenerListaCategorias(Result resultados){
        List<Object> categorias= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String categoria = (String) resultados.getValue(fila,"categoria");
            categorias.add(categoria);
        }
        return categorias;
    }
}
