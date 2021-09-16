/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AdministradorDelivery {
        private static AtomicInteger contadorPedido = new AtomicInteger(0);

        private final FabricaRepartidorEnAuto fabricaAuto = new FabricaRepartidorEnAuto();
        private final FabricaRepartidorEnMoto fabricaMoto = new FabricaRepartidorEnMoto();
        private final FabricaRepartidorEnBici fabricaBici = new FabricaRepartidorEnBici();

        private final HashMap<Integer, String> menu = new HashMap();
        private final HashMap<Integer, FabricaRepartidores> fabricas = new HashMap();

        private Encuesta encuesta;

        public AdministradorDelivery(Encuesta encuesta) {
            this.llenarMenu();
            this.setFabricas();
            this.encuesta = encuesta;
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
            FabricaRepartidores fabrica = getFabrica(n);
            String pedido = "pedido " + contadorPedido.getAndIncrement();
            asignarRepartidorAPedido(fabrica, pedido, comida);
            añadirClienteAEncuesta(cliente);
            return pedido;
        }

        private void añadirClienteAEncuesta(Cliente cliente){
            if(encuesta.encuestaAbierta()) {
                encuesta.addCliente(cliente);
            }
        }

        private FabricaRepartidores getFabrica(int n){
            FabricaRepartidores fabrica = fabricas.get(n);
            return fabrica;
        }

        public void asignarRepartidorAPedido(FabricaRepartidores fabrica, String pedido, String comida) {
            Repartidor repartidor = fabrica.crearRepartidor(pedido, comida);
            Thread repartidorHilo = new Thread(repartidor);
            repartidorHilo.start();
        }
    }
