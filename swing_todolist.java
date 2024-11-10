package Swings;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Lab3 extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskField;
    private JButton addButton, completeButton, deleteButton;
    private ArrayList<String> completedTasks;

    public Lab3() {
        setTitle("To-Do List Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskField = new JTextField(20);
        addButton = new JButton("Add Task");
        completeButton = new JButton("Mark Complete");
        deleteButton = new JButton("Delete Task");
        completedTasks = new ArrayList<>();

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("New Task:"));
        inputPanel.add(taskField);
        inputPanel.add(addButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(completeButton);
        buttonPanel.add(deleteButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addTask());
        completeButton.addActionListener(e -> markTaskComplete());
        deleteButton.addActionListener(e -> deleteTask());

        setVisible(true);
    }

    private void addTask() {
        String task = taskField.getText().trim();

        if (task.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Task cannot be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (taskListModel.contains(task)) {
            JOptionPane.showMessageDialog(this, "Task already exists", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        taskListModel.addElement(task);
        taskField.setText("");
    }

    private void markTaskComplete() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select a task to mark as complete", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String task = taskListModel.getElementAt(selectedIndex);
        if (completedTasks.contains(task)) {
            JOptionPane.showMessageDialog(this, "Task is already marked as complete", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            completedTasks.add(task);
            taskListModel.set(selectedIndex, "✓ " + task);
        }
    }

    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select a task to delete", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String task = taskListModel.getElementAt(selectedIndex);
        taskListModel.remove(selectedIndex);
        completedTasks.remove(task.replace("✓ ", ""));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Lab3::new);
    }
}
