package SuperMarket.supermarket.modelos;

public class GondolaRopaZapatillas extends SuperMarket {



    public GondolaRopaZapatillas(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public String toString() {
        return "Indumentaria: " + this.getNombre() + " $" + this.getPrecio();
    }


}
