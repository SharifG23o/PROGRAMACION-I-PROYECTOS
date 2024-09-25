package co.edu.uniquindio.poo.model;

public class Bibliotecario {

    private String nombre; 
    private String cedula; 
    private String telefono; 
    private String correo;
    int aniosAntiguedad;
    private int salario;

    public Bibliotecario(String nombre,String cedula, String telefono, String correo, int aniosAntiguedad, int salario){
        this.nombre=nombre;
        this.cedula=cedula;
        this.telefono=telefono;
        this.correo=correo;
        this.aniosAntiguedad=aniosAntiguedad;
        this.salario=salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getAniosAntiguedad() {
        return aniosAntiguedad;
    }

    public void setAniosAntiguedad(int aniosAntiguedad) {
        this.aniosAntiguedad = aniosAntiguedad;
    }

    @Override
    public String toString() {
        return "Bibliotecario [nombre=" + nombre + ", cedula=" + cedula + ", telefono=" + telefono + ", correo="
                + correo + ", aniosAntiguedad=" + aniosAntiguedad + ", salario=" + salario + "]";
    }

    

   
    


    
    
}
