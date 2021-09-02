

public class FabricaRepartidorEnMoto extends FabricaRepartidores {
    //Fabrica concreta

    protected Repartidor crearRepartidor(String comida) {
        return new RepartidorEnMoto(comida);
    }

}
