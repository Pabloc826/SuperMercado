package SuperMarket.supermarket.modelos;

public class Alimentos extends SuperMarket{

    public Alimentos(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public String toString() {
        return "Alimnento: " + this.getNombre() + " $" + this.getPrecio();
    }

}
