/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientserverOOP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    int connessioni=0;
    int timeout=60000;
    
    public Server(int porta){
        this.porta = porta;
    }
    
    public Socket attendi(){
        
        while(connessioni<10){
        try {
            serverSocket = new ServerSocket(2000);
            clientSocket = serverSocket.accept();  // va in esecuzione se il client chiede la connessione
            System.out.println("Connessione stabilita");
            serverSocket.setSoTimeout(timeout);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
           connessioni++;
     }
     return clientSocket; 
    }
    
    public void scrivi(){
        // inserisci corpo
    }
    
    public void leggi(){
        String messaggioRicevuto;
        InputStreamReader is;
        
        try {
           
            
        BufferedReader br = new BufferedReader(
      is = new InputStreamReader(clientSocket.getInputStream()));
            messaggioRicevuto = br.readLine();
        System.out.println("3-il client ha scritto: " + messaggioRicevuto);
         } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void chiudi(){
        
       
        try {
           clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    
    
    public void termina(){
        // inserisci corpo 
    }
}

