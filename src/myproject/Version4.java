package myproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Version4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Suma de dos números");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(135, 206, 250)); // Color cielo
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel welcomeLabel = new JLabel("¡Bienvenido al programa de suma!");
        welcomeLabel.setBounds(50, 10, 250, 25);
        panel.add(welcomeLabel);

        JLabel userLabel = new JLabel("Número 1:");
        userLabel.setBounds(10, 40, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 40, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Número 2:");
        passwordLabel.setBounds(10, 70, 80, 25);
        panel.add(passwordLabel);

        JTextField passwordText = new JTextField(20);
        passwordText.setBounds(100, 70, 165, 25);
        panel.add(passwordText);

        JButton sumButton = new JButton("Sumar");
        sumButton.setBounds(10, 110, 80, 25);
        panel.add(sumButton);

        JLabel resultLabel = new JLabel("Resultado:");
        resultLabel.setBounds(100, 110, 165, 25);
        panel.add(resultLabel);

        sumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(userText.getText());
                    int b = Integer.parseInt(passwordText.getText());
                    int sum = a + b;
                    resultLabel.setText("Resultado: " + sum);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Error: Ingresa números válidos.");
                }
            }
        });
    }
}
