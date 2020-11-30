package modelo;

/**
 *
 * @author marin
 */
public class BibliotecaLibros {
    private int ID_Libro; 
    private String nombre; 
    private String editorial;
    private int numero_de_Cajas; 
    private int anio_de_Edicion;
    private String genero_libro;
    private int precio; 
    private String autor_Libro; 
    private String pais_Autor; 
    private String registrador;
    public BibliotecaLibros(){}
    public BibliotecaLibros(int ID_Libro, String nombre, String editorial, int numero_de_Cajas, int anio_de_Edicion, String genero_libro, int precio, String autor_Libro, String pais_Autor, String registrador) {
        this.ID_Libro = ID_Libro;
        this.nombre = nombre;
        this.editorial = editorial;
        this.numero_de_Cajas = numero_de_Cajas;
        this.anio_de_Edicion = anio_de_Edicion;
        this.genero_libro = genero_libro;
        this.precio = precio;
        this.autor_Libro = autor_Libro;
        this.pais_Autor = pais_Autor;
        this.registrador = registrador;
    }

    public int getID_Libro() {
        return ID_Libro;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getNumero_de_Cajas() {
        return numero_de_Cajas;
    }

    public int getAnio_de_Edicion() {
        return anio_de_Edicion;
    }

    public String getGenero_libro() {
        return genero_libro;
    }

    public int getPrecio() {
        return precio;
    }

    public String getAutor_Libro() {
        return autor_Libro;
    }

    public String getPais_Autor() {
        return pais_Autor;
    }

    public String getRegistrador() {
        return registrador;
    }

    public void setID_Libro(int ID_Libro) {
        this.ID_Libro = ID_Libro;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setNumero_de_Cajas(int numero_de_Cajas) {
        this.numero_de_Cajas = numero_de_Cajas;
    }

    public void setAnio_de_Edicion(int anio_de_Edicion) {
        this.anio_de_Edicion = anio_de_Edicion;
    }

    public void setGenero_libro(String genero_libro) {
        this.genero_libro = genero_libro;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setAutor_Libro(String autor_Libro) {
        this.autor_Libro = autor_Libro;
    }

    public void setPais_Autor(String pais_Autor) {
        this.pais_Autor = pais_Autor;
    }

    public void setRegistrador(String registrador) {
        this.registrador = registrador;
    }  
}
