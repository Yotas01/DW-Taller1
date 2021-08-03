
public class Libro {
    private String titulo;
    private String descripcion;
    private int precio;
    private Autor autor;
    private int publicacion;
    private int paginas;

    public Libro(String titulo, String descripcion, int precio, Autor autor, int publicacion, int paginas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.autor = autor;
        this.publicacion = publicacion;
        this.paginas = paginas;
    }

    public Libro() {
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", autor=" + autor.toString() +
                ", publicacion=" + publicacion +
                ", paginas=" + paginas +
                '}';
    }
}
