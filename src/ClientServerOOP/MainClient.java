/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientserverOOP;

/**
 *
 * @author Giuseppe Genovese
 */
public class MainClient {
    
    /**
     * Metodo statico per l'avvio della classe.
     * @param args argomenti da linea di comando
     */
    public static void main(String[] args) {
        Client c1 = new Client("MC", "\u001b[34;1m");
        c1.connetti("localhost", 2000);
        c1.scrivi();
        c1.chiudi();
    }
    
}

