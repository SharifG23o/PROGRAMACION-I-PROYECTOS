package co.edu.uniquindio.poo.application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import co.edu.uniquindio.poo.model.Biblioteca;
import co.edu.uniquindio.poo.model.Bibliotecario;
import co.edu.uniquindio.poo.model.Libro;
import co.edu.uniquindio.poo.model.Prestamo;

public class App {
    public static void main(String[] args) {

        LinkedList<Libro> listaLibros = new LinkedList<>();
        ArrayList<Bibliotecario> listaBibliotecarios = new ArrayList<>();
        // Crear la biblioteca sin prestamos iniciales
        Biblioteca biblioteca = new Biblioteca("Alejandría", 100000, 20);

        // Crear un libro
        Libro libro = new Libro("15678", "A28931", "Clara Grima", "En busca del grafo perdido", "Ariel", LocalDate.of(2023, 06, 23),100);

        // Crear un bibliotecario
        Bibliotecario bibliotecario = new Bibliotecario("Sharif", "1094898051", "3104553300", "sharif@gmail.com", 12,2400000);

        Prestamo prestamo= new Prestamo("Don quijote", "123", LocalDate.of(2023, 01, 05), LocalDate.of(2023, 01, 20));

        // Agregar libro y bibliotecario a la biblioteca
        biblioteca.crearLibro(libro);
        listaLibros.add(libro);
        biblioteca.crearBibliotecario(bibliotecario);
        listaBibliotecarios.add(bibliotecario);
        biblioteca.crearPrestamo(prestamo);

        // Mostrar información de la biblioteca y el bibliotecario
        JOptionPane.showMessageDialog(null, biblioteca);
        JOptionPane.showMessageDialog(null, bibliotecario);
    }
}
