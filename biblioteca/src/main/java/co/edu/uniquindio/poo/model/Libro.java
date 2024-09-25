package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Libro {

    private String codigo;
    private String isbn;
    private String autor;
    private String titulo;
    private String editorial;
    private LocalDate fechaPublicacion;
    private int unidadesDisponibles;
    private boolean disponible;

    public Libro(String codigo, String isbn, String autor, String titulo, String editorial, LocalDate fechaPublicacion,
            int unidadesDisponibles) {
        this.codigo = codigo;
        this.isbn = isbn;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        this.unidadesDisponibles = unidadesDisponibles;
        this.disponible = unidadesDisponibles > 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
        this.disponible = unidadesDisponibles > 0;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "\nLibro \n [codigo: " + codigo +
                ", \n isbn: " + isbn +
                ", \n autor: " + autor +
                ", \n titulo: " + titulo +
                ", \n editorial: " + editorial +
                ", \n fechaPublicacion: " + fechaPublicacion +
                ", \n unidadesDisponibles: " + unidadesDisponibles +
                ", \n disponible: " + (disponible ? "Sí" : "No") + "]";
    }
}
