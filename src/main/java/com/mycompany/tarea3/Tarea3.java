/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tarea3;

/**
 *
 * @author Rosse Lorenzana
 */
import javax.swing.*;

public class Tarea3 {
    public static void main(String[] args) {
        int grado = Integer.parseInt(JOptionPane.showInputDialog("ingrese el grado del arbol B:"));
        ArbolB arbol = new ArbolB(grado);

        String menu = "1. Insertar clave\n"
                    + "2. Eliminar clave\n"
                    + "3. Buscar clave\n"
                    + "4. Mostrar arbol graficamente\n"
                    + "0. Salir";

        int opcion;
        do {
            String seleccion = JOptionPane.showInputDialog(menu + "\nseleccione una opcion:");
            if (seleccion == null) break;
            opcion = Integer.parseInt(seleccion);

            switch (opcion) {
                case 1:
                    int claveInsertar = Integer.parseInt(JOptionPane.showInputDialog("ingrese la clave a insertar:"));
                    arbol.insertar(claveInsertar);
                    break;
            
                case 2:
                    int claveEliminar = Integer.parseInt(JOptionPane.showInputDialog("ingrese la clave a eliminar:"));
                    arbol.eliminar(claveEliminar);
                    break;
                case 3:
                    int claveBuscar = Integer.parseInt(JOptionPane.showInputDialog("ingrese la clave a buscar:"));
                    NodoArbolB encontrado = arbol.buscar(claveBuscar);
                    if (encontrado != null) {
                        JOptionPane.showMessageDialog(null, "✅ clave encontrada.");
                    } else {
                        JOptionPane.showMessageDialog(null, "❌ clave no encontrada.");
                    }
                    break;
                case 4:
                    mostrarGrafica(arbol.raiz);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no valida.");
            }
        } while (opcion != 0);
    }

    public static void mostrarGrafica(NodoArbolB raiz) {
        JFrame ventana = new JFrame("Arbol B");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(800, 600);
        ventana.add(new VentanaArbolB(raiz));
        ventana.setVisible(true);
    }
}

