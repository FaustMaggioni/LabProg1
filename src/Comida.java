abstract public class Comida {
    public void llamarDelivery(int distancia){
        Repartidor rp = crearRepartidor(distancia);
        //ver si ejecutar el runnable o meterlo en el ScheduleExecutor
    }

    protected abstract Repartidor crearRepartidor(int distancia);
}
