/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class AdministradorDelivery {

    private static int contadorPedido = 0;
    private final FabricaRepartidorEnAuto fabricaAuto = new FabricaRepartidorEnAuto();
    private final FabricaRepartidorEnMoto fabricaMoto = new FabricaRepartidorEnMoto();
    private final FabricaRepartidorEnBici fabricaBici = new FabricaRepartidorEnBici();
    private final HashMap<Integer, String> menu = new HashMap();
    private final HashMap<Integer, FabricaRepartidores> fabricas = new HashMap();
    private LinkedBlockingQueue<Cliente> clientesAConsultar = new LinkedBlockingQueue<Cliente>();
    private CopyOnWriteArrayList<Integer> calificaciones = new CopyOnWriteArrayList<Integer>();
    private ScheduledExecutorService inspectores = Executors.newScheduledThreadPool(5);
    private boolean encuestaAbierta = true;

    public AdministradorDelivery() {
        this.llenarMenu();
        this.setFabricas();
        this.setEncuesta();
        this.setCorte();
    }

    private void setEncuesta() {
        for(int i=0; i<5; i++) {
            inspectores.scheduleAtFixedRate(() -> {
                try {
                    Cliente clienteAConsultar = clientesAConsultar.take();
                    int calificacion = clienteAConsultar.contestarEncuesta();
                    calificaciones.add(calificacion);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }, 30, 20, TimeUnit.SECONDS);
        }
    }

    private void setCorte(){
        inspectores.schedule(() -> {
            inspectores.shutdownNow();
            encuestaAbierta = false;
            double promedioCalificaciones = calcularPromedioCalificaciones();
            System.out.println(" - - - - - RESULTADOS DE LA ENCUESTA!!!!! \n PROMEDIO CALIFICACIONES: "+promedioCalificaciones);
        }, 1, TimeUnit.MINUTES);
    }

    private double calcularPromedioCalificaciones(){
        int sumatoria=0;
        int tam = calificaciones.size();
        for(int i=0; i<tam;i++){
            sumatoria+= (int) calificaciones.get(i);
        }
        double promedio = sumatoria/tam;
        return promedio;
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
        String comida = menu.get(n);
        contadorPedido++;
        FabricaRepartidores fabrica = getFabrica(n);
        String pedido = "pedido" + contadorPedido;
        asignar(fabrica, pedido, comida);
        if(encuestaAbierta) {
            añadirCliente(cliente);
        }
        return pedido;
    }

    private FabricaRepartidores getFabrica(int n){
        FabricaRepartidores fabrica = fabricas.get(n);
        return fabrica;
    }

    private void añadirCliente(Cliente cliente) {
        try {
            clientesAConsultar.put(cliente);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    public void asignar(FabricaRepartidores fabrica, String pedido, String comida) {
        Repartidor repartidor = fabrica.crearRepartidor(pedido, comida);
        repartidor.run();
    }
}
