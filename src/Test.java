

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {
        AdministradorDelivery delivery = new AdministradorDelivery();
        ScheduledExecutorService pool
                = Executors.newScheduledThreadPool(1);
        pool.scheduleAtFixedRate(new Cliente(delivery), 0, 3, TimeUnit.SECONDS);
    }
}
