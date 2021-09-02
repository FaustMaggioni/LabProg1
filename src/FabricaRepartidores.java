



abstract public class FabricaRepartidores {

    public Repartidor llamarDelivery(String comida){
        Repartidor repartidor = crearRepartidor(comida);
        return repartidor;
    }

    abstract protected Repartidor crearRepartidor(String comida);
}
