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
public class FabElCarrito implements FabricaComida {
    String marca = "El Carrito";
    @Override
    public Pizza crearPizza() {
        return new Pizza(marca);
    }

    @Override
    public Hamburguesa crearHamburguesa() {
        return new Hamburguesa(marca);
    }

    @Override
    public Milanesa crearMilanesa() {
        return new Milanesa(marca);
    }

    
}
