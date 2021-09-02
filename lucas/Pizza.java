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
public class Pizza implements Comida {

    String fabricante;

    public Pizza(String fabricante) {
        this.fabricante = fabricante;
    }
    String aceituna = "";

    @Override
    public void comer() {
        System.out.println("comiendo una pizza de " + aceituna + ", comprada en " + fabricante);
    }

    public void quitarAceituna() {
        aceituna = ", sin aceituna";
    }

}
