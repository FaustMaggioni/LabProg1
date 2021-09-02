
public class RepartidorEnMoto extends Repartidor {

    public RepartidorEnMoto(String comida) {
        super(comida);
    }

    @Override
    protected void repartir() throws Exception {
        super.repartir();
        System.out.println("~~~~~~~~~~ Se pone el casco, y arranca la moto");
        Thread.sleep(5000);
        System.out.println("~~~~~~~~~~ Pone 1ra y comienza el recorrido");
        Thread.sleep(15000);
    }
}
