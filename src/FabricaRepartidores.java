



abstract public class FabricaRepartidores {

    public Repartidor llamarDelivery(String pedido,String comida){
        Repartidor repartidor = crearRepartidor( pedido,comida);
        return repartidor;
    }

    abstract protected Repartidor crearRepartidor(String pedido,String comida);
}
