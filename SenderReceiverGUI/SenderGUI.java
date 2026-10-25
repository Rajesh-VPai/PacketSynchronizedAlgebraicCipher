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
import static Security.Configuration.SecurityPosture;
import static Security.Configuration.USEUDP;
import static Security.Configuration.USE_AES;
import static Security.Encryption.EncryptedMesg;
import static Security.Encryption.MyMessage;
import static Security.Encryption.PlainText;
import static Security.Encryption.TestDebug;
import static Security.PacketSynchronizedAlgebraicCipher.SetupAlice;
import static Security.PacketSynchronizedAlgebraicCipher.SetupBob;
import static Security.TCPEncryption.TearDown;
import static SenderReceiverGUI.Receiver.Parameters;
import static SenderReceiverGUI.Sender.port;
import static SenderReceiverGUI.Sender.mainHeader;
import static SenderReceiverGUI.Sender.SendAMessage;
import static SenderReceiverGUI.Sender.Communicate_Sender;
import static SenderReceiverGUI.Sender.EqnUnderTest;
import static SenderReceiverGUI.Sender.FirstTimeFlagKeys;
import static SenderReceiverGUI.Sender.InitialMsgEncryptState_HighOTP;
import static SenderReceiverGUI.Sender.InitialMsgEncryptState_SecretSeed;
import static SenderReceiverGUI.Sender.InverseEqnUnderTest;
import static SenderReceiverGUI.Sender.Rand1Rotate;
import static SenderReceiverGUI.Sender.SenderHighLevelSelector;
import static SenderReceiverGUI.Sender.SenderHighLevelUnsupportedSelector;
import static SenderReceiverGUI.Sender.SenderTCPEncrypt;
import static SenderReceiverGUI.Sender.SentValues;
import static SenderReceiverGUI.Sender.User_SecretHighOTP;
import static SenderReceiverGUI.Sender.User_SecretSeedHighLevel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
enum SenderState {
    INITIAL, READY, SENDING, CLOSED
};

public class SenderGUI extends JFrame {

    public static Logger log = Logger.getLogger(SenderGUI.class.getName());
    private static SenderState state = SenderState.INITIAL;
    public static JButton buttonSend = new JButton("Send");
    public static JButton buttonRESET = new JButton("Flush and Teardown");

    public static JFrame frame = new JFrame("SenderGUI");
    public static JPanel jpanelMain = null;
    public static JPanel jpanelConsole = null;
    private static JMenu menu;

    private static JMenuItem ExitItemMenu;
    public static JTextArea textAreaConsoleSnd = null;
    public static JScrollPane textAreaScroll;
    public static JTextAreaOutputStream outSend = null;
    public static String StrGUI = "NOGUI";
    public static JLabel GUIMesgLabel = new JLabel("Message");
    public static JLabel GUIhostNameLabel = new JLabel("hostName");
    public static JLabel GUIPortLabel = new JLabel("Port");

    public static JTextField GUIMesg = null;
    public static JTextField GUIhostName = null;
    public static JTextField GUIPort = null;
    public static JTextField GUISocketStatus = null;

    public static JTabbedPane tabpane = null;

    public static StringBuilder SenderMesg = null;
    // Popup Menu Variables
    public static PopupMenu MyPopup = null;

    public static void main(String[] args) {
        StrGUI = "GUI";
        System.out.println("SenderGUI:StrGUI=" + StrGUI);
        if (USE_AES == false) {
            System.out.println(ConsoleColors.GREEN + "Sender:USER HAS FULL CONTROL OVER SOURCE CODE AND FULL RESPONSIBILITY FOR SECURITY." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.BLUE + "Sender:USER IS USING MODERN METHODS FOR SECURITY." + ConsoleColors.RESET);
        }
        if (SenderTCPEncrypt == false) {
            System.out.println(ConsoleColors.RED + "SenderGUI:WARNING:TCP Encryption is OFF." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.GREEN + "SenderGUI:TCP Encryption is ON." + ConsoleColors.RESET);
        }
        Parameters();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CreateandShowGUI();
            }
        });
    }

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

        outSend = new JTextAreaOutputStream(textAreaConsoleSnd);
        System.setOut(new PrintStream(outSend));
        System.setErr(new PrintStream(outSend));

        /* ************************* Call Main Encryption Variables Declaration ********* */
        mainHeader();
        /* ************************* Call Main Encryption Variables Declaration ********* */
        DefaultCaret caret = (DefaultCaret) textAreaConsoleSnd.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        textAreaConsoleSnd.setAutoscrolls(true);
        textAreaConsoleSnd.setCaretPosition(textAreaConsoleSnd.getDocument().getLength());
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(textAreaScroll, BorderLayout.CENTER);
        jpanelConsole.add(textAreaScroll);
        tabpane.add("Console", jpanelConsole);

        MyPopup = new PopupMenu(GUIMesg);
        GUIMesg.setText("the quick brown fox jumps over the lazy dog.1234567890:\"\'!@#$%^&*()+-_={}[];><,./?|\\");
        GUIMesg.setComponentPopupMenu(MyPopup);

        PopupMenu consolePopup = new PopupMenu(textAreaConsoleSnd);
        textAreaConsoleSnd.setComponentPopupMenu(consolePopup);
        frame.add(MyPopup);
        menubar.add(menu);
        frame.add(tabpane);

        //frame.getContentPane().add(tabpane);
        frame.setJMenuBar(menubar);
        frame.setSize(20, 60);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        GUIInitialConditions();
        frame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                MyPopup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
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
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        textAreaConsoleSnd = new JTextArea(20, 60);
        textAreaConsoleSnd.setEditable(false);
        textAreaConsoleSnd.setLineWrap(true);
        textAreaScroll = new JScrollPane(textAreaConsoleSnd, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
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
        state = SenderState.INITIAL;
        GUISocketStatus.setText("Initial");
        

        buttonSend = new JButton("Send");
        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if ((s.equalsIgnoreCase("Send"))&&(state != SenderState.SENDING)) {
                    textAreaConsoleSnd.setText(textAreaConsoleSnd.getText() + "                            Sending:" + s + "\n");
                    SenderMesg = new StringBuilder(GUIMesg.getText());
                    EncryptedMesg = new StringBuilder(GUIMesg.getText());
                    MyMessage = GUIMesg.getText();
                    StartMainThread();
                    state = SenderState.SENDING;
                    updateUI();
                } else if (state != SenderState.SENDING){
                    GUIMesg.setText(null);
                    textAreaConsoleSnd.setText(textAreaConsoleSnd.getText() + "Do NOT PLAY WITH SECURITY:Finished:" + s + "\n");
                }
            }
        });

        buttonRESET = new JButton("Reset");
        //buttonRESET.addActionListener(this::onResetClicked);
        buttonRESET.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if ((s.equalsIgnoreCase("Reset"))&&(state == SenderState.SENDING)&&(Rand1Rotate==0)) {
                    //textAreaConsoleRcv.setText(null);
                    textAreaConsoleSnd.setText(textAreaConsoleSnd.getText() + "                            RESET AND LISTEN:" + s + "\n");
                    buttonSend.setEnabled(true);
                    state = SenderState.READY;
                    updateUI();
                } else if (state != SenderState.SENDING){
                    GUIMesg.setText(null);
                    textAreaConsoleSnd.setText(textAreaConsoleSnd.getText() + "Finished:" + s + "\n");
                    state = SenderState.READY;
                    updateUI();
                }else if ((state == SenderState.SENDING)&&(Rand1Rotate!=0)){
                    //GUIMesg.setText(null);
                    textAreaConsoleSnd.setText(textAreaConsoleSnd.getText() + "Sender is Busy Sending:RESET Failed" + s + "\n");
                    Rand1Rotate=0;
                    textAreaConsoleSnd.setText(textAreaConsoleSnd.getText() + "                            RESET AND LISTEN:" + s + "\n");
                    buttonSend.setEnabled(true);
                    state = SenderState.READY;
                    updateUI();
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
        panel.add(new JLabel("Sender Socket Status:"), gbc);
        gbc.gridx = 1;
        panel.add(GUISocketStatus, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(buttonSend, gbc);
        gbc.gridx = 1;
        panel.add(buttonRESET, gbc);

        return panel;
    }

    private static void StartMainThread() {

        SwingWorker sw1 = new SwingWorker() {
            @Override
            protected String doInBackground() {
                if ((FirstTimeFlagKeys == false) && (SecurityPosture.equalsIgnoreCase("ChangeKeysAfterEveryUse")) && (((TestDebug.equalsIgnoreCase("Production")) && (PlainText == false)))) {
                    SetupAlice("Encrypt");
                    SetupBob("Encrypt");
                    //SetupEve();
                    FirstTimeFlagKeys = false;
                }
                FirstTimeFlagKeys = false;
                SendAMessage();
                Communicate_Sender();
                SentValues();
                state=SenderState.READY;
                updateUI();
                System.out.println("TestExecResultsMessage: User_SecretSeedHighLevel=" + User_SecretSeedHighLevel + " User_SecretHighOTP=" + User_SecretHighOTP);
                System.out.println("TestExecResultsMessage: InitialMsgEncryptState_HighOTP=" + InitialMsgEncryptState_HighOTP + " InitialMsgEncryptState_SecretSeed=" + InitialMsgEncryptState_SecretSeed);
                System.out.println("TestExecResultsMessage: EqnUnderTest=" + EqnUnderTest + " InverseEqnUnderTest=" + InverseEqnUnderTest);
                System.out.println("TestExecResultsMessage: SenderHighLevelSelector=" + SenderHighLevelSelector + " SenderHighLevelUnsupportedSelector=" + SenderHighLevelUnsupportedSelector);
                return "Finished";
            }
        };
        sw1.execute();
    }

    public static void logToConsoleSend(String Message) {
        textAreaConsoleSnd.append(Message + "\n\n");
        textAreaConsoleSnd.setCaretPosition(textAreaConsoleSnd.getDocument().getLength());
    }

    public static void GUIInitialConditions() {
        buttonRESET.setEnabled(false);
    }

    private static void updateUI() {
    switch (state) {
        case INITIAL -> {
            buttonSend.setEnabled(true);
            buttonRESET.setEnabled(false);
            GUISocketStatus.setText("Initial");
        }
        case READY -> {
            buttonSend.setEnabled(true);
            buttonRESET.setEnabled(true);
            GUISocketStatus.setText("Ready...");
        }
        case SENDING -> {
            buttonSend.setEnabled(false);
            buttonRESET.setEnabled(false); // Disable Reset while sending
            GUISocketStatus.setText("Sending...");
        }
        case CLOSED -> {
            buttonSend.setEnabled(false);
            buttonRESET.setEnabled(true);
            GUISocketStatus.setText("CLOSED");
        }
    }
}

    public void logToConsole(String msg) {
        textAreaConsoleSnd.append(msg + "\n");
        textAreaConsoleSnd.setCaretPosition(textAreaConsoleSnd.getDocument().getLength());
    }
}
