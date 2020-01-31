package SOCKET;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ServerSocket server_socket = new ServerSocket(8070);
			ServerSocket server_socket_max = new ServerSocket(8070,5);
			Socket connexion = server_socket_max.accept();
			Socket socket = new Socket("localhost",2004);
			Socket socketClient = new Socket("localhost",2004);
			System.out.print("Connected to localhost in port 2004");
			ObjectOutputStream out = new ObjectOutputStream(socketClient.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socketClient.getInputStream());
			String msg = "Message Client";
			out.writeObject(msg);
			System.out.print("Client >" + msg);
			//msg = (String)in.readObject();
			System.out.print("Serveur >" + msg);
			
			
			
		    
		    
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
