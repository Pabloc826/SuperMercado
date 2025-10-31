package SuperMarket.principal;

import SuperMarket.supermarket.modelos.Alimentos;
import SuperMarket.supermarket.modelos.GondolaRopaZapatillas;
import SuperMarket.supermarket.modelos.SuperMarket;
import SuperMarket.supermarket.modelos.Tecnologia;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        int opcionDelUsuario = 0;
        double limiteTrjeta = 0;
        ArrayList<Alimentos> alimentos = new ArrayList<>();
        ArrayList<GondolaRopaZapatillas> indumentarias = new ArrayList<>();
        ArrayList<Tecnologia> tecnologias = new ArrayList<>();
        ArrayList<SuperMarket> todasLasCompras = new ArrayList<>();
        double totalGastado = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese el límite de la tarjeta");
        limiteTrjeta = teclado.nextDouble();
        while (opcionDelUsuario != 2) {
            System.out.println("""
                    *****************************
                    Desea realizar una compra?
                    1- Si
                    2- No
                    3- Ver mis compras
                    *****************************
                    """);
            opcionDelUsuario = teclado.nextInt();

            switch (opcionDelUsuario) {
                case 1:
                    System.out.println("""
                            *****************************
                            
                            ¿Qué desea comprar?
                            1- Alimentos
                            2- Indumentaria
                            3- Tecnología/Electrodomésticos
                            
                            *****************************
                            """);
                    int opcionElegida = teclado.nextInt();

                    switch (opcionElegida) {
                        case 1:
                            System.out.println("¿Que alimento desea comprar?");
                            String alimentoElegido = teclado.next();
                            System.out.println("Precio del alimento");
                            double precioAlimento = teclado.nextDouble();
                            Alimentos alimento = new Alimentos(alimentoElegido, precioAlimento);
                            alimentos.add(alimento);
                            todasLasCompras.add(alimento);
                            for (Alimentos value : alimentos) {
                                System.out.println(value);
                            }
                            if (limiteTrjeta < precioAlimento){
                                System.out.println("Saldo insuficiente");
                            } else {
                                limiteTrjeta -= precioAlimento;
                                System.out.println("Saldo restante " + "$" + limiteTrjeta);
                            }
                            break;
                        case 2:
                            System.out.println("¿Que indumentaria desea comprar?");
                            String indumentariaElegida = teclado.next();
                            System.out.println("¿Cuál es el precio de la indumentaria?");
                            double precioIndumentaria = teclado.nextDouble();
                            GondolaRopaZapatillas indumentaria = new GondolaRopaZapatillas(indumentariaElegida, precioIndumentaria);
                            indumentarias.add(indumentaria);
                            todasLasCompras.add(indumentaria);
                            for (GondolaRopaZapatillas value : indumentarias) {
                                System.out.println(value);
                            }
                            if (limiteTrjeta < precioIndumentaria){
                                System.out.println("Saldo insuficiente");
                            } else {
                                limiteTrjeta -= precioIndumentaria;
                                System.out.println("Saldo restante " + "$" + limiteTrjeta);
                            }
                            break;
                        case 3:
                            System.out.println("¿Que aparato desea comprar?");
                            String tecnologiaElegida = teclado.next();
                            System.out.println("¿Cual es el precio?");
                            double precioTecnologia = teclado.nextDouble();
                            Tecnologia tecnologia = new Tecnologia(tecnologiaElegida, precioTecnologia);
                            tecnologias.add(tecnologia);
                            todasLasCompras.add(tecnologia);
                            for (Tecnologia value : tecnologias) {
                                System.out.println(value);
                            }
                            if (limiteTrjeta < precioTecnologia){
                                System.out.println("Saldo insuficiente");
                            } else {
                                limiteTrjeta -= precioTecnologia;
                                System.out.println("Saldo restante " + "$" + limiteTrjeta);
                            }
                            break;
                    }
                    break;
                case 2:
                    todasLasCompras.sort(Comparator.comparing(SuperMarket::getPrecio));
                    System.out.println("Compras realizadas: \n");
                    for (SuperMarket todasLasCompra : todasLasCompras) {
                        System.out.println(todasLasCompra);
                        totalGastado += todasLasCompra.getPrecio();
                    }

                    System.out.println("Total gastado: " + totalGastado);
                    System.out.println("Finalizando el programa. Muchas gracias por usar nuestros servicios :D");
                    break;
                case 3:
                    todasLasCompras.sort(Comparator.comparing(SuperMarket::getPrecio));
                    System.out.println("Compras realizadas hasta el momento: ");
                    for (SuperMarket todasLasCompra : todasLasCompras) {
                        System.out.println(todasLasCompra);
                    }
                    break;
            }
        }
    }
}