
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public static void main(String[] args) {
        AdministradorDelivery delivery = new AdministradorDelivery();
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        AtomicInteger cont = new AtomicInteger();
        Runnable ejecutable = () -> {
            Thread hilo = new Thread(new Cliente(delivery, cont.get()));
            cont.getAndIncrement();
            hilo.start();
        };
        pool.scheduleAtFixedRate(ejecutable, 0, 3, TimeUnit.SECONDS);
    }
}
