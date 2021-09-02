/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AdministradorDelivery {

    private static int contadorPedido = 0;
    private final FabricaRepartidorEnAuto fabricaAuto = new FabricaRepartidorEnAuto();
    private final FabricaRepartidorEnMoto fabricaMoto = new FabricaRepartidorEnMoto();
    private final FabricaRepartidorEnBici fabricaBici = new FabricaRepartidorEnBici();
    private final HashMap<Integer, String> menu = new HashMap();
    private final HashMap<Integer, FabricaRepartidores> fabricas = new HashMap();
    private final ScheduledExecutorService pool
            = Executors.newScheduledThreadPool(5);

    public AdministradorDelivery() {
        menu.put(1, "mila");
        menu.put(2, "burguer");
        menu.put(3, "pizza");
        fabricas.put(1, fabricaAuto);
        fabricas.put(2, fabricaMoto);
        fabricas.put(3, fabricaBici);
    }

    public HashMap<Integer, String> pedirMenu() {
        return (HashMap<Integer, String>) menu.clone();
    }

    public String pedirComida(int n) {
        String comida = menu.get(n), pedido;
        contadorPedido++;
        FabricaRepartidores fabrica = fabricas.get(n);
        pedido = "pedido" + contadorPedido;
        asignar(fabrica, pedido, comida);
        return pedido;
    }

    public void asignar(FabricaRepartidores fabrica, String pedido, String comida) {
        Repartidor repartidor = fabrica.crearRepartidor(pedido, comida);
        pool.submit(repartidor);
    }
}
