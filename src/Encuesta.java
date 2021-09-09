public class Encuesta implements Runnable {
    private static int DURACION_ENCUESTA = 1;
    private static int CANTIDAD_ENCUESTADORES = 5;
    private static int DELAY_INICIAL = 30;
    private static int INTERVALO_ENCUESTA = 20;

    private LinkedBlockingQueue<Cliente> clientesAConsultar = new LinkedBlockingQueue<Cliente>();
    private CopyOnWriteArrayList<Integer> calificaciones = new CopyOnWriteArrayList<Integer>();
    private ScheduledExecutorService inspectores = Executors.newScheduledThreadPool(CANTIDAD_ENCUESTADORES);

    private boolean encuestaAbierta = true;

    public void run(){
        this.comenzarEncuesta();
        this.setCorte();
    }

    public void addCliente(Cliente cliente){
        clienteAConsultar.add(cliente);
    }

    public boolean encuestaAbierta(){
        return encuestaAbierta;
    }

    private void comenzarEncuesta() {
        for(int i=0; i<CANTIDAD_ENCUESTADORES; i++) {
            inspectores.scheduleAtFixedRate(() -> {
                try {
                    Cliente clienteAConsultar = clientesAConsultar.take();
                    int calificacion = clienteAConsultar.contestarEncuesta();
                    calificaciones.add(calificacion);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }, DELAY_INICIAL, INTERVALO_ENCUESTA, TimeUnit.SECONDS);
        }
    }

    private void setCorte(){
        inspectores.schedule(() -> {
            inspectores.shutdownNow();
            encuestaAbierta = false;
            double promedioCalificaciones = calcularPromedioCalificaciones();
            System.out.println(" - - - - - RESULTADOS DE LA ENCUESTA!!!!! \n PROMEDIO CALIFICACIONES: "+promedioCalificaciones);
        }, DURACION_ENCUESTA, TimeUnit.MINUTES);
    }

    private double calcularPromedioCalificaciones(){
        int sumatoria=0;
        int tam = calificaciones.size();
        for(int i=0; i<tam;i++){
            sumatoria+= (int) calificaciones.get(i);
        }
        double promedio = sumatoria/tam;
        return promedio;
    }
}