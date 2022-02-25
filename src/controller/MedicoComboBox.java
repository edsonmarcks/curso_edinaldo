/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import modelo.Medico;

/**
 *
 * @author edsonmarcks
 */
public class MedicoComboBox extends GenericComboModel<Medico>{

    public MedicoComboBox(List<Medico> objects) {
        super(objects);
    }    
}
