package PrimerParcial;

public class Niño {
    private String dni;
    private String nombres;
    private String apellidos;
    private int edad;
    private String telefonoPadre;
    private String refrigerio;
    private String bebida;
    private int numeroRifa;
    private boolean ganoRifa;

    public Niño(String dni, String nombres, String apellidos, int edad, String telefonoPadre) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.telefonoPadre = telefonoPadre;
        this.ganoRifa = false;
    }

    public String getDni() {
        return dni;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getTelefonoPadre() {
        return telefonoPadre;
    }

    public String getRefrigerio() {
        return refrigerio;
    }

    public void setRefrigerio(String refrigerio) {
        this.refrigerio = refrigerio;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public int getNumeroRifa() {
        return numeroRifa;
    }

    public void setNumeroRifa(int numeroRifa) {
        this.numeroRifa = numeroRifa;
    }

    public boolean isGanoRifa() {
        return ganoRifa;
    }

    public void setGanoRifa(boolean ganoRifa) {
        this.ganoRifa = ganoRifa;
    }

    @Override
    public String toString() {
        return "Niño{" +
                "DNI='" + dni + '\'' +
                ", Nombres='" + nombres + '\'' +
                ", Apellidos='" + apellidos + '\'' +
                ", Edad=" + edad +
                ", Teléfono del padre='" + telefonoPadre + '\'' +
                ", Refrigerio='" + refrigerio + '\'' +
                ", Bebida='" + bebida + '\'' +
                ", Número de Rifa=" + numeroRifa +
                ", Ganó Rifa=" + (ganoRifa ? "Sí" : "No") +
                '}';
    }
}
