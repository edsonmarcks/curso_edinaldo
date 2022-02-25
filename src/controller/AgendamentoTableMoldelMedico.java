/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.format.DateTimeFormatter;
import java.util.List;
import modelo.Agendamento;

/**
 *
 * @author edsonmarcks
 */
public class AgendamentoTableMoldelMedico extends ModeloTableGenerica<Agendamento> {

    public AgendamentoTableMoldelMedico(List<Agendamento> lista) {
        super(lista, new String[]{"Cod", "Data", "Hora", "Status", "Paciente"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        entidade = getEntity(rowIndex);
        switch (columnIndex) {
            case 0:
                return entidade.getId();
            case 1:
                return entidade.getDataLancamento().format(FORMATER_DATE);
            case 2:
                return entidade.getHora();
            case 3:
                return entidade.getStatus();
            case 4:
                return entidade.getPaciente().getNome();
            default:
                return null;
        }
    }

}
