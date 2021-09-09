

public class FabricaRepartidorEnMoto extends FabricaRepartidores {

    protected Repartidor crearRepartidor(String pedido,String comida) {
        return new RepartidorEnMoto( pedido,comida);
    }

}
