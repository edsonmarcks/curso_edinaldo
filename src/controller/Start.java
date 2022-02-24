package controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Medico;
import modelo.Usuario;
import modelo.dao.MedicoDao;
import modelo.dao.UsuarioDao;

/**
 *
 * @author edsonmarcks
 */
public class Start {
    public static void main(String[] args) {
        Medico medico= new Medico();
        try {
            UsuarioDao dao = new UsuarioDao();
            for(Usuario u : dao.buscarTodos()){
                System.out.println("Nome: "+u.getNome());
                System.out.println("Permissão: "+u.getPermissaoUsuario());
            }
            
        } catch (RuntimeException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
