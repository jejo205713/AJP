import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SimpleLoginForm extends JFrame {
    private JTextField usernameField, emailField;
    private JPasswordField passwordField;

    public SimpleLoginForm() {
        setTitle("Login Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Create components
        usernameField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        JButton submitButton = new JButton("Submit");

        // Add action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });

        // Add components to the frame
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(submitButton);

        setVisible(true);
    }

    private void handleSubmit() {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        JOptionPane.showMessageDialog(this, "Username: " + username + "\nEmail: " + email + "\nPassword: " + password);
    }

    public static void main(String[] args) {
        new SimpleLoginForm();
    }
}
