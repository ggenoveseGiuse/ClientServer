/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientserverOOP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giuseppe Genovese
 */
public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;
    
    public Server(int porta){
        this.porta = porta;
    }
    
    public Socket attendi(){
        
        try {
            serverSocket = new ServerSocket(2000);
            clientSocket = serverSocket.accept();  // va in esecuzione se il client chiede la connessione
            System.out.println("Connessione stabilita");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
           return clientSocket; 
    }
    
    public void scrivi(){
        // inserisci corpo 
    }
    
    public void leggi(){
        // inserisci corpo 
    }
    
    public void chiudi(){
        // inserisci corpo 
    }
    
    public void termina(){
        // inserisci corpo 
    }
}
