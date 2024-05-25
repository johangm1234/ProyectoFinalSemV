import java.util.ArrayList;

public class Pedido {
    private int id;
    private ArrayList<Producto> productos;
    private String estado;
    private String fechaHora;

    public Pedido(int id, ArrayList<Producto> productos, String estado, String fechaHora) {
        this.id = id;
        this.productos = productos;
        this.estado = estado;
        this.fechaHora = fechaHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", productos=" + productos +
                ", estado='" + estado + '\'' +
                ", fechaHora='" + fechaHora + '\'' +
                '}';
    }
}
