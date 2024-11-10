import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JTextField num1Field, num2Field, resultField;
    private JComboBox<String> operationBox;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Initialize components
        num1Field = new JTextField();
        num2Field = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);
        
        String[] operations = {"+", "-", "*", "/"};
        operationBox = new JComboBox<>(operations);
        
        JButton calcButton = new JButton("Calculate");
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        // Add components to the frame
        add(new JLabel("Number 1:"));
        add(num1Field);
        add(new JLabel("Operation:"));
        add(operationBox);
        add(new JLabel("Number 2:"));
        add(num2Field);
        add(calcButton);
        add(resultField);

        setVisible(true);
    }

    private void calculate() {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            String operation = (String) operationBox.getSelectedItem();
            double result;

            switch (operation) {
                case "+" -> result = num1 + num2;
                case "-" -> result = num1 - num2;
                case "*" -> result = num1 * num2;
                case "/" -> result = num1 / num2;
                default -> throw new IllegalArgumentException("Invalid operation");
            }

            resultField.setText(String.valueOf(result));
        } catch (Exception e) {
            resultField.setText("Error");
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
