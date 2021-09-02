
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

    private final AdministradorDelivery delivery;

    public Cliente(AdministradorDelivery delivery) {
        this.delivery = delivery;
    }

    @Override
    public void run() {
        HashMap<Integer, String> menu = delivery.pedirMenu();
        int i = new Random().nextInt(menu.size())+1;
        delivery.pedirComida(i);
    }

}
