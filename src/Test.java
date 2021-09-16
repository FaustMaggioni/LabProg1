
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

    public class Test {
        private static int DELAY_INICIAL = 0;
        private static int INTERVALO = 3;

        public static void main(String[] args) {
            Encuesta encuesta = new Encuesta();
            AdministradorDelivery delivery = new AdministradorDelivery(encuesta);
            ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
            AtomicInteger cont = new AtomicInteger();

            Thread hiloEncuesta = new Thread(encuesta);

            hiloEncuesta.start();
            pool.scheduleAtFixedRate(new Cliente(delivery,cont.getAndIncrement()), DELAY_INICIAL, INTERVALO, TimeUnit.SECONDS);
        }

    }
