
public class RepartidorEnBicicleta extends Repartidor {

    public RepartidorEnBicicleta(String pedido, String comida) {
        super(pedido, comida);
        nombre += " en bici";
        velocidad = 2;
    }

    @Override
    protected void arrancar() throws Exception {
        super.arrancar();
        System.out.println(nombre + " desata la bici");
        Thread.sleep(20000);
    }
}
