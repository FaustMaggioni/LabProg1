

public class FabricaRepartidorEnMoto extends FabricaRepartidores {
    //Fabrica concreta

    protected Repartidor crearRepartidor(String pedido,String comida) {
        return new RepartidorEnMoto( pedido,comida);
    }

}
