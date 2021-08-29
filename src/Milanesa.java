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

    // codigo de dudosa calidad

    class Moto implements Repartidor{
        public Moto (){
        }
        public void repartir(){
            System.out.println("repartiendo en moto");
        }
    }
    class Auto implements Repartidor{
        public Auto (){
            
        }
                public void repartir(){
            System.out.println("repartiendo en auto");
        }
    }
    class Bici implements Repartidor{
        public Bici (){
            
        }
                public void repartir(){
            System.out.println("repartiendo en bici");
        }
    }