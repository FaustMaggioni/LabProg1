abstract public class Repartidor implements Runnable{
    public void repartir(){
        //Thread sleep algo.. Las subclases pueden sumar tiempo dependiendo de cada una
    }

    public void run(){
        repartir();
    }
}
