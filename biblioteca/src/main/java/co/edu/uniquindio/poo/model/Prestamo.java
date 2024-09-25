package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prestamo {

    private String nombre;
    private String codigo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaEntregaPrestamo;
    private List<Libro> listaLibros;  // Lista para almacenar los libros en el préstamo

    public Prestamo(String nombre, String codigo, LocalDate fechaPrestamo, LocalDate fechaEntregaPrestamo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntregaPrestamo = fechaEntregaPrestamo;
        this.listaLibros = new ArrayList<>();  // Inicialización de la lista de libros
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaEntregaPrestamo() {
        return fechaEntregaPrestamo;
    }

    public void setFechaEntregaPrestamo(LocalDate fechaEntregaPrestamo) {
        this.fechaEntregaPrestamo = fechaEntregaPrestamo;
    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    @Override
    public String toString() {
        return "Prestamo [nombre=" + nombre + ", codigo=" + codigo + ", fechaPrestamo=" + fechaPrestamo
                + ", fechaEntregaPrestamo=" + fechaEntregaPrestamo + "]";
    }

    // Método para adicionar un libro al préstamo
    public String adicionarLibroAlPrestamo(Libro libro) {
        if (libro == null) {
            return "El libro no puede ser nulo";
        }

        // Verificar si el libro tiene unidades disponibles
        if (libro.getUnidadesDisponibles() <= 0) {
            return "No hay unidades disponibles para el libro: " + libro.getTitulo();
        }

        // Disminuir la cantidad de unidades disponibles
        libro.setUnidadesDisponibles(libro.getUnidadesDisponibles() - 1);

        // Verificar si después de disminuir las unidades, el libro ya no está disponible
        if (libro.getUnidadesDisponibles() == 0) {
            libro.setDisponible(false); // Actualizar el estado del libro a 'no disponible'
        }

        // Adicionar el libro al préstamo
        listaLibros.add(libro);

        return "El libro '" + libro.getTitulo() + "' ha sido añadido al préstamo.";
    }

}
