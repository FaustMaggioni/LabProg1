
public class RepartidorEnMoto extends Repartidor {

    public RepartidorEnMoto(String pedido, String comida) {
        super(pedido, comida);
        nombre += " en moto";
        velocidad = 4;
    }

    @Override
    protected void arrancar() throws Exception {
        super.arrancar();
        System.out.println(nombre + " se pone el casco, y arranca");
        Thread.sleep(1000);
    }
}
