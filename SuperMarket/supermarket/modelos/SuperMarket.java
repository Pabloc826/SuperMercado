package SuperMarket.supermarket.modelos;

import com.sun.jdi.DoubleValue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SuperMarket implements Comparable<SuperMarket>{
    private String nombre;
    private double precio;

    public SuperMarket(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }


    @Override
    public int compareTo(SuperMarket otroSupermarket) {
        return Double.valueOf(this.precio).compareTo(Double.valueOf(otroSupermarket.getPrecio()));
    }
}