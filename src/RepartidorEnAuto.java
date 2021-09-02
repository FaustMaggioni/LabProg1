
public class RepartidorEnAuto extends Repartidor {

    public RepartidorEnAuto(String comida) {
        super(comida);
    }
    
    protected void repartir() throws Exception {
        super.repartir();
        System.out.println("......... Calienta un poco el auto");
        Thread.sleep(5000);
        System.out.println("......... Arranca a repartir");
        Thread.sleep(10000);
    }
}
