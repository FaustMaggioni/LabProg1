abstract public class Repartidor implements Runnable{

    public void run(){
        try {
            repartir();
            System.out.println("llega a destino!");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    protected void repartir() throws Exception{
        System.out.println("Busca la direccion en Google Maps");
        Thread.sleep(6000);
    }

}
