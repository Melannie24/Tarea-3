/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea3;

/**
 *
 * @author Rosse Lorenzana
 */
public class ArbolB {
    NodoArbolB raiz;
    int grado;

    public ArbolB(int grado) {
        this.grado = grado;
        raiz = null;
    }

    public void recorrer() {
        if (raiz != null) raiz.recorrer();
    }

    public NodoArbolB buscar(int clave) {
        return (raiz == null) ? null : raiz.buscar(clave);
    }

    public void insertar(int clave) {
        if (raiz == null) {
            raiz = new NodoArbolB(grado, true);
            raiz.claves[0] = clave;
            raiz.cantidadClaves = 1;
        } else {
            if (raiz.cantidadClaves == 2 * grado - 1) {
                NodoArbolB nuevaRaiz = new NodoArbolB(grado, false);
                nuevaRaiz.hijos[0] = raiz;
                nuevaRaiz.dividirHijo(0, raiz);
                int i = 0;
                if (nuevaRaiz.claves[0] < clave) {
                    i++;
                }
                nuevaRaiz.hijos[i].insertarClaveNoLlena(clave);
                raiz = nuevaRaiz;
            } else {
                raiz.insertarClaveNoLlena(clave);
            }
        }
    }

    public void eliminar(int clave) {
        if (raiz != null) {
            raiz.eliminar(clave);
        }
    }
}

