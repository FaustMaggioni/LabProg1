

public class FabricaRepartidorEnAuto extends FabricaRepartidores {

    public FabricaRepartidorEnAuto() {}

    protected Repartidor crearRepartidor(String pedido, String comida) {
        return new RepartidorEnAuto( pedido,comida);
    }
}
