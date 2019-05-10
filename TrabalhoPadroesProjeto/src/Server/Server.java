package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulohenrique
 */
public class Server {

    public void execute(){
        try {
            ServerSocket serverSocket = new ServerSocket(56000);
            serverSocket.setReuseAddress(true);
            while (true){
                System.out.println("Aguardando conexão...");
                Socket socket = serverSocket.accept();
                SocketThread thread = new SocketThread(socket);
                thread.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
}
