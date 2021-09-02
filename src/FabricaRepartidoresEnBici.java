public class FabricaRepartidoresEnBici extends FabricaRepartidores{
    @Override
    protected Repartidor crearRepartidor() {
        return new RepartidorEnBicicleta();
    }
}
