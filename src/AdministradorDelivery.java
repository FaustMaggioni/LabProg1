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

    private final FabricaRepartidorEnAuto fabricaAuto = new FabricaRepartidorEnAuto();
    private final FabricaRepartidorEnMoto fabricaMoto = new FabricaRepartidorEnMoto();
    private final FabricaRepartidorEnBici fabricaBici = new FabricaRepartidorEnBici();
    private final HashMap<Integer, String> menu = new HashMap();
    private final HashMap<Integer, FabricaRepartidores> fabricas = new HashMap();
    private final ScheduledExecutorService pool
            = Executors.newScheduledThreadPool(1);

    public AdministradorDelivery() {
        menu.put(1, "mila");
        menu.put(2, "burguer");
        menu.put(3, "pizza");
        fabricas.put(1,fabricaAuto);
        fabricas.put(2,fabricaMoto);
        fabricas.put(3,fabricaBici);
    }

    public HashMap<Integer, String> pedirMenu() {
        return (HashMap<Integer, String>) menu.clone();
    }

    public void pedirComida(int n) {
        String comida = menu.get(n);
        System.out.println("pedido aceptado");
        FabricaRepartidores fabrica = fabricas.get(n);
        asignar(fabrica,comida);
    }

    public void asignar(FabricaRepartidores fabrica, String comida) {
        Repartidor repartidor = fabrica.crearRepartidor(comida);
        pool.submit(repartidor);
    }
}
