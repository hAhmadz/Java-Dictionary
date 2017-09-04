package dictionaryserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class myThread extends Thread
{
    private Thread t;
    private String tName;
    
    myThread(String name) 
    {
        this.tName = name;
    }
    
    //override method
    public void run()
    {
        //implementation of run method
        System.out.println(this.tName + " is running");
    }
    
    public void start (Socket client) 
    {
        System.out.println("Starting " +  this.tName );
        if (t == null) 
        {
            t = new Thread (this, this.tName);
            t.start ();
        }
        
        try(Socket cl = client)
        {
            OutputStream s1out = cl.getOutputStream();
            DataOutputStream out = new DataOutputStream(s1out);
            out.writeUTF("Congrats: you are connected successfully");
            out.writeUTF("Server: Hi Client !!!");
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
