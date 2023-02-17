/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientserverOOP;

/**
 *
 * @author Giuseppe Genovese
 */
public class MainServer {
     /**
     * Metodo statico per l'avvio della classe.
     * @param args argomenti da linea di comando
     */
    public static void main(String[] args) {
        Server s = new Server(2000);
        if (s != null) {
                s.attendi();
                s.leggi();
                // s.chiudi();
            }
    }
}
