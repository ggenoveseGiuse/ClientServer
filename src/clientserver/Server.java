/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientserver;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giuseppe Genovese
 */
public class Server {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
// TEORIA: metodo bloccante: metodo che blocca il programma e non permette l'esecuzione delle altre istruzioni
//          ES. join() -> il thread non terminava la sua esecuzione fino a quando il thread su cui viene invocato
//                        il metodo join() non termina la sua esecuzione
        

// UNICAST: io parlo con te
// MULTICAST: comunicazione fatta solo in UDP con alcuni indirizzi particolari della classe D
        try {
            System.out.println("ACCESO");
            System.out.println("Connessione...");
            ServerSocket serverSocket = new ServerSocket(2000);
           
            // METODO BLOCCANTE 
            // Restituisce un'oggetto Socket di tipo DataSocket
            Socket socket = serverSocket.accept();  // va in esecuzione se il client chiede la connessione
            System.out.println("Connessione stabilita");
            
    
            socket.close();
            System.out.println("Connessione chiusa.");
      
        } 
            catch (BindException ex) {
                System.err.println("Errore - porta già in ascolto");
            }
        
            catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Errore nella fase di apertura del canale di ascolto");
            }
    }
    
}
