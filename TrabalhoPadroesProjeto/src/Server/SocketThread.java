package Server;


import Model.Jogador;
import Model.Mensagem;
import Model.MensagemTipo;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author paulohenrique
 */
public class SocketThread extends Thread{
    
    private Socket socket;


    public SocketThread(Socket socket) {
        this.socket = socket;

        if (socket != null)
            System.out.println("Jogador do IP " + socket.getInetAddress().toString() + " conectado.");
    }    

    @Override
    public void run(){
        try{
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());            
            
            Object obj =  input.readObject();            
            
            if (obj instanceof Mensagem){
                Mensagem msg = (Mensagem) obj;
                Mensagem outMsg = processaMensagem(msg);
                
                if (outMsg != null){
                    output.writeObject(outMsg);
                    output.flush();
                }
                    
            }           
                                    
            output.close();            
            input.close();        
            System.out.println("Jogador " + socket.getInetAddress().toString() + " encerrou.");
            socket.close();    
        }catch(IOException e){
            e.printStackTrace();            
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();            
        }         
    }  
    
    private Mensagem processaMensagem(Mensagem msg){                
        switch (msg.getType()){
            case verificaCor :
                return informaCorAoAmigo();
            default : System.out.println("Nenhuma mensagem recebida" + msg.toString());
        }
        
        return null;
    }
    
    private Mensagem informaCorAoAmigo(){
    Mensagem msg = new Mensagem(MensagemTipo.verificaCor, Jogador.getInstance().getCor());
    return msg;
    }
    
    
}
