/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea3;

/**
 *
 * @author Rosse Lorenzana
 */
public class NodoArbolB {
    int[] claves; // claves dentro del nodo
    int grado; // Grado minimo del árbol
    NodoArbolB[] hijos; // hijos del nodo
    int cantidadClaves; // numero actual de claves
    boolean esHoja; // indica si el nodo es hoja

    public NodoArbolB(int grado, boolean esHoja) {
        this.grado = grado;
        this.esHoja = esHoja;
        claves = new int[2 * grado - 1];
        hijos = new NodoArbolB[2 * grado];
        cantidadClaves = 0;
    }

    public NodoArbolB buscar(int clave) {
        int i = 0;
        while (i < cantidadClaves && clave > claves[i]) {
            i++;
        }
        if (i < cantidadClaves && claves[i] == clave) {
            return this;
        }
        if (esHoja) {
            return null;
        }
        return hijos[i].buscar(clave);
    }

    public void insertarClaveNoLlena(int clave) {
        int i = cantidadClaves - 1;

        if (esHoja) {
            while (i >= 0 && claves[i] > clave) {
                claves[i + 1] = claves[i];
                i--;
            }
            claves[i + 1] = clave;
            cantidadClaves++;
        } else {
            while (i >= 0 && claves[i] > clave) {
                i--;
            }
            if (hijos[i + 1].cantidadClaves == 2 * grado - 1) {
                dividirHijo(i + 1, hijos[i + 1]);
                if (claves[i + 1] < clave) {
                    i++;
                }
            }
            hijos[i + 1].insertarClaveNoLlena(clave);
        }
    }

    public void dividirHijo(int i, NodoArbolB y) {
        NodoArbolB z = new NodoArbolB(y.grado, y.esHoja);
        z.cantidadClaves = grado - 1;

        for (int j = 0; j < grado - 1; j++) {
            z.claves[j] = y.claves[j + grado];
        }

        if (!y.esHoja) {
            for (int j = 0; j < grado; j++) {
                z.hijos[j] = y.hijos[j + grado];
            }
        }

        y.cantidadClaves = grado - 1;

        for (int j = cantidadClaves; j >= i + 1; j--) {
            hijos[j + 1] = hijos[j];
        }
        hijos[i + 1] = z;

        for (int j = cantidadClaves - 1; j >= i; j--) {
            claves[j + 1] = claves[j];
        }
        claves[i] = y.claves[grado - 1];
        cantidadClaves++;
    }

    public void eliminar(int clave) {
        int i = 0;
        while (i < cantidadClaves && claves[i] < clave) {
            i++;
        }
        if (i < cantidadClaves && claves[i] == clave) {
            for (int j = i; j < cantidadClaves - 1; j++) {
                claves[j] = claves[j + 1];
            }
            cantidadClaves--;
        } else if (!esHoja) {
            hijos[i].eliminar(clave);
        }
    }

    public void recorrer() {
        for (int i = 0; i < cantidadClaves; i++) {
            if (!esHoja) {
                hijos[i].recorrer();
            }
            System.out.print(claves[i] + " ");
        }
        if (!esHoja) {
            hijos[cantidadClaves].recorrer();
        }
    }
}

