import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class P1 {

    private static int NUM_PORT = 8069;

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        try {

            Socket client = new Socket("localhost", NUM_PORT + 1);
            System.out.println("Connected to localhost in port " + (NUM_PORT + 1));
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            Scanner e = new Scanner(System.in);
            ServerSocket serverSocket = new ServerSocket(NUM_PORT);
            System.out.println("Waiting for connection P2");
            Socket waiting = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(waiting.getInputStream());
            //4
            while ( true ) {

                System.out.println("Choose : ");
                System.out.println("1 - Insertion");
                System.out.println("2 -  delete");
                System.out.println("3 -  show list");
                int choix = e.nextInt();
                out.writeObject(choix);
                switch (choix){
                    case 1:{
                    System.out.print("Insert Mat :");
                    int mat = e.nextInt();
                    e.nextLine();
                    System.out.print("Insert LastName :");
                    String lastName = e.nextLine();
                    System.out.print("Insert FirstName :");
                    String fristName = e.nextLine();
                    out.writeObject(mat);
                    out.writeObject(lastName);
                    out.writeObject(fristName);
                    break;
                    }
                    case 2:{
                        System.out.print("Insert Mat :");
                        int mat = e.nextInt();
                        out.writeObject(mat);
                        break;
                    }
                    case 3:{
                        break;
                    }
                }

                System.out.println("JDBC ORACLE : ");

                System.out.println((String) in.readObject());

                System.out.println("*************************************************************");
                System.out.println("JDBC MS ACCESS : ");

                System.out.println((String) in.readObject());

                System.out.println("*************************************************************");
            }
            //5
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
