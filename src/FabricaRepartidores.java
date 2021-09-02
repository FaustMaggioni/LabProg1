abstract public class FabricaRepartidores {

    public Repartidor llamarDelivery(){
        Repartidor repartidor = crearRepartidor();
        return repartidor;
    }

    abstract protected Repartidor crearRepartidor();
}
