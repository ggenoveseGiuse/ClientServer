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
    
    public static void main(String[] args) {
        Client c1 = new Client("nome", "colore");
        c1.connetti("localhost", 2000);
        c1.scrivi("localhost", 2000);
        
        
        if(c1.connection!=null){
            c1.chiudi();
        }
        
    }
}

