# 🌳 Árbol B en Java – Tarea 3 de Programación III Melannie

Este es un proyecto de Java en el que se implementa un **Árbol B** con un menú interactivo usando `JOptionPane` y una visualización gráfica sencilla con `Swing`. 

---

## 📌 ¿Qué es un Árbol B?

Un Árbol B es una estructura de datos en forma de árbol que se utiliza para guardar información de manera **ordenada y eficiente**, especialmente cuando se trabaja con grandes volúmenes de datos. A diferencia de los árboles binarios, en el Árbol B **cada nodo puede tener varias claves y varios hijos**. Esto lo hace más compacto y más rápido para búsquedas, inserciones y eliminaciones.

### Características principales:
- Cada nodo puede tener **hasta 2 * grado - 1 claves**.
- Siempre está **balanceado**, es decir, todas las hojas están al mismo nivel.
- Se usa en bases de datos y sistemas de archivos debido a su eficiencia.

---

## 🎯 ¿Qué hace este programa?

El programa permite al usuario trabajar con un Árbol B. Al iniciar, se le pide al usuario que indique el **grado del árbol**, y luego puede hacer las siguientes acciones:

1. **Insertar clave:** Agrega un número al árbol.
2. **Eliminar clave:** Borra un número si está presente.
3. **Buscar clave:** Muestra un mensaje si la clave existe o no.
4. **Mostrar árbol gráficamente:** Abre una ventana donde se dibuja el árbol.
0. **Salir:** Finaliza el programa.

---

## 🔧 ¿Cómo se usa?

Al ejecutar el programa, se muestra una ventana donde puedes escribir el **grado del árbol B**. Luego aparece el menú con las opciones mencionadas anteriormente. Todo se hace por medio de cuadros de texto (JOptionPane), y no es necesario escribir en la consola.

> 📌 *Ejemplo: Si eliges la opción 1 para insertar una clave, el programa te pedirá escribir un número o caracter, que luego será agregado al árbol.*

Cuando el árbol tenga varias claves, puedes usar la opción 4 para **ver gráficamente** cómo están organizadas dentro del árbol.

---

## 🧩 Estructura del código

El proyecto está dividido en varias clases:

### `Tarea3.java` (Clase principal)
- Contiene el menú principal y la lógica para pedir datos al usuario.
- Es el punto de entrada del programa (`main`).
- Llama a los métodos de inserción, eliminación, búsqueda y dibujo del árbol.

### `ArbolB.java` (Clase del Árbol B)
- Contiene el árbol y los métodos para insertar, eliminar y buscar claves.
- Gestiona si el árbol está vacío o si hay que dividir nodos cuando se llenan.

### `NodoArbolB.java` (Clase de Nodo)
- Representa cada nodo del árbol.
- Guarda las claves y los hijos del nodo.
- Tiene lógica para insertar claves si el nodo no está lleno.
- Incluye una función para dividir un nodo cuando ya tiene muchas claves.

### `VentanaArbolB.java` (Interfaz gráfica)
- Utiliza la librería `Swing` de Java para dibujar los nodos del árbol.
- Cada nodo aparece como un círculo con sus claves dentro.
- Se dibujan líneas entre nodos padre e hijos para mostrar la estructura.

---



