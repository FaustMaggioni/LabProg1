public class FabricaRepartidorEnMoto extends FabricaRepartidores {
    //Fabrica concreta

    @Override
    protected Repartidor crearRepartidor() {
        return new RepartidorEnMoto();
    }
}
