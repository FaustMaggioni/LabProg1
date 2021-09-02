public class RepartidorEnBicicleta extends Repartidor {

    @Override
    protected void repartir() throws Exception {
        super.repartir();
        System.out.println("------------------- Arranca a pedalear");
        Thread.sleep(20000);
    }
}
