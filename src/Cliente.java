
import java.util.HashMap;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tog
 */
public class Cliente implements Runnable {

    private static int contador = 0;
    private String nombre;
    private final AdministradorDelivery delivery;
    private Random generator = new Random();

    public Cliente(AdministradorDelivery delivery) {
        this.delivery = delivery;
        contador ++;
        nombre = "C"+contador;
    }

    @Override
    public void run() {
        HashMap<Integer, String> menu = delivery.pedirMenu();
        try {
            System.out.println(nombre+" mira el menu");
            Thread.sleep(1000); // simula estar eligiendo que pedir
        } catch (Exception e) {

        };
        int i = generator.nextInt(menu.size()) + 1;
        String pedido = delivery.pedirComida(i);
        System.out.println(nombre + " pide "+ menu.get(i)+ " y recibe la comanda: "+pedido);
    }

}
