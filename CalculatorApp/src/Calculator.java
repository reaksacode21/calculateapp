import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, modulusButton, clearButton;

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Add spacing between components
        setResizable(false);

        // Create panels
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10)); // Add spacing between components
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10)); // Add spacing between components

        // Create input fields
        firstNumberField = new JTextField();
        secondNumberField = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        // Set font for input fields and result
        Font font = new Font("Arial", Font.PLAIN, 18);
        firstNumberField.setFont(font);
        secondNumberField.setFont(font);
        resultField.setFont(font);

        // Add labels and input fields to the input panel
        inputPanel.add(new JLabel("First Number:", SwingConstants.RIGHT));
        inputPanel.add(firstNumberField);
        inputPanel.add(new JLabel("Second Number:", SwingConstants.RIGHT));
        inputPanel.add(secondNumberField);
        inputPanel.add(new JLabel("Result:", SwingConstants.RIGHT));
        inputPanel.add(resultField);

        // Create buttons
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        modulusButton = new JButton("%");
        clearButton = new JButton("Clear");

        // Set font for buttons
        addButton.setFont(font);
        subtractButton.setFont(font);
        multiplyButton.setFont(font);
        divideButton.setFont(font);
        modulusButton.setFont(font);
        clearButton.setFont(font);

        // Add action listeners to buttons
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        modulusButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Add buttons to the button panel
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(modulusButton);
        buttonPanel.add(clearButton);

        // Add panels to the frame
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add padding around the panels
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                result = num1 / num2;
            } else if (e.getSource() == modulusButton) {
                result = num1 % num2;
            } else if (e.getSource() == clearButton) {
                firstNumberField.setText("");
                secondNumberField.setText("");
                resultField.setText("");
                return;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
