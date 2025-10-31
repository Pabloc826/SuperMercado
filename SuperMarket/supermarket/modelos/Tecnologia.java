package SuperMarket.supermarket.modelos;

public class Tecnologia extends SuperMarket{

    public Tecnologia(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public String toString() {
        return "Producto: " + this.getNombre() + " $" + this.getPrecio();
    }

}
