import java.util.ArrayList;

public class Informe {
    public void generarInformePedidos(ArrayList<Pedido> pedidos) {
        System.out.println("Informe de Pedidos:");
        System.out.println("-------------------");
        for (Pedido pedido : pedidos) {
            System.out.println("ID de Pedido: " + pedido.getIdPedido());
            System.out.println("Productos:");
            for (Producto producto : pedido.getProductos()) {
                System.out.println("- " + producto.getNombre() + " - Cantidad: " + producto.getCantidadStock());
            }
            System.out.println("Estado: " + pedido.getEstado());
            System.out.println("Fecha y Hora: " + pedido.getFechaHora());
            System.out.println();
        }
    }

    public void generarInformeInventario(ArrayList<Producto> inventario) {
        System.out.println("Informe de Inventario:");
        System.out.println("---------------------");
        for (Producto producto : inventario) {
            System.out.println("ID: " + producto.getId());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Descripción: " + producto.getDescripcion());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Cantidad en Stock: " + producto.getCantidadStock());
            System.out.println();
        }
    }
}
