package clientserverOOP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe Server che implementa un server TCP/IP.
 */
public class Server {
    ServerSocket connection;    // istanza della classe ServerSocket per la connessione
    Socket clientSocket;        // istanza della classe Socket per il client
    int porta;                  // numero di porta del server
    InputStream is;             // stream di input
    OutputStream os;            // stream di output
    
    /**
     * Costruttore della classe Server.
     * @param porta il numero di porta del server
     */
    public Server(int porta){
        this.porta = porta;
        try {
            connection = new ServerSocket(porta);
        } 
        catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo che rimane in attesa di connessioni da parte dei client.
     */
    public void attendi(){
        while(true){
            try {
                System.out.println("In attesa di Connessione.");
                clientSocket = connection.accept();    // attesa di una connessione da parte del client
                System.out.println("Connessione accettata da: "+
                clientSocket.getInetAddress());
            }
            catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Metodo che legge un messaggio inviato dal client.
     */
    public void leggi(){
        String messaggioRicevuto;
        try {    
            BufferedReader br = new BufferedReader(
            new InputStreamReader(clientSocket.getInputStream()));
            messaggioRicevuto = br.readLine();    // lettura del messaggio dallo stream di input
            System.out.println("CLIENT: " + messaggioRicevuto);
        } 
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    /**
     * Metodo che invia un messaggio al client.
     */
    public void scrivi(){
        try{
            os = connection.getOutputStream();    // ottenimento dello stream di output
            String messaggio = "Ciao, sono il server!";    // messaggio da inviare al client
            os.write(messaggio.getBytes());    // scrittura del messaggio sullo stream di output
            os.flush();    // invio del messaggio al client
        }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nella scrittura e/o nell'invio dei dati al server!");
        }
   } 
}   // fine classe
