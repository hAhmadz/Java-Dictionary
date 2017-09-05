package dictionaryclient;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.rmi.UnknownHostException;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class DictionaryClient extends javax.swing.JFrame
{

    Socket sc;
    DataInputStream inStream;
    DataOutputStream outStream;
    BufferedReader br;
    String message;
    @Option(required = true, name = "-h", aliases =
    {
        "--host"
    }, usage = "Hostname")
    String host;

    @Option(required = false, name = "-p", usage = "Port number")
    int port;

    public DictionaryClient()
    {
        initComponents();
    }

    public String getHost()
    {
        return host;
    }

    public int getPort()
    {
        return port;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jDialog1 = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        ClearBtn = new javax.swing.JButton();
        SearchBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        SearchwordField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        MeaningTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        AddWordBtn = new javax.swing.JButton();
        deleteWordBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        MeaningTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        portTextBox = new javax.swing.JTextField();
        machineTextBox = new javax.swing.JTextField();
        pingBtn = new javax.swing.JButton();
        OutputLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        OutputLabel2 = new javax.swing.JTextPane();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(218, 213, 213));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Word Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(102, 0, 51))); // NOI18N

        ClearBtn.setBackground(new java.awt.Color(207, 207, 207));
        ClearBtn.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        ClearBtn.setForeground(new java.awt.Color(102, 102, 102));
        ClearBtn.setText("Clear");
        ClearBtn.setToolTipText("Clear all");
        ClearBtn.setBorderPainted(false);
        ClearBtn.setFocusPainted(false);
        ClearBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ClearBtnActionPerformed(evt);
            }
        });

        SearchBtn.setBackground(new java.awt.Color(207, 207, 207));
        SearchBtn.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        SearchBtn.setForeground(new java.awt.Color(102, 102, 102));
        SearchBtn.setText("Search");
        SearchBtn.setToolTipText("Search for a meaning");
        SearchBtn.setBorderPainted(false);
        SearchBtn.setFocusPainted(false);
        SearchBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                SearchBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Meaning");

        SearchwordField.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        SearchwordField.setToolTipText("Enter the word to search its meaning");
        SearchwordField.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                SearchwordFieldMouseClicked(evt);
            }
        });

        MeaningTextArea.setColumns(20);
        MeaningTextArea.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        MeaningTextArea.setRows(5);
        MeaningTextArea.setToolTipText("Add Input Box");
        MeaningTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(MeaningTextArea);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Word");

        AddWordBtn.setBackground(new java.awt.Color(207, 207, 207));
        AddWordBtn.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        AddWordBtn.setForeground(new java.awt.Color(102, 102, 102));
        AddWordBtn.setText("Add");
        AddWordBtn.setToolTipText("Add a word");
        AddWordBtn.setBorderPainted(false);
        AddWordBtn.setFocusPainted(false);
        AddWordBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                AddWordBtnActionPerformed(evt);
            }
        });

        deleteWordBtn.setBackground(new java.awt.Color(207, 207, 207));
        deleteWordBtn.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        deleteWordBtn.setForeground(new java.awt.Color(102, 102, 102));
        deleteWordBtn.setText("Delete");
        deleteWordBtn.setToolTipText("Delete a word");
        deleteWordBtn.setBorderPainted(false);
        deleteWordBtn.setFocusPainted(false);
        deleteWordBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteWordBtnActionPerformed(evt);
            }
        });

        MeaningTextArea1.setEditable(false);
        MeaningTextArea1.setBackground(new java.awt.Color(244, 244, 244));
        MeaningTextArea1.setColumns(20);
        MeaningTextArea1.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        MeaningTextArea1.setRows(5);
        MeaningTextArea1.setToolTipText("Meaning Textbox");
        jScrollPane3.setViewportView(MeaningTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SearchwordField)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteWordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddWordBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SearchwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(AddWordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(deleteWordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Castellar", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Socket Dictionary");

        jPanel3.setBackground(new java.awt.Color(229, 227, 227));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)), "Connection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setText("Machine");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setText("Port");

        portTextBox.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        portTextBox.setToolTipText("Port Number");

        machineTextBox.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        machineTextBox.setToolTipText("Machine IP");

        pingBtn.setBackground(new java.awt.Color(204, 204, 204));
        pingBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        pingBtn.setForeground(new java.awt.Color(102, 102, 102));
        pingBtn.setText("Ping");
        pingBtn.setToolTipText("Press to Ping the server");
        pingBtn.setBorderPainted(false);
        pingBtn.setFocusPainted(false);
        pingBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                pingBtnActionPerformed(evt);
            }
        });

        OutputLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        OutputLabel2.setBackground(new java.awt.Color(204, 204, 204));
        OutputLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OutputLabel2.setToolTipText("Output");
        jScrollPane2.setViewportView(OutputLabel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(67, 67, 67)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(portTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(316, 316, 316)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(machineTextBox, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                                .addGap(92, 92, 92))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 315, Short.MAX_VALUE)
                                .addComponent(OutputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)))
                        .addComponent(pingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(OutputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(machineTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(0, 37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void InitializeArguments(DictionaryClient myClient, String[] args)
    {
        CmdLineParser parser = new CmdLineParser(myClient);
        try
        {
            parser.parseArgument(args);
            portTextBox.setText(Integer.toString(getPort()));
            machineTextBox.setText(getHost());
        }
        catch (CmdLineException e)
        {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
            System.exit(0); //exits if no proper arguments
        }
    }

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        //word to be searched
        String searchWord = SearchwordField.getText();
        String OutputMessage = "3" + "|" + searchWord;
        if (!searchWord.isEmpty())
        {
            try (Socket socket = new Socket(host, port);)
            {
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                output.writeUTF(OutputMessage);
                output.flush();
                String message = input.readUTF();
                SearchwordField.setText(searchWord);
                
                if(message.equals("The word does not exist in the dictionary"))
                    OutputLabel2.setText(message);
                else
                {
                    String[] MessageSplit = message.split("\\|");
                    String Out = "";
                    for(int i = 0; i < MessageSplit.length; i++)
                    {
                        Out = Out + "Meaning:" + (i+1) + "   " + MessageSplit[i] + "\n";
                    }
                    MeaningTextArea1.setText(Out);
                }
                    
            }
            catch (UnknownHostException e)
            {
                OutputLabel2.setText("No Connection");
            }
            catch (IOException e)
            {
                OutputLabel2.setText("Connection Issues");
            }
        }
        else
        {
            OutputLabel2.setText("No word Entered!");
        }
        
    }//GEN-LAST:event_SearchBtnActionPerformed

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        //all clear button
        SearchwordField.setText(null);
        MeaningTextArea.setText(null);
        MeaningTextArea1.setText(null);
        OutputLabel2.setText(null);
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void deleteWordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteWordBtnActionPerformed
        //word to be deleted: 
        String word = SearchwordField.getText();
        String OutputMessage = "2" + "|" + word;
        if (!word.isEmpty())
        {
            try (Socket socket = new Socket(host, port);)
            {
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                output.writeUTF(OutputMessage);
                output.flush();
                OutputLabel2.setText(input.readUTF());
                SearchwordField.setText(null);
                MeaningTextArea.setText(null);
            }
            catch (UnknownHostException e)
            {
                OutputLabel2.setText("No Connection");
            }
            catch (IOException e)
            {
                OutputLabel2.setText("Connection Issues");
            }
        }
        else
            OutputLabel2.setText("No Word Entered!");

    }//GEN-LAST:event_deleteWordBtnActionPerformed

    private void AddWordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddWordBtnActionPerformed
        String word = SearchwordField.getText();
        String meaning = MeaningTextArea.getText();
        String OutputMessage = "1" + "|" + word + "|" + meaning;
        if (!meaning.isEmpty() && !(word.isEmpty()))
        {
            try (Socket socket = new Socket(host, port);)
            {
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                output.writeUTF(OutputMessage);
                output.flush();
                OutputLabel2.setText(input.readUTF());
                SearchwordField.setText(null);
                MeaningTextArea.setText(null);
            }
            catch (UnknownHostException e)
            {
                OutputLabel2.setText("No Connection");
            }
            catch (IOException e)
            {
                OutputLabel2.setText("Connection Issues");
            }
        }
        else
        {
            OutputLabel2.setText("No Word / Meaning Entered!");
        }
    }//GEN-LAST:event_AddWordBtnActionPerformed

    private void pingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pingBtnActionPerformed

        int portNumber = Integer.parseInt(portTextBox.getText());
        String hostName = machineTextBox.getText();
        String clientMessage = "Ping Check";
        try (Socket socket = new Socket(hostName, portNumber);)
        {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF("4|" + clientMessage);
            output.flush();
            String message = input.readUTF();
            
            if (message.equals(clientMessage))
            {
                OutputLabel2.setText("Ping Successful");
            }
        }
        catch (UnknownHostException e)
        {
            OutputLabel2.setText("No Connection");
            
        }
        catch (IOException e)
        {
            OutputLabel2.setText("Connection Issues");
        }
        //ping a message to the server and return a message from the server.
    }//GEN-LAST:event_pingBtnActionPerformed

    private void SearchwordFieldMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_SearchwordFieldMouseClicked
    {//GEN-HEADEREND:event_SearchwordFieldMouseClicked
            MeaningTextArea1.setText(null);
    }//GEN-LAST:event_SearchwordFieldMouseClicked

    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    DictionaryClient myClient = new DictionaryClient();
                    myClient.setVisible(true);
                    myClient.InitializeArguments(myClient, args);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddWordBtn;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JTextArea MeaningTextArea;
    private javax.swing.JTextArea MeaningTextArea1;
    private javax.swing.JLabel OutputLabel;
    private javax.swing.JTextPane OutputLabel2;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JTextField SearchwordField;
    private javax.swing.JButton deleteWordBtn;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField machineTextBox;
    private javax.swing.JButton pingBtn;
    private javax.swing.JTextField portTextBox;
    // End of variables declaration//GEN-END:variables
}
