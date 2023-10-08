package ru.geekbrains.swing;
import ru.geekbrains.swing.Client.ClientGUI;
import ru.geekbrains.swing.Server.*;

import java.io.IOException;

public class ChatApp {
    public static void main(String[] args) throws IOException {
        new ServerGUI();
        new ClientGUI();
    }
}