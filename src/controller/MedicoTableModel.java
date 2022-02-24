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
public class MedicoTableModel extends ModeloTableGenerica<Medico> {

    public MedicoTableModel(List<Medico> lista) {
        super(lista, new String[]{"CRM", "Nome", "Telefone", "Especialização"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        entidade = getEntity(rowIndex);
        switch (columnIndex) {
            case 0:
                return entidade.getCRM();
            case 1:
                return entidade.getNome();
            case 2:
                return entidade.getTelefone();
            case 3:
                return entidade.getEspecializacao();
            default:
                return null;
        }
    }

}
