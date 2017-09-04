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
    public void start () 
    {
        System.out.println("Starting ");
    }
     
}
