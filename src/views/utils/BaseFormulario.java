/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.utils;

import java.awt.Dimension;
import javax.swing.JInternalFrame;

/**
 *
 * @author edsonmarcks
 */
public class BaseFormulario extends JInternalFrame{

    public BaseFormulario() {
        setClosable(true);
        setIconifiable(true);
    }
    
    
    public void centralizar(){
        Dimension d = getDesktopPane().getSize();
        setLocation((d.width - getWidth())/2, (d.height - getHeight())/2);
    }
}
