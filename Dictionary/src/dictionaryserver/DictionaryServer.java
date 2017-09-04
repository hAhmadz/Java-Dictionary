package dictionaryserver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

public class DictionaryServer 
{
    //Variables
    private Hashtable DictionaryTable;
    private static int counter = 0;
    
    @Option(required = true, name = "-h", aliases = {"--host"}, usage = "Hostname")
    String host;

    @Option(required = false, name = "-p", usage = "Port number")
    int port;

    public void Initialize(DictionaryServer myServer,String[] args)
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
    public synchronized String AddWordRequest(String word, String meaning)
    {
        String decision = "";
        if(true)
        { 
            //word already exists

        }
        else
        {
            //send add word request.
        }
        return decision;
    }
    
    public synchronized String DeleteWordRequest(String word)
    {
        String decision = "";
        if(true)
        { 
            //word exists, delete it

        }
        else
        {
            //word does not exist.
        }
        return decision;
    }
    public String SearchWordRequest(String word)
    {
        String output = "";
        //Searches a word in the hashtable and sends it back.
        if(true)//word exists
        {
            //send search word request along with meaning
        }
        else
        {
            //open a dialog box that the word does not exist
        }
        return output;
    }
    public void PingRequest(String input)
    {
        // Server receives a message and sends back a default reply.
        
    }
    
    
    public synchronized void saveDictionaryState(Hashtable DictionaryTable)
    {
        //saves the dictionary 
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
        catch(IOException ex) 
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

            while((line = bufferedReader.readLine()) != null) 
            {
                String[] initialStringSplit = line.split(":");
                key = initialStringSplit[0];
                value = initialStringSplit[1];
                
                if(!tempTable.contains(key))
                    tempTable.put(key, value);
            }
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) 
        {
            //Nothing in this, default case is new file creation
        }
        catch(IOException ex) 
        {
            System.out.println( "Error reading file '" + fileName + "'");                  
        }
        return tempTable;
    }
    
    public void InitializeThread(Socket client)
    {
        myThread t = new myThread("Thread - " + counter);
        t.start(client);
    }
    
    public void StartServer(int value)
    {
        if(value == 1)// TCP Start
        {
            try(ServerSocket serversoc = new ServerSocket(port))
            {
                System.out.println("Waiting for client connection..");
                while(true)
                {
                    Socket client = serversoc.accept();
                    counter++;
                    System.out.println("Client " + counter + ": Applying for connection!");
                    
                    InitializeThread(client);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            
//            ServerSocket soc = new ServerSocket(port);
//            Socket s1 = soc.accept(); //waiting for and accepting a connection.
//
//            OutputStream s1out = s1.getOutputStream();
//            DataOutputStream dos = new DataOutputStream(s1out);
//
//            dos.writeUTF("Hello");
//
//            dos.close();
//            s1out.close();
//            s1.close();
            
            
            
//            private static void serveClient(Socket client)
//            {
//                try(Socket clientSocket = client)
//                {
//                    DataInputStream input = new DataInputStream(clientSocket.getInputStream());
//                    DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
//                    System.out.println("CLIENT: "+input.readUTF());
//                    output.writeUTF("Server: Hi Client "+counter+" !!!");
//                }        
//                catch (IOException e)
//                {
//                    e.printStackTrace();
//                }
//            }
        
            //main func
//                ServerSocketFactory factory = ServerSocketFactory.getDefault();
//                try(ServerSocket server = factory.createServerSocket(port))
//                {
//                    System.out.println("Waiting for client connection..");
//                    while(true)
//                    {
//                        Socket client = server.accept();
//                        counter++;
//                        System.out.println("Client "+counter+": Applying for connection!");
//                        Thread t = new Thread(() -> serveClient(client));
//                        t.start();
//                    }
//                } 
//                catch (IOException e)
//                {
//                    e.printStackTrace();
//                }
        }
        else if(value == 2)//UDP Start
        {
            
        }
    }
    
    
    public static void main(String[] args) 
    {
        DictionaryServer myServer = new DictionaryServer();
        myServer.Initialize(myServer,args);
        
        
        
        //1 for TCP Server connection
        //2 for UDP Server connection
        myServer.StartServer(1);
    }
}
