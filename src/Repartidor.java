
abstract public class Repartidor implements Runnable {

    static int contador = 0;
    String nombre, pedido;
    int velocidad;

    public Repartidor(String pedido, String comida) {
        this.pedido = pedido + " (" + comida + ")";
        contador++;
        nombre = "R" + contador;
    }

    public void run() {
        try {
            arrancar();
            llevar();
            entregar();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void arrancar() throws Exception {
        System.out.println(nombre + " busca la direccion en Google Maps para llevar el " + pedido);
        Thread.sleep(2000);
    }

    protected void llevar() throws InterruptedException {
        System.out.println(nombre + " lleva " + pedido);
        Thread.sleep(10000 / velocidad);
    }

    protected void entregar() {
        System.out.println(nombre + " entrega " + pedido);
    }

}
