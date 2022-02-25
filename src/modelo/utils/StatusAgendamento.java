/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.utils;

/**
 *
 * @author edsonmarcks
 */
public enum StatusAgendamento {
    ABERTO("Aberto"),
    CANCELADO("Cancelado"),
    CONFIRMADO("Confirmado"),
    FINALIZADO("Finalizado");
    
    private final String value;

    private StatusAgendamento(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
