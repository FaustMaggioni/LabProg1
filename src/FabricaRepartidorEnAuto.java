

public class FabricaRepartidorEnAuto extends FabricaRepartidores {

    public FabricaRepartidorEnAuto() {

    }

    protected Repartidor crearRepartidor( String comida) {
        return new RepartidorEnAuto(comida);
    }
}
