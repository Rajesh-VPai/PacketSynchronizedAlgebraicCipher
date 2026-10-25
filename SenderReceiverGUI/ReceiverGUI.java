/*
CC0 1.0 Universal (CC0 1.0) Public Domain Dedication

To the extent possible under law, the author(s) have dedicated all copyright
and related rights to this software to the public domain worldwide. This
software is distributed without any warranty.

You may copy, modify, distribute, and perform the work, even for commercial
purposes, all without asking permission.

For more information, see <https://creativecommons.org/publicdomain/zero/1.0/>
 */
 /*
This is free and unencumbered software released into the public domain.

Anyone is free to copy, modify, publish, use, compile, sell, or distribute
this software, either in source code form or as a compiled binary, for any
purpose, commercial or non-commercial, and by any means.

In jurisdictions that recognize copyright laws, the author(s) dedicate any
and all copyright interest in the software to the public domain. We make
this dedication for the benefit of the public at large and to the detriment
of our heirs and successors. We intend this dedication to be an overt act
of relinquishment in perpetuity of all present and future rights to this
software under copyright law.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For more information, please refer to <https://unlicense.org/>
 */
/**
 *
 * @author Rajesh V Pai
 */
package SenderReceiverGUI;

import Calculus.ConsoleColors;
import static Security.Configuration.CyclicFlag;
import static Security.Configuration.NumberOfTimes;
import static Security.Configuration.SecurityPosture;
import static Security.Configuration.UDPBuffLen;
import static Security.Configuration.USEUDP;
import static Security.Configuration.USE_AES;
import static Security.Decryption.DecryptedMesg;
import static Security.Decryption.PlainText;
import static Security.Decryption.TestDebug;
import Security.PacketSynchronizedAlgebraicCipher;
import static Security.Security.MDivisor;
import static Security.Security.MyPublicKey;
import static Security.SubstitutionBox.SuccessiveCharsIncrementSim;
import static Security.SubstitutionBox.SuccessiveCharsLenSim;
import static Security.SubstitutionBox.SuccessiveCharsIncrementWeiBull;
import static Security.SubstitutionBox.SuccessiveCharsLenWeiBull;
import static Security.SecurityTestHarness.ConfirmedFirstEvent;
import static Security.SecurityTestHarness.ConfirmedSecondEvent;
import static Security.SecurityTestHarness.OccasionNoOfTimesIndex;
import static Security.SecurityTestHarness.EavesdroppingFlag;
import static SenderReceiverGUI.Receiver.TestExecResultsMessage;
import static SenderReceiverGUI.Receiver.Communicate_Receiver;
import static SenderReceiverGUI.Receiver.MessageSize;
import static SenderReceiverGUI.Receiver.OffsetRotate1;
import static SenderReceiverGUI.Receiver.OffsetRotate2;
import static SenderReceiverGUI.Receiver.PrintReadValues;
import static SenderReceiverGUI.Receiver.Rand1Rotate;
import static SenderReceiverGUI.Receiver.ReceiveAMessage;
import static SenderReceiverGUI.Receiver.StrlenRotate1;
import static SenderReceiverGUI.Receiver.StrlenRotate2;
import static SenderReceiverGUI.Receiver.WeiCharRand3;
import static SenderReceiverGUI.Receiver.WeiRand2;
import static SenderReceiverGUI.Receiver.hostName;
import static SenderReceiverGUI.Receiver.mainHeader;
import static SenderReceiverGUI.Receiver.ReceiverTCPDecrypt;
import static SenderReceiverGUI.Receiver.ReadTCPPacketCount;
import static Security.TCPDecryption.TearDown;
import static Security.TCPDecryption.makeConnectionReceiv;
import static SenderReceiverGUI.Receiver.FirstTimeFlagKeys;
import static SenderReceiverGUI.Receiver.Parameters;
import static SenderReceiverGUI.Receiver.ReceivePacketTCP1on1Frame;
import static SenderReceiverGUI.Receiver.port;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.text.DefaultCaret;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
enum ConnectionState {
    INITIAL, LISTENING, READY, CONNECTED, CLOSED
}

public class ReceiverGUI {

    public static Logger log = Logger.getLogger(ReceiverGUI.class.getName());
    private static ConnectionState state = ConnectionState.INITIAL;
    public static JButton buttonListen = new JButton("Listen");
    public static JButton buttonRESET = new JButton("RESET AND LISTEN");

    public static JFrame frame = new JFrame("ReceiverGUI");
    public static JPanel jpanelMain = null;
    public static JPanel jpanelConsole = null;
    private static JMenu menu;
    private static JMenuItem ExitItemMenu;
    public static JTextArea textAreaConsoleRcv = null;
    public static JScrollPane textAreaScroll;
    //public static JTextArea textAreaMain=new JTextArea(25,80);
    public static JTextAreaOutputStream outRcv = null;
    public static String StrGUI = "NOGUI";
    public static JLabel GUIMesgLabel = new JLabel("Message");
    public static JLabel GUIhostNameLabel = new JLabel("hostName");
    public static JLabel GUIPortLabel = new JLabel("Port");

    public static JTextField GUIMesg = null;
    public static JTextField GUIhostName = null;
    public static JTextField GUIPort = null;
    public static JTextField GUISocketStatus = null;
    // Popup Menu Variables
    public static PopupMenu MyPopup = null;

    public static JTabbedPane tabpane = null;

    public static void main(String[] args) {
        StrGUI = "GUI";
        System.out.println("ReceiverGUI:StrGUI=" + StrGUI);
        if (USE_AES == false) {
            System.out.println(ConsoleColors.GREEN + "Receiver:USER HAS FULL CONTROL OVER SOURCE CODE AND FULL RESPONSIBILITY FOR SECURITY." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.BLUE + "Receiver:USER IS USING MODERN METHODS FOR SECURITY." + ConsoleColors.RESET);
        }
        if (ReceiverTCPDecrypt == false) {
            System.out.println(ConsoleColors.RED + "ReceiverGUI:WARNING:TCP Encryption is OFF." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.GREEN + "ReceiverGUI:TCP Encryption is ON." + ConsoleColors.RESET);
        }
        Parameters();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CreateandShowGUI();
            }
        });

    }
//    public static void main(String[] args) {
//        System.out.printf("HelloWorld");
//    }

    public static void CreateandShowGUI() {

        /* ************************* Main Variables Declaration ********* */
        JMenuBar menubar = new JMenuBar();
        /* ************************* Main Variables Declaration ********* */
        tabpane = new JTabbedPane();
        createMainMenu();
        //CreateMainPanel();
        jpanelMain = createMainPanel();
        tabpane.add("Main", jpanelMain);
        createConsole();

        outRcv = new JTextAreaOutputStream(textAreaConsoleRcv);
        System.setOut(new PrintStream(outRcv));
        System.setErr(new PrintStream(outRcv));

        /* ************************* Call Main Encryption Variables Declaration ********* */
        mainHeader();
        /* ************************* Call Main Encryption Variables Declaration ********* */

        DefaultCaret caret = (DefaultCaret) textAreaConsoleRcv.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        textAreaConsoleRcv.setAutoscrolls(true);
        textAreaConsoleRcv.setCaretPosition(textAreaConsoleRcv.getDocument().getLength());
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(textAreaScroll, BorderLayout.SOUTH);
        jpanelConsole.add(textAreaScroll);
        tabpane.add("Console", jpanelConsole);
        menubar.add(menu);
        frame.add(tabpane);
        //frame.getContentPane().add(tabpane);

        MyPopup = new PopupMenu(GUIMesg);
        GUIMesg.setComponentPopupMenu(MyPopup);

        PopupMenu consolePopup = new PopupMenu(textAreaConsoleRcv);
        textAreaConsoleRcv.setComponentPopupMenu(consolePopup);

        frame.setJMenuBar(menubar);
        frame.setSize(20, 60);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        GUIInitialConditions();
        //frame.setLayout(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static void createMainMenu() {
        /* **************************************************************** */
 /* Main Menu Set up*/
 /* **************************************************************** */
        menu = new JMenu("MainMenu");
        ExitItemMenu = new JMenuItem("Exit");

        ExitItemMenu.setMnemonic(EXIT_ON_CLOSE);
        ExitItemMenu.setToolTipText("Exit Application");
        //ExitItemMenu.addActionListener((event) -> System.exit(0));
        ExitItemMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if (s.equalsIgnoreCase("Exit")) {
                    if (USEUDP.equalsIgnoreCase("USETCP")) {
                        TearDown();
                    }
                    System.exit(0);
                }
            }
        });
        menu.add(ExitItemMenu);
    }

    public static void createConsole() {
        jpanelConsole = new JPanel();
        textAreaConsoleRcv = new JTextArea(20, 60);
        textAreaConsoleRcv.setEditable(false);
        textAreaConsoleRcv.setLineWrap(true);
        textAreaScroll = new JScrollPane(textAreaConsoleRcv, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        // Redirect System.out to the visible console
    }

    private static JPanel createMainPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        GUIMesg = new JTextField(40);
        GUIhostName = new JTextField(20);
        GUIPort = new JTextField("" + port, 10);
        GUISocketStatus = new JTextField(20);
        GUISocketStatus.setEditable(false);
        state = ConnectionState.INITIAL;
        GUISocketStatus.setText("Initial");

        buttonListen = new JButton("Listen");
        buttonListen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if ((s.equalsIgnoreCase("LISTEN"))) {
                    textAreaConsoleRcv.setText(textAreaConsoleRcv.getText() + "                            LISTEN:" + s + "\n");
                    StartMainThread();
                    buttonRESET.setEnabled(true);
                    state = ConnectionState.LISTENING;
                    GUISocketStatus.setText("Listening..");
                    updateUI();
                } else {
                    GUIMesg.setText(null);
                    textAreaConsoleRcv.setText(textAreaConsoleRcv.getText() + "Finished:" + s + "\n");
                }
            }
        });

        buttonRESET = new JButton("Reset");
        buttonRESET.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if ((s.equalsIgnoreCase("Reset"))) {
                    textAreaConsoleRcv.setText(textAreaConsoleRcv.getText() + "                            RESET AND LISTEN:" + s + "\n");
                    StartResetThread2();
                    StartMainThread();
                    buttonRESET.setEnabled(true);
                    buttonListen.setEnabled(true);
                    state = ConnectionState.LISTENING;
                    updateUI();
                } else {
                    GUIMesg.setText(null);
                    textAreaConsoleRcv.setText(textAreaConsoleRcv.getText() + "Finished:" + s + "\n");
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Message:"), gbc);
        gbc.gridx = 1;
        panel.add(GUIMesg, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Host:"), gbc);
        gbc.gridx = 1;
        panel.add(GUIhostName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Port:"), gbc);
        gbc.gridx = 1;
        panel.add(GUIPort, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Receiver Socket Status:"), gbc);
        gbc.gridx = 1;
        panel.add(GUISocketStatus, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(buttonListen, gbc);
        gbc.gridx = 1;
        panel.add(buttonRESET, gbc);

        return panel;
    }

    private static void StartMainThread() {

        SwingWorker sw1 = new SwingWorker() {
            @Override
            protected String doInBackground() {
                String Status = "";
                try {
                    if ((FirstTimeFlagKeys == false) && (SecurityPosture.equalsIgnoreCase("ChangeKeysAfterEveryUse"))
                            && (((TestDebug.equalsIgnoreCase("Production")) && (PlainText == false)))) {
                        PacketSynchronizedAlgebraicCipher.SetupAlice("Decrypt");
                        PacketSynchronizedAlgebraicCipher.SetupBob("Decrypt");
                        //SetupEve();
                        FirstTimeFlagKeys = false;
                    }
                    FirstTimeFlagKeys = false;
                    makeConnectionReceiv();
                    ReceivePacketTCP1on1Frame();
                    Status += PrintReadValues() + ":";
                    Status += ReceiveAMessage() + ":";
                    System.out.println("Mesg:ReceiverMesg=" + DecryptedMesg);
                    TestExecResultsMessage();
                    GUIMesg.setText(DecryptedMesg.toString());
                    textAreaConsoleRcv.setText(textAreaConsoleRcv.getText() + DecryptedMesg + "\n");
                    textAreaConsoleRcv.setText(textAreaConsoleRcv.getText() + Status + ":Finished:All" + "\n");
                    ResetReadData();
                    state= ConnectionState.READY;
                    updateUI();
                    textAreaConsoleRcv.setText(textAreaConsoleRcv.getText() + "RESETDATA FOR NEXT USE" + "\n");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return Status + ":Finished:All";
            }
        };
        sw1.execute();
    }

    private static void StartResetThread2() {

        SwingWorker sw1 = new SwingWorker() {
            @Override
            protected String doInBackground() {
                String Status = "";
                ResetReadData();
                GUIMesg.setText(null);
                return Status + "Finished:All";
            }
        };
        sw1.execute();
    }

    private static void ResetReadData() {
        ReadTCPPacketCount = 0;
        Rand1Rotate = 0;
        OffsetRotate1 = 0;
        StrlenRotate1 = 0;
        OffsetRotate2 = 0;
        StrlenRotate2 = 0;
        UDPBuffLen = 8192;
        MessageSize = 0;
        WeiRand2 = 0.0;
        WeiCharRand3 = 0.0;
        MyPublicKey = "";
        MDivisor = 0.0;
        CyclicFlag = false;
        NumberOfTimes = 1;
        SuccessiveCharsLenSim = 2;
        SuccessiveCharsIncrementSim = 1;
        SuccessiveCharsLenWeiBull = 2;
        SuccessiveCharsIncrementWeiBull = 1;
        EavesdroppingFlag = true;
        OccasionNoOfTimesIndex = 0;
        for (int i = 0; i < NumberOfTimes; i++) {
            ConfirmedFirstEvent[i] = 0.0;
            ConfirmedSecondEvent[i] = 0.0;
        }
    }

    public static void logToConsoleRcv(String Message) {
        textAreaConsoleRcv.append(Message + "\n\n");
        textAreaConsoleRcv.setCaretPosition(textAreaConsoleRcv.getDocument().getLength());
    }

    public static void GUIInitialConditions() {
        buttonRESET.setEnabled(false);
        textAreaConsoleRcv.setText(textAreaConsoleRcv.getText() + "LISTEN Button Forcibly clicked:2:Finished\n");
        textAreaConsoleRcv.setText(textAreaConsoleRcv.getText() + "                            LISTEN:Finished\n");
    }

    private static void updateUI() {
    switch (state) {
        case INITIAL -> {
            buttonListen.setEnabled(true);
            buttonRESET.setEnabled(false);
            GUISocketStatus.setText("Initial");
        }
        case LISTENING -> {
            buttonListen.setEnabled(false);
            buttonRESET.setEnabled(false);
            GUISocketStatus.setText("Listening...");
        }
        case READY-> {
            buttonListen.setEnabled(true);
            buttonRESET.setEnabled(true);
            GUISocketStatus.setText("Ready...");
        }
        case CONNECTED -> {
            buttonListen.setEnabled(true);
            buttonRESET.setEnabled(true); 
            GUISocketStatus.setText("Connected");
        }
        case CLOSED -> {
            buttonListen.setEnabled(true);
            buttonRESET.setEnabled(true); // Enable Reset after protocol ends
            GUISocketStatus.setText("Closed");
        }
    }
}

    public void logToConsole(String msg) {
        textAreaConsoleRcv.append(msg + "\n");
        textAreaConsoleRcv.setCaretPosition(textAreaConsoleRcv.getDocument().getLength());
    }
}
