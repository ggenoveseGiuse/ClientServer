/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientserver;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giuseppe Genovese
 */
public class Client {
    // attributi della classe CLient - DEFINIZIONE DEL CLIENT SOCKET
    static String IPAddress = "127.0.0.1";
    static int numeroPorta = 2000;
    
    
    // costruttore della classe Client, vorrà dire che quando andremo ad istanziare 
    // un'oggetto di tipo client dovremmo andare a definire indirizzo IP e numero di porta
    public Client(String IPAddress, int numeroPorta){
        Client.IPAddress = IPAddress;
        Client.numeroPorta = numeroPorta;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            System.out.println("1. Inoltro richiesta al server...");
            Socket socket = new Socket(IPAddress, numeroPorta);
            System.out.println("2. Richiesta accettata e connessione...");
            
            // scrivo un messaggio al server

        // UTILIZZO DI DATA OUTPUT STREAM
        // è una classe astratta -> ha metodi astratti e non è istanziabile -> la istanziamo dal socket 
        // effettuare un casting esplicito
            DataOutputStream dos = (DataOutputStream) socket.getOutputStream();
            dos.writeUTF(IPAddress + "dice:");
            dos.writeUTF("ciao");
            
            dos.flush();    // svuoto il buffer e invio il messaggio al server
            
// ---------------------------------------------------------------------
            socket.close(); // chiudo il socket e chiudo anche lo stream
            
            
        }   
            catch (UnknownHostException ex) {
                System.err.println("ERRORE - DNS");
            }
        
            catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }
    
}


