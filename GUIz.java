/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiz;
import javax.swing.JApplet;
import javax.swing.SwingUtilities;
import guiz.interfacce.Home;


public class GUIz extends JApplet {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Home().setVisible(true);
        } //lancia la home dell'applicazione
        );
    }   
}
