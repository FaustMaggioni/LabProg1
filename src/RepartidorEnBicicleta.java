

public class RepartidorEnBicicleta extends Repartidor {

    public RepartidorEnBicicleta(String comida) {
        super(comida);
    }

    @Override
    protected void repartir() throws Exception {
        super.repartir();
        System.out.println("------------------- Arranca a pedalear");
        Thread.sleep(20000);
    }
}
