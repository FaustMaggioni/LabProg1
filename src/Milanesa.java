public class Milanesa extends Comida {
    @Override
    protected Repartidor crearRepartidor(int distancia) {
        if(distancia < 50){
            return new Bici();
        }else{
            if(distancia >= 50 && distancia < 100){
                return new Moto();
            }else{
                return new Auto();
            }
        }
    }
    
    // hay que agregar las clases auto, moto bici
}
