package Swings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab2 extends JFrame implements ActionListener {
    private JTextField nameField, emailField, phoneField;
    private JPasswordField passwordField;
    private JButton submitButton;
    private JLabel messageLabel;

    public Lab2() {
        setTitle("User Registration Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        
        JLabel phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField();
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        messageLabel = new JLabel("", SwingConstants.CENTER);

        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(phoneLabel);
        add(phoneField);
        add(passwordLabel);
        add(passwordField);
        add(submitButton);
        add(messageLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String password = new String(passwordField.getPassword());

        if (!isValidName(name)) {
            messageLabel.setText("Error: Invalid name");
        } else if (!isValidEmail(email)) {
            messageLabel.setText("Error: Invalid email");
        } else if (!isValidPhone(phone)) {
            messageLabel.setText("Error: Invalid phone number");
        } else if (!isValidPassword(password)) {
            messageLabel.setText("Error: Password must be at least 8 characters");
        } else {
            messageLabel.setText("Success: Registration complete!");
        }
    }

    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8;
    }

    public static void main(String[] args) {
        new Lab2();
    }
}
