import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Producto> productos = new ArrayList<>();
    private static final double IVA = 0.21;
    private static final double MINIMODESCUENTO = 3000.0;
    private static final double DESCUENTO = 0.05;


    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public double calcularSubTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecioProducto();
        }
        return total;
    }

   
    public boolean aplicarDescuento() {
        return calcularSubTotal() > MINIMODESCUENTO;
    }

    
    public double calcularSubtotalDescuento() {
        double total = calcularSubTotal();
        if (aplicarDescuento()) {
            total = total * DESCUENTO;
        }
        return total;
    }

    public double calcularTotalIVA() {
        return (calcularSubtotalDescuento() * (IVA) + calcularSubtotalDescuento());
    }

    
    public Cliente getCliente() { 
        return cliente; }
        
    public List<Producto> getProductos() { 
        return productos; }
}
