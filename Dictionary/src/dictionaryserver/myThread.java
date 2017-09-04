package dictionaryserver;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class myThread extends Thread
{

    Socket serverClient;
    int clientNo;
    int squre;
    DictionaryServer DS;
    
    myThread(Socket inSocket, int counter,DictionaryServer DicS)
    {
        serverClient = inSocket;
        clientNo = counter;
        DS = DicS;
    }

    public void run()
    {
        try
        {
            DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
            DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
            String clientMessage = "";
            String serverMessage = "";
            
            while(true)
            {
                clientMessage = inStream.readUTF();
                if(clientMessage.equals("pinging"))
                {
                    outStream.writeUTF("pinging");
                    outStream.flush();
                }
//                System.out.println("From Client-" + clientNo + ": Number is :" + clientMessage);
//                squre = Integer.parseInt(clientMessage) * Integer.parseInt(clientMessage);
//                serverMessage = "From Server to Client-" + clientNo + " Square of " + clientMessage + " is " + squre;
//                outStream.writeUTF(serverMessage);
                outStream.flush();
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        finally
        {
            System.out.println("Client -" + clientNo + " exit!! ");
        }
    }
    /*
    private Thread t;
    private String tName;
    String line = null;
    BufferedReader is = null;
    PrintWriter os = null;
    Socket s = null;
    
    myThread(String name, Socket s) 
    {
        this.tName = name;
    }
    
    //override method
    public void run()
    {
        //implementation of run method
        System.out.println(this.tName + " is running");
        try
        {
            is = new BufferedReader(new InputStreamReader(s.getInputStream()));
            os = new PrintWriter(s.getOutputStream());

        }
        catch (IOException e)
        {
            System.out.println("IO error in server thread");
        }

        try
        {
            line = is.readLine();
            while (line.compareTo("QUIT") != 0)
            {

                os.println(line);
                os.flush();
                System.out.println("Response to Client  :  " + line);
                line = is.readLine();
            }
        }
        catch (IOException e)
        {

            line = this.getName(); //reused String line for getting thread name
            System.out.println("IO Error/ Client " + line + " terminated abruptly");
        }
        catch (NullPointerException e)
        {
            line = this.getName(); //reused String line for getting thread name
            System.out.println("Client " + line + " Closed");
        }
        finally
        {
            try
            {
                System.out.println("Connection Closing..");
                if (is != null)
                {
                    is.close();
                    System.out.println(" Socket Input Stream Closed");
                }

                if (os != null)
                {
                    os.close();
                    System.out.println("Socket Out Closed");
                }
                if (s != null)
                {
                    s.close();
                    System.out.println("Socket Closed");
                }

            }
            catch (IOException ie)
            {
                System.out.println("Socket Close Error");
            }
        }
    
    }
    */
    public void start () 
    {
        System.out.println("Starting ");
    }
     
}
