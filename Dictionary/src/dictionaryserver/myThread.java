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

    myThread(Socket inSocket, int counter, DictionaryServer DicS)
    {
        serverClient = inSocket;
        clientNo = counter;
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
            String[] SplitMessages = Message.split("\\|");
            
            if(SplitMessages[0].equals("1"))
            {   //Add Word
                synchronized(DS){ OutputMessage = DS.AddWordRequest(SplitMessages[1],SplitMessages[2]);}
            }
            else if(SplitMessages[0].equals("2"))
            {   //Delete Word
                synchronized(DS){ OutputMessage = DS.DeleteWordRequest(SplitMessages[1]);}
            }
            else if(SplitMessages[0].equals("3"))
            {   //Search Word
                synchronized(DS){ OutputMessage = DS.SearchWordRequest(SplitMessages[1]);}
            }
            else if(SplitMessages[0].equals("4"))
            {   //Ping
                synchronized(DS){ OutputMessage = DS.PingRequest(SplitMessages[0]);}
            }
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
            output.writeUTF(OutputMessage); 
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    } 
}
