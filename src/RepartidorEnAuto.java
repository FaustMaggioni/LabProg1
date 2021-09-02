public class RepartidorEnAuto extends Repartidor {
    protected void repartir() throws Exception {
        super.repartir();
        System.out.println("......... Calienta un poco el auto");
        Thread.sleep(5000);
        System.out.println("......... Arranca a repartir");
        Thread.sleep(10000);
    }
}
