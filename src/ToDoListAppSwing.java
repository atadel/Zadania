import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ToDoListAppSwing extends JFrame {
    private JTextField newTask = new JTextField(20);
    private List<JCheckBox> tasks = new ArrayList<>();

    private void removeSelectedTasks() {
        List<JCheckBox> selectedTasks = new ArrayList<>();
        for (JCheckBox task : tasks) {
            if (task.isSelected()) {
                selectedTasks.add(task);
            }
        }
        for (JCheckBox task : selectedTasks) {
            tasks.remove(task);
        }
        updateTaskList();
    }

    private void addTask(String text) {
        JCheckBox task = new JCheckBox(text);
        tasks.add(task);
        updateTaskList();
    }

    private void updateTaskList() {
        JPanel taskListPanel = new JPanel();
        taskListPanel.setLayout(new BoxLayout(taskListPanel, BoxLayout.Y_AXIS));
        for (JCheckBox task : tasks) {
            taskListPanel.add(task);
        }
        JScrollPane taskListScrollPane = new JScrollPane(taskListPanel);
        taskListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        getContentPane().removeAll();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(taskListScrollPane, BorderLayout.CENTER);
        getContentPane().add(createButtonPanel(), BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        JButton removeButton = new JButton("Usuń");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeSelectedTasks();
            }
        });

        JButton addButton = new JButton("Dodaj");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask(newTask.getText());
            }
        });

        buttonPanel.add(newTask);
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        return buttonPanel;
    }

    public ToDoListAppSwing() {
        setTitle("Lista zadań do zrobienia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(null);

        // Tworzenie początkowych zadań
        tasks.add(new JCheckBox("Zadanie 1"));
        tasks.add(new JCheckBox("Zadanie 2"));
        tasks.add(new JCheckBox("Zadanie 3"));

        updateTaskList();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoListAppSwing().setVisible(true);
            }
        });
    }
}
