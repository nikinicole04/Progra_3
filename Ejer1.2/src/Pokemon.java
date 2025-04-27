public class Pokemon {
    private String nombre;
    private String tipo;
    private int nivelPoder;
    private String habilidad;
    private String estado;
//Constructor por defecto
    public Pokemon() {
        this.nombre = "Pikachu";
        this.tipo = "Eléctrico";
        this.nivelPoder = 120;
        this.habilidad = "Impactrueno";
        this.estado = "Activo";
    }
//Constructor por paramentros
    public Pokemon(String nombre, String tipo, int nivelPoder, String habilidad, String estado) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivelPoder = nivelPoder;
        this.habilidad = habilidad;
        this.estado = estado;
    }
//Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNivelPoder() {
        return nivelPoder;
    }

    public void setNivelPoder(int nivelPoder) {
        this.nivelPoder = nivelPoder;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public String getEstado() {
        return estado;
    }
    // Metodo para actulizar el estado
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", nivelPoder=" + nivelPoder +
                ", habilidad='" + habilidad + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
