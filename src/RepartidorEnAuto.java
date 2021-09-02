
public class RepartidorEnAuto extends Repartidor {

    public RepartidorEnAuto(String pedido, String comida) {
        super(pedido, comida);
        nombre += " en auto";
        velocidad = 3;
    }

    @Override
    protected void arrancar() throws Exception {
        super.arrancar();
        System.out.println(nombre + " calienta el motor");
        Thread.sleep(1000);
    }
}
