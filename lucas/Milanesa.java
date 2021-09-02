/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lucas;

/**
 *
 * @author tog
 */
public class Milanesa implements Comida {

    boolean limon = false, sal = false;
    String comiendo = "comiendo una pizza";
    String fabricante;

    public Milanesa(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public void comer() {
        if (limon && sal) {
            comiendo += "con limon y sal.";
        } else if (!limon && !sal) {
            comiendo += ".";
        } else if (limon) {
            comiendo += "con limon.";
        } else {
            comiendo += "con sal.";
        }
        System.out.println(comiendo + ", comprada en " + fabricante);
    }

    public void agregarLimon() {
        limon = true;
    }

    public void agregarSal() {
        sal = true;
    }

}
