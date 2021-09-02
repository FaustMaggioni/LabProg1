

public class FabricaRepartidorEnBici extends FabricaRepartidores{
    @Override
    protected Repartidor crearRepartidor(String pedido,String comida) {
        return new RepartidorEnBicicleta( pedido,comida);
    }
}
