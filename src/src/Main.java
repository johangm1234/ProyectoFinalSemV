import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Pedido> pedidos = new ArrayList<>();
    private static ArrayList<Producto> inventario = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;
        while (!salir) {
            mostrarMenuPrincipal();
            int opcionPrincipal = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcionPrincipal) {
                case 1:
                    gestionarPedidos(scanner);
                    break;
                case 2:
                    generarInformes();
                    break;
                case 3:
                    administrarUsuarios(scanner);
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("Sistema de Gestión:");
        System.out.println("1. Gestionar Pedidos");
        System.out.println("2. Generar Informes");
        System.out.println("3. Administrar Usuarios");
        System.out.println("4. Salir");
        System.out.print("Ingrese su opción: ");
    }

    private static void gestionarPedidos(Scanner scanner) {
        boolean salir = false;
        while (!salir) {
            mostrarMenuPedidos();
            int opcionPedidos = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcionPedidos) {
                case 1:
                    agregarPedido(scanner);
                    break;
                case 2:
                    modificarPedido(scanner);
                    break;
                case 3:
                    eliminarPedido(scanner);
                    break;
                case 4:
                    mostrarPedidos();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    private static void mostrarMenuPedidos() {
        System.out.println("Gestionar Pedidos:");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Modificar Pedido");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Ver Pedidos");
        System.out.println("5. Volver al Menú Principal");
        System.out.print("Ingrese su opción: ");
    }

    private static void agregarPedido(Scanner scanner) {
        System.out.println("Ingrese los detalles del nuevo pedido:");
        System.out.print("ID del Pedido: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        ArrayList<Producto> productosPedido = new ArrayList<>();
        System.out.println("Ingrese los productos del pedido (Ingrese 0 para finalizar):");
        while (true) {
            System.out.print("ID del Producto: ");
            int idProducto = scanner.nextInt();
            if (idProducto == 0) break;
            Producto producto = buscarProductoPorId(idProducto);
            if (producto != null) {
                productosPedido.add(producto);
            } else {
                System.out.println("Producto no encontrado.");
            }
        }

        System.out.print("Estado del Pedido: ");
        String estado = scanner.next();
        System.out.print("Fecha y Hora del Pedido: ");
        String fechaHora = scanner.next();

        Pedido nuevoPedido = new Pedido(id, productosPedido, estado, fechaHora);
        pedidos.add(nuevoPedido);
        System.out.println("Pedido agregado correctamente.");
    }

    private static void modificarPedido(Scanner scanner) {
        System.out.println("Ingrese el ID del pedido que desea modificar:");
        int idModificar = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Pedido pedidoModificar = buscarPedidoPorId(idModificar);
        if (pedidoModificar != null) {
            System.out.println("Ingrese los nuevos detalles del pedido:");
            System.out.print("Nuevo Estado: ");
            pedidoModificar.setEstado(scanner.nextLine());
            System.out.print("Nueva Fecha y Hora: ");
            pedidoModificar.setFechaHora(scanner.nextLine());
            System.out.println("Pedido modificado correctamente.");
        } else {
            System.out.println("No se encontró un pedido con ese ID.");
        }
    }

    private static void eliminarPedido(Scanner scanner) {
        System.out.println("Ingrese el ID del pedido que desea eliminar:");
        int idEliminar = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Pedido pedidoEliminar = buscarPedidoPorId(idEliminar);
        if (pedidoEliminar != null) {
            pedidos.remove(pedidoEliminar);
            System.out.println("Pedido eliminado correctamente.");
        } else {
            System.out.println("No se encontró un pedido con ese ID.");
        }
    }

    private static Pedido buscarPedidoPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    private static Producto buscarProductoPorId(int id) {
        for (Producto producto : inventario) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    private static void mostrarPedidos() {
        System.out.println("Lista de Pedidos:");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }

    private static void generarInformes() {
        private static void generarInformes() {
            System.out.println("Generando informes...");
        
            // Calcular el total de pedidos
            int totalPedidos = pedidos.size();
        
            // Calcular el total de productos vendidos
            int totalProductosVendidos = 0;
            for (Pedido pedido : pedidos) {
                totalProductosVendidos += pedido.getProductos().size();
            }
        
            // Calcular el estado promedio de los pedidos
            double estadoPromedio = 0;
            for (Pedido pedido : pedidos) {
                switch (pedido.getEstado()) {
                    case "En proceso":
                        estadoPromedio += 0.5; // Consideramos que los pedidos "En proceso" tienen un estado medio
                        break;
                    case "Entregado":
                        estadoPromedio += 1;
                        break;
                    case "Cancelado":
                        estadoPromedio += 0; // Los pedidos cancelados no contribuyen al estado promedio
                        break;
                    default:
                        // Otros estados no se consideran en este cálculo
                        break;
                }
            }
            estadoPromedio /= totalPedidos; // Calcular el promedio dividiendo entre el total de pedidos
        
            
            System.out.println("Informe:");
            System.out.println("Total de Pedidos: " + totalPedidos);
            System.out.println("Total de Productos Vendidos: " + totalProductosVendidos);
            System.out.println("Estado Promedio de los Pedidos: " + estadoPromedio);
        }
                System.out.println("Generar informes...");
    }

    private static void administrarUsuarios(Scanner scanner) {
        boolean salir = false;
        while (!salir) {
            mostrarMenuUsuarios();
            int opcionUsuarios = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcionUsuarios) {
                case 1:
                    agregarUsuario(scanner);
                    break;
                case 2:
                    modificarUsuario(scanner);
                    break;
                case 3:
                    eliminarUsuario(scanner);
                    break;
                case 4:
                    mostrarUsuarios();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    private static void mostrarMenuUsuarios() {
        System.out.println("Administrar Usuarios:");
        System.out.println("1. Agregar Usuario");
        System.out.println("2. Modificar Usuario");

        private static void agregarUsuario(Scanner scanner) {
            System.out.println("Ingrese los detalles del nuevo usuario:");
            System.out.print("ID del Usuario: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            System.out.print("Nombre del Usuario: ");
            String nombre = scanner.nextLine();
            System.out.print("Correo Electrónico del Usuario: ");
            String correo = scanner.nextLine();
            System.out.print("Rol del Usuario: ");
            String rol = scanner.nextLine();
        
            Usuario nuevoUsuario = new Usuario(id, nombre, correo, rol);
            usuarios.add(nuevoUsuario);
            System.out.println("Usuario agregado correctamente.");
        }
        
        private static void eliminarUsuario(Scanner scanner) {
            System.out.println("Ingrese el ID del usuario que desea eliminar:");
            int idEliminar = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
        
            Usuario usuarioEliminar = buscarUsuarioPorId(idEliminar);
            if (usuarioEliminar != null) {
                usuarios.remove(usuarioEliminar);
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("No se encontró un usuario con ese ID.");
            }
        }
        
        private static void mostrarUsuarios() {
            System.out.println("Lista de Usuarios:");
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }
        
        private static Usuario buscarUsuarioPorId(int id) {
            for (Usuario usuario : usuarios) {
                if (usuario.getId() == id) {
                    return usuario;
                }
            }
            return null;
        }
    
    }        
}