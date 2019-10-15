/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiz;

import javafx.embed.swing.JFXPanel;
import javax.swing.JApplet;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import guiz.interfacce.Home;


public class GUIz extends JApplet {
    
    private static final int JFXPANEL_WIDTH_INT = 300; //misure delle finestre
    private static final int JFXPANEL_HEIGHT_INT = 250;
    private static JFXPanel fxContainer;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {  //lancia la home dell'applicazione
            
            @Override
            public void run() {
                new Home().setVisible(true);
            }
        });
    }   
}
