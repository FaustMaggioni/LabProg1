/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.*;

public class AdministradorDelivery {

    private static int contadorPedido = 0;
    private final FabricaRepartidorEnAuto fabricaAuto = new FabricaRepartidorEnAuto();
    private final FabricaRepartidorEnMoto fabricaMoto = new FabricaRepartidorEnMoto();
    private final FabricaRepartidorEnBici fabricaBici = new FabricaRepartidorEnBici();
    private final HashMap<Integer, String> menu = new HashMap();
    private final HashMap<Integer, FabricaRepartidores> fabricas = new HashMap();
    private CopyOnWriteArrayList<Cliente> clientesAConsultar = new CopyOnWriteArrayList<>();
    private ScheduledExecutorService inspectores = Executors.newScheduledThreadPool(5);

    public AdministradorDelivery() {
        this.llenarMenu();
        this.setFabricas();
        this.setInspectores();
    }

    private void setInspectores(){
        for(int i=0; i<5; i++) {
            inspectores.scheduleAtFixedRate(() -> {
                if (!clientesAConsultar.isEmpty()) {
                    Cliente clienteAConsultar = clientesAConsultar.get(0);
                    clientesAConsultar.remove(0);
                    new Inspeccion(clienteAConsultar);
                }
            }, 30, 20, TimeUnit.SECONDS);
        }
    }

    private void llenarMenu(){
        menu.put(1, "mila");
        menu.put(2, "burguer");
        menu.put(3, "pizza");
    }

    private void setFabricas(){
        fabricas.put(1, fabricaAuto);
        fabricas.put(2, fabricaMoto);
        fabricas.put(3, fabricaBici);
    }

    public HashMap<Integer, String> pedirMenu() {
        return (HashMap<Integer, String>) menu.clone();
    }

    public String pedirComida(int n, Cliente cliente) {
        String comida = menu.get(n), pedido;
        contadorPedido++;
        FabricaRepartidores fabrica = fabricas.get(n);
        pedido = "pedido" + contadorPedido;
        asignar(fabrica, pedido, comida);
        añadirCliente(cliente);
        return pedido;
    }

    private void añadirCliente(Cliente cliente){
        clientesAConsultar.add(cliente);
    }

    public void asignar(FabricaRepartidores fabrica, String pedido, String comida) {
        Repartidor repartidor = fabrica.crearRepartidor(pedido, comida);
        repartidor.run();
    }
}
