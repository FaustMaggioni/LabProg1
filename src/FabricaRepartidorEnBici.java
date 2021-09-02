

public class FabricaRepartidorEnBici extends FabricaRepartidores{
    @Override
    protected Repartidor crearRepartidor(String comida) {
        return new RepartidorEnBicicleta(               comida);
    }
}
