package dictionaryserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.out;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Set;

public class DictionaryServer extends Thread
{
    private Hashtable DictionaryTable;
    ServerSocket soc;
    Socket conn;
    String path;
    int port;
    
    public void Initialize(DictionaryServer myServer, String[] args)
    {
        if(args.length<2)
        {
            System.out.println("Insufficient arguments.");
            System.exit(0);
        }
        else
        {
            this.port = Integer.parseInt(args[0]);
            this.path = args[1];
            
        }

        this.DictionaryTable = new Hashtable();
        DictionaryTable = getDictionaryState(path);
    }

    public String AddWordRequest(String word, String meaning)
    {
        String decision = "";
        if (!DictionaryTable.containsKey(word))
        {
            DictionaryTable.put(word, meaning);
            decision = "Word Successfully added";
            saveDictionaryState(DictionaryTable);
        }
        else
        {
            String KeyMeaning = (String)DictionaryTable.get(word);
            if(KeyMeaning.equals(meaning))
                decision = "The word already exists!!";
            else
            {
                DictionaryTable.put(word, KeyMeaning + "|" + meaning);
                decision = "Word Edited successfully!";
            }
        }
        saveDictionaryState(DictionaryTable);
        return decision;
    }

    public String DeleteWordRequest(String word)
    {
        String decision = "";
        if (DictionaryTable.containsKey(word))
        {
            DictionaryTable.remove(word);
            decision = "The word has been deleted successfully.";
            saveDictionaryState(DictionaryTable);
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

    public String PingRequest(String input)
    {
       return "Ping Check"; 
    }

    public void saveDictionaryState(Hashtable DictionaryTable)
    {
        try
        {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Set<String> keys = DictionaryTable.keySet();
            for (String key : keys)
            {
                bufferedWriter.write(key + "<>" + DictionaryTable.get(key));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }
        catch (IOException ex)
        {
            System.out.println("Error writing to file");
        }
    }

    public Hashtable getDictionaryState(String path)
    {
        //retrieves the dictionary
        Hashtable tempTable = new Hashtable();
        String line = null;
        String fileName = path;
        String key = "";
        String value = "";
        try
        {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null)
            {
                String[] initialStringSplit = line.split("<>");
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

    public void StartServer(DictionaryServer myServer)
    {
        try
        {
            soc = new ServerSocket(port);
            System.out.println("Server Running..");
            while (true)
            {
                conn = soc.accept();  //server accept the client connection request
                System.out.println("Client sends a query");
                myThread t = new myThread(conn,myServer); //send  the request to a separate thread
                t.start();
            }
        }
        catch (Exception e)
        {
            System.out.println("Cannot Connect");
        }
    }

    public static void main(String[] args)
    {
        DictionaryServer myServer = new DictionaryServer();
        myServer.Initialize(myServer, args);
        myServer.StartServer(myServer);
    }
}
