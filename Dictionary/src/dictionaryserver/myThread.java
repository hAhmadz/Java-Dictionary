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
    DictionaryServer DS;

    myThread(Socket inSocket, DictionaryServer DicS)
    {
        serverClient = inSocket;
        DS = DicS;
    }

    public void run()
    {
        String Message = "";
        String OutputMessage = "";
        try (Socket clientSocket = serverClient)
        {
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            Message = input.readUTF();
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
            String[] SplitMessages = Message.split("\\|");
            
            if(SplitMessages[0].equals("1"))
            {   //Add Word
                synchronized(DS){ OutputMessage = DS.AddWordRequest(SplitMessages[1],SplitMessages[2]);}
                output.writeUTF(OutputMessage); 
            }
            else if(SplitMessages[0].equals("2"))
            {   //Delete Word
                synchronized(DS){ OutputMessage = DS.DeleteWordRequest(SplitMessages[1]);}
                output.writeUTF(OutputMessage); 
            }
            else if(SplitMessages[0].equals("3"))
            {   //Search Word
                synchronized(DS){ OutputMessage = DS.SearchWordRequest(SplitMessages[1]);}
                output.writeUTF(OutputMessage); 
            }
            else if(SplitMessages[0].equals("4"))
            {   //Ping
                synchronized(DS){ OutputMessage = DS.PingRequest(SplitMessages[0]);}
                output.writeUTF(OutputMessage); 
            }
            else if(SplitMessages[0].equals("5"))
            {
                serverClient.close();
                System.out.println("exit");
            }
            
        }
        catch (IOException e)
        {
            System.out.println("Client Disconnected");
        }
    } 
}
