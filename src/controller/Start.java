package controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Medico;
import modelo.Usuario;
import modelo.dao.MedicoDao;
import modelo.dao.UsuarioDao;
import modelo.utils.VerificadorCPF;

/**
 *
 * @author edsonmarcks
 */
public class Start {
    public static void main(String[] args) {
        if(VerificadorCPF.validandoCPF("658.700.260-91")){
            System.out.println("Valido");
        }else{
            System.out.println("Inválido");
        }
    }
}
