/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea3;

/**
 *
 * @author Rosse Lorenzana
 */
import javax.swing.*;
import java.awt.*;

public class VentanaArbolB extends JPanel {
    private NodoArbolB raiz;

    public VentanaArbolB(NodoArbolB raiz) {
        this.raiz = raiz;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (raiz != null) {
            dibujarNodo(g, raiz, getWidth() / 2, 30, getWidth() / 4);
        }
    }

    private void dibujarNodo(Graphics g, NodoArbolB nodo, int x, int y, int espacio) {
        String texto = "";
        for (int i = 0; i < nodo.cantidadClaves; i++) {
            texto += nodo.claves[i] + " ";
        }

        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(x - 30, y - 20, 60, 40);
        g.setColor(Color.BLACK);
        g.drawOval(x - 30, y - 20, 60, 40);
        g.drawString(texto, x - 25, y + 5);

        if (!nodo.esHoja) {
            for (int i = 0; i <= nodo.cantidadClaves; i++) {
                int nuevoX = x - espacio + i * (espacio * 2 / nodo.cantidadClaves);
                g.drawLine(x, y + 20, nuevoX, y + 60);
                dibujarNodo(g, nodo.hijos[i], nuevoX, y + 80, espacio / 2);
            }
        }
    }
}

