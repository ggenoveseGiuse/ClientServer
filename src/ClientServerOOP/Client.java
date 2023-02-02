/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientserverOOP;

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
    String nome;
    String colore;
    Socket connection;
    
    public Client(String nomeDefault, String coloreDefault){
        nome = nomeDefault;
        colore = coloreDefault;
    }
    
    public void connetti(String nomeServer, int portaServer){
        try {
            connection = new Socket(nomeServer, portaServer);
        } 
        catch (UnknownHostException ex) {
                System.err.println("ERRORE - DNS");
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore scheda di rete");
            ex.printStackTrace();
        }
        System.out.println("fuori catch");
    }
    
    public void scrivi(String nomeServer, int portaServer){
        try {
            connection = new Socket(nomeServer, portaServer);
            DataOutputStream dos = (DataOutputStream) connection.getOutputStream();
            dos.writeUTF(this + "dice:");
            dos.writeUTF("ciao");
            
            dos.flush();    // svuoto il buffer e invio il messaggio al server
        } 
            catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    
    public void chiudi(){
        try {
            connection.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

