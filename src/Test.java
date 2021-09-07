
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public static void main(String[] args) {
        AdministradorDelivery delivery = new AdministradorDelivery();
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        AtomicInteger cont = new AtomicInteger();
        Runnable ejecutable = crearEjecutable(delivery,cont);
        pool.scheduleAtFixedRate(ejecutable, 0, 3, TimeUnit.SECONDS);
    }

    public static Runnable crearEjecutable(AdministradorDelivery delivery, AtomicInteger cont){
        Runnable ejecutable = () -> {
            Thread hilo = new Thread(new Cliente(delivery, cont.getAndIncrement()));
            hilo.start();
        };
        return ejecutable;
    }
}
