// Generated by GraphWalker (http://www.graphwalker.org)
package com.testing;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "com/testing/CrearPila.graphml")
public interface CrearPila {

    @Vertex()
    void v_VerificarMazo();

    @Edge()
    void e_AdherirAPila();

    @Edge()
    void e_CrearMazo();

    @Edge()
    void e_DarCarta();

    @Vertex()
    void v_ListarPila();

    @Vertex()
    void v_MazoEnJuego();
}
