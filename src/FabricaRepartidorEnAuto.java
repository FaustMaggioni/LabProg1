public class FabricaRepartidorEnAuto extends FabricaRepartidores {
    protected Repartidor crearRepartidor() {
        return new RepartidorEnAuto();
    }
}
