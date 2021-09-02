abstract public class Comida {
    protected double peso;
    public void llamarDelivery(int cantidad){
        Repartidor rp = crearRepartidor(cantidad);
        //ver si ejecutar el runnable o meterlo en el ScheduleExecutor
    }

    protected Repartidor crearRepartidor(int cantidad){
        double pesoTotal = getPesoTotal(cantidad);
        if(pesoTotal < 100){
            return new Bicicleta();
        }
        if(pesoTotal >= 100 && pesoTotal < 200){
            return new Moto();
        }
        if(pesoTotal >= 200){
            return new Auto();
        }
    }

    protected double getPesoTotal(int cantidad){
        return this.peso*cantidad;
    }
}
