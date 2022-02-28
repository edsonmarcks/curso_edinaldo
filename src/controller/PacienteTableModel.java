/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import modelo.Paciente;

/**
 *
 * @author edsonmarcks
 */
public class PacienteTableModel extends ModeloTableGenerica<Paciente>{

    public PacienteTableModel(List<Paciente> pacientes) {
        super(pacientes, new String[]{"Nome","Nasc","CPF","Telefone"});
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        entidade= getEntity(rowIndex);
        switch(columnIndex){
            case 0: return entidade.getNome();
            case 1: return entidade.getNascimento().format(FORMATER_DATE);
            case 2: return entidade.getCPF();
            case 3: return entidade.getTelefone();
            default: return null;
        }
    }
    
}
