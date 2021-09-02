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
public class Hamburguesa implements Comida {

    String condimento = "";
    String fabricante;

    public Hamburguesa(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public void comer() {
        System.out.println("comiendo una hamburguesa" + condimento + ", comprada en " + fabricante);
    }

    public void condimentar(String condimento) {
        condimento = " con " + condimento + ".";
    }

}
