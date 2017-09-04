package dictionaryserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Set;
import javax.net.ServerSocketFactory;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

//Server checklists
/*
1. Implement Save State in file - Done
2. Implement Retrieval State through file - Done
3. Implement Server side sockets - 
4. Implement Server Threading - 


Requests Codes from clients:
Add:    1
Delete: 2
Search: 3
Ping:   4
 */
public class DictionaryServer extends Thread
{

    //Variables
    private Hashtable DictionaryTable;
    private static int counter = 0;
    ServerSocket soc;
    Socket conn;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;

    @Option(required = true, name = "-h", aliases =
    {
        "--host"
    }, usage = "Hostname")
    String host;

    @Option(required = false, name = "-p", usage = "Port number")
    int port;

    public void Initialize(DictionaryServer myServer, String[] args)
    {
        CmdLineParser parser = new CmdLineParser(myServer);
        try
        {
            parser.parseArgument(args);
        }
        catch (CmdLineException e)
        {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
            System.exit(0);
        }

        this.DictionaryTable = new Hashtable();
        DictionaryTable = getDictionaryState();
    }

    public void StopServer() throws IOException
    {
        soc.close();
        conn.close();
    }
    
    public synchronized String AddWordRequest(String word, String meaning)
    {
        String decision = "";
        if (!DictionaryTable.containsKey(word))
        {
            DictionaryTable.put(word, meaning);
            decision = "Word Successfully added";
        }
        else
            decision = "The word already exists!!";
        return decision;
    }

    public synchronized String DeleteWordRequest(String word)
    {
        String decision = "";
        if (DictionaryTable.containsKey(word))
        {
            DictionaryTable.remove(word);
            decision = "The word has been deleted successfully.";
        }
        else
            decision = "The word does not exist in the dictionary!";
        
        return decision;
    }

    public String SearchWordRequest(String word)
    {
        String decision = "";
        if (DictionaryTable.containsKey(word))
            decision = (String)DictionaryTable.get(word);
        else
            decision = "The word does not exist in the dictionary";
        return decision;
    }

    public void PingRequest(String input)
    {
        // Server receives a message from the client and sends back the same message to the client in this function.
        
        
    }

    public synchronized void saveDictionaryState(Hashtable DictionaryTable)
    {
        String fileName = "Dictionary.txt";
        try
        {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Set<String> keys = DictionaryTable.keySet();
            for (String key : keys)
            {
                bufferedWriter.write(key + ":" + DictionaryTable.get(key));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }
        catch (IOException ex)
        {
            System.out.println("Error writing to file '" + fileName + "'");
        }
    }

    public Hashtable getDictionaryState()
    {
        //retrieves the dictionary
        Hashtable tempTable = new Hashtable();
        String line = null;
        String fileName = "Dictionary.txt";
        String key = "";
        String value = "";
        try
        {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null)
            {
                String[] initialStringSplit = line.split(":");
                key = initialStringSplit[0];
                value = initialStringSplit[1];

                if (!tempTable.contains(key))
                {
                    tempTable.put(key, value);
                }
            }
            bufferedReader.close();
        }
        catch (FileNotFoundException ex)
        {
            //Nothing in this, default case is new file creation
        }
        catch (IOException ex)
        {
            System.out.println("Error reading file '" + fileName + "'");
        }
        return tempTable;
    }

    void sendMessage(String msg)
    {
        try
        {
            out.writeObject(msg);
            out.flush();
            System.out.println("server>" + msg);
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
    }

    public void StartServer(DictionaryServer myServer)
    {
        try
        {
            soc = new ServerSocket(port);
            int counter = 0;
            System.out.println("Server Started ....");
            while (true)
            {
                counter++;
                conn = soc.accept();  //server accept the client connection request
                System.out.println("Client No:" + counter + " started!");
                myThread sct = new myThread(conn, counter, myServer); //send  the request to a separate thread
                sct.start();
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args)
    {
        DictionaryServer myServer = new DictionaryServer();
        myServer.Initialize(myServer, args);
        while(true)
            myServer.StartServer(myServer);
    }
}
