package modelo;

/**
 *
 * @author marin
 */
public class BibliotecaLibros {
    private int codigo_libro; 
    private String nombre; 
    private String editorial;
    private int numero_de_Cajas; 
    private int anio_de_Edicion;
    private String genero_libro;
    private int precio; 
    private String autor_Libro; 
    private String pais_Autor; 
    private int registrador;
    public BibliotecaLibros(){}

    public BibliotecaLibros(int codigo_libro, String nombre, String editorial, int numero_de_Cajas, int anio_de_Edicion, String genero_libro, int precio, String autor_Libro, String pais_Autor, int registrador) {
        this.codigo_libro = codigo_libro;
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

    public int getCodigo_libro() {
        return codigo_libro;
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

    public int getRegistrador() {
        return registrador;
    }
    
    

   
}
