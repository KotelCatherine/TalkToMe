package ru.geekbrains.swing.Server;

import ru.geekbrains.swing.Client.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame {

    private static final int POS_X = 800;
    private static final int POS_Y = 400;
    private static final int WIDTH = 250;
    private static final int HEIGHT = 200;

    private final ImageIcon icoStart = new ImageIcon("E:\\GB\\project\\TalkToMe\\src\\main\\java\\ru\\geekbrains\\swing\\Server\\images\\start.png");
    private final ImageIcon icoStop = new ImageIcon("E:\\GB\\project\\TalkToMe\\src\\main\\java\\ru\\geekbrains\\swing\\Server\\images\\stop.png");
    private final JPanel panelButton = new JPanel(new GridLayout(1,2));
    private final JButton buttonStart = new JButton(icoStart);
    private final JButton buttonStop = new JButton(icoStop);
    private static boolean isServerWorking = false;

    private final JPanel infoPanel = new JPanel(new BorderLayout());
    private final JTextArea infoArea = new JTextArea();

    public ServerGUI() {
        setTitle("Server");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = true;
                infoArea.setText("Server: start");
                ClientGUI.readFile();
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = false;
                infoArea.setText("Server: stop");
            }
        });

        creatPanelWithButton();
        creatInfoPanel();
    }

    public static boolean isServerWorking() {
        return isServerWorking;
    }

    private void creatInfoPanel() {
        infoPanel.add(infoArea);
        add(infoPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void creatPanelWithButton() {
        panelButton.add(buttonStart);
        panelButton.add(buttonStop);
        add(panelButton, BorderLayout.NORTH);

        setVisible(true);
    }

}
