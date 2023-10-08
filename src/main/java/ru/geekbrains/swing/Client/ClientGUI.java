package ru.geekbrains.swing.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ClientGUI extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 500;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private final ImageIcon sendIcon = new ImageIcon("E:\\GB\\project\\TalkToMe\\src\\main\\java\\ru\\geekbrains\\swing\\Client\\img\\send.png");
    private final JPanel panelLogin = new JPanel(new GridLayout(2, 3));
    private final JTextField loginUser = new JTextField("cotelCatherine");
    private final JTextField passwordUser = new JTextField("12345");
    private final JTextField ipUser = new JTextField("178.185.121.160");
    private final JTextField portUser = new JTextField("8189");
    private final JButton buttonLogin = new JButton("Login");

    private final JPanel panelMessage = new JPanel(new BorderLayout());
    private static final JTextArea log = new JTextArea();
    private final JTextField messageInputField = new JTextField();
    private final JButton buttonSend = new JButton(sendIcon);
    private static final String fileName = "logChat.txt";

    private JPanel panelUsers =new JPanel(new GridLayout(1, 2));
    private JList<String> listUsers = new JList<>();
    private String users[] = {"Elisey","Ivan"};


    public ClientGUI()  {

        setTitle("TalkToMe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);

        creatPanelLogin();
        creatPanelMessage();

        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessageToLog();
            }
        });

        messageInputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessageToLog();
                }
            }
        });

        listUsers.setBackground(Color.LIGHT_GRAY);
        listUsers.setListData(users);
        panelUsers.add(listUsers, BorderLayout.WEST);
        add(panelUsers, BorderLayout.WEST);

        setVisible(true);
    }

    private void creatPanelMessage() {
        messageInputField.setFont(new Font("serif", Font.PLAIN, 18));
        panelMessage.add(messageInputField, BorderLayout.CENTER);
        panelMessage.add(buttonSend, BorderLayout.EAST);

        add(log, BorderLayout.CENTER);
        add(panelMessage, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void creatPanelLogin() {
        panelLogin.add(loginUser);
        panelLogin.add(passwordUser);
        panelLogin.add(ipUser);
        panelLogin.add(portUser);
        panelLogin.add(buttonLogin);

        add(panelLogin, BorderLayout.NORTH);

        setVisible(true);
    }

    private void sendMessageToLog() {
        String str = messageInputField.getText();

        log.append(str + '\n');
        writeToFile(str);
    }

    public static void readFile()  {
        String line = null;
        int i = 0;
        try (BufferedReader readerFileToLog = new BufferedReader(new FileReader(fileName))){

            while ((line = readerFileToLog.readLine())!= null) {
                log.append(line + '\n');
            }

        }catch (IOException ex) {

        }

    }

    private boolean isFileEmpty() {
        return fileName.isEmpty();
    }

    private void writeToFile(String str) {
        try (BufferedWriter writerLog = new BufferedWriter(new FileWriter(fileName, true))){

            writerLog.write(str);
            writerLog.write('\n');

        } catch (IOException ex) {
            System.err.println("Problem writing to file");
        }
    }
}
