import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CourseManagerUI {
    private CourseManager manager;
    private JFrame frame;
    private JTextArea courseDisplay;
    private JTextField studentIdField;
    private JTextField courseCodeField;

    public CourseManagerUI() {
        manager = new CourseManager();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Course Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        courseDisplay = new JTextArea(10, 50);
        courseDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(courseDisplay);
        topPanel.add(scrollPane);
        frame.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(3, 2));
        centerPanel.add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        centerPanel.add(studentIdField);
        centerPanel.add(new JLabel("Course Code:"));
        courseCodeField = new JTextField();
        centerPanel.add(courseCodeField);
        JButton registerButton = new JButton("Register");
        centerPanel.add(registerButton);
        JButton dropButton = new JButton("Drop");
        centerPanel.add(dropButton);
        frame.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(2, 2));
        JButton addCourseButton = new JButton("Add Course");
        JButton addStudentButton = new JButton("Add Student");
        bottomPanel.add(addCourseButton);
        bottomPanel.add(addStudentButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String studentId = studentIdField.getText();
                String courseCode = courseCodeField.getText();
                if (manager.registerStudentForCourse(studentId, courseCode)) {
                    updateCourseDisplay();
                    JOptionPane.showMessageDialog(frame, "Registration Successful");
                } else {
                    JOptionPane.showMessageDialog(frame, "Registration Failed");
                }
            }
        });

        dropButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String studentId = studentIdField.getText();
                String courseCode = courseCodeField.getText();
                if (manager.removeStudentFromCourse(studentId, courseCode)) {
                    updateCourseDisplay();
                    JOptionPane.showMessageDialog(frame, "Course Dropped Successfully");
                } else {
                    JOptionPane.showMessageDialog(frame, "Failed to Drop Course");
                }
            }
        });

        addCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                manager.addCourse(new Course("CS101", "Intro to Computer Science", "Basics of CS", 30, "Mon-Wed 9-11 AM"));
                manager.addCourse(new Course("MATH101", "Calculus I", "Introduction to Calculus", 25, "Tue-Thu 10-12 AM"));
                updateCourseDisplay();
                JOptionPane.showMessageDialog(frame, "Sample Courses Added");
            }
        });

        addStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                manager.addStudent(new Student("S001", "Alice"));
                manager.addStudent(new Student("S002", "Bob"));
                JOptionPane.showMessageDialog(frame, "Sample Students Added");
            }
        });
        updateCourseDisplay();

        frame.setVisible(true);
    }

    private void updateCourseDisplay() {
        courseDisplay.setText("");
        for (Course course : manager.getAvailableCourses()) {
            courseDisplay.append(course.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CourseManagerUI();
            }
        });
    }
}
