package myproject;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Version5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Operaciones Matemáticas");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(135, 206, 250)); // Color cielo
        panel.setLayout(null);
        frame.add(panel);

        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        JLabel welcomeLabel = new JLabel("¡Bienvenido al programa de operaciones matemáticas!");
        welcomeLabel.setBounds(50, 10, 400, 25);
        panel.add(welcomeLabel);

        JLabel userLabel = new JLabel("Número 1:");
        userLabel.setBounds(10, 50, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 50, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Número 2:");
        passwordLabel.setBounds(10, 80, 80, 25);
        panel.add(passwordLabel);

        JTextField passwordText = new JTextField(20);
        passwordText.setBounds(100, 80, 165, 25);
        panel.add(passwordText);

        JButton sumButton = new JButton("Sumar");
        sumButton.setBounds(10, 120, 100, 25);
        panel.add(sumButton);

        JButton subtractButton = new JButton("Restar");
        subtractButton.setBounds(120, 120, 100, 25);
        panel.add(subtractButton);

        JButton multiplyButton = new JButton("Multiplicar");
        multiplyButton.setBounds(230, 120, 100, 25);
        panel.add(multiplyButton);

        JButton divideButton = new JButton("Dividir");
        divideButton.setBounds(340, 120, 100, 25);
        panel.add(divideButton);

        JLabel resultLabel = new JLabel("Resultado:");
        resultLabel.setBounds(10, 160, 200, 25);
        panel.add(resultLabel);

        JPanel chartPanel = new JPanel();
        chartPanel.setBounds(10, 200, 460, 350);
        panel.add(chartPanel);

        sumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(userText.getText());
                    int b = Integer.parseInt(passwordText.getText());
                    int sum = a + b;
                    resultLabel.setText("Resultado: " + sum);
                    displayChart(chartPanel, "Suma", sum);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Error: Ingresa números válidos.");
                }
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(userText.getText());
                    int b = Integer.parseInt(passwordText.getText());
                    int difference = a - b;
                    resultLabel.setText("Resultado: " + difference);
                    displayChart(chartPanel, "Resta", difference);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Error: Ingresa números válidos.");
                }
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(userText.getText());
                    int b = Integer.parseInt(passwordText.getText());
                    int product = a * b;
                    resultLabel.setText("Resultado: " + product);
                    displayChart(chartPanel, "Multiplicación", product);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Error: Ingresa números válidos.");
                }
            }
        });

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(userText.getText());
                    int b = Integer.parseInt(passwordText.getText());
                    if (b == 0) {
                        resultLabel.setText("Error: División por cero.");
                    } else {
                        double quotient = (double) a / b;
                        resultLabel.setText("Resultado: " + quotient);
                        displayChart(chartPanel, "División", quotient);
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Error: Ingresa números válidos.");
                }
            }
        });
    }

    private static void displayChart(JPanel chartPanel, String operation, double result) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(result, operation, operation);

        JFreeChart chart = ChartFactory.createBarChart3D(
                "Resultado de " + operation,
                "Operación",
                "Valor",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(460, 350));

        chartPanel.removeAll();
        chartPanel.add(panel);
        chartPanel.revalidate();
        chartPanel.repaint();
    }
}

