package myproject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Version3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Suma de dos números");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Número 1:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Número 2:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JTextField passwordText = new JTextField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton sumButton = new JButton("Sumar");
        sumButton.setBounds(10, 80, 80, 25);
        panel.add(sumButton);

        JLabel resultLabel = new JLabel("Resultado:");
        resultLabel.setBounds(100, 80, 165, 25);
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

