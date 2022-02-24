/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import modelo.Usuario;

/**
 *
 * @author edsonmarcks
 */
public class UsuarioTableModel extends ModeloTableGenerica<Usuario> {

    public UsuarioTableModel(List<Usuario> lista) {
        super(lista, new String[]{"Cod.", "Nome", "Permissão"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        entidade = getEntity(rowIndex);
        switch (columnIndex) {
            case 0:
                return entidade.getId();
            case 1:
                return entidade.getNome();
            case 2:
                return entidade.getPermissaoUsuario();
            default:
                return null;
        }
    }

}
