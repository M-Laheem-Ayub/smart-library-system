package libraryManagementGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MyFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    private JTextField txtName, txtRollNo, txtBookTitle, txtIssueDate, txtReturnDate;
    private JTextArea txtRemarks;
    private JComboBox<String> cbCategory;
    private JRadioButton rbNew, rbOld;
    private ButtonGroup editionGroup;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MyFrame frame = new MyFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MyFrame() {

        setTitle("Library Book Issue System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 400);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(240, 248, 255));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblTitle = new JLabel("Library Management System");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitle.setBounds(164, 11, 280, 30);
        contentPane.add(lblTitle);

        JLabel lblName = new JLabel("Student Name:");
        lblName.setBounds(60, 46, 100, 20);
        contentPane.add(lblName);
        
        txtName = new JTextField();
        txtName.setBounds(60, 64, 200, 25);
        contentPane.add(txtName);

        JLabel lblRoll = new JLabel("Roll Number:");
        lblRoll.setBounds(60, 93, 100, 20);
        contentPane.add(lblRoll);
        
        txtRollNo = new JTextField();
        txtRollNo.setBounds(60, 110, 200, 25);
        contentPane.add(txtRollNo);

        JLabel lblTitleBook = new JLabel("Book Title:");
        lblTitleBook.setBounds(60, 146, 100, 20);
        contentPane.add(lblTitleBook);
        
        txtBookTitle = new JTextField();
        txtBookTitle.setBounds(60, 165, 200, 25);
        contentPane.add(txtBookTitle);

        JLabel lblCategory = new JLabel("Book Category:");
        lblCategory.setBounds(300, 46, 100, 20);
        contentPane.add(lblCategory);
        
        String[] categories = {"Programming", "AI", "Databases", "Networking"};
        cbCategory = new JComboBox<>(categories);
        cbCategory.setBounds(300, 64, 200, 25);
        contentPane.add(cbCategory);

        JLabel lblType = new JLabel("Book Type:");
        lblType.setBounds(300, 93, 100, 20);
        contentPane.add(lblType);
        
        rbNew = new JRadioButton("New Edition");
        rbNew.setBounds(376, 93, 100, 20);
        rbNew.setBackground(new Color(240, 248, 255));
        contentPane.add(rbNew);
        
        rbOld = new JRadioButton("Old Edition");
        rbOld.setBounds(478, 93, 100, 20);
        rbOld.setBackground(new Color(240, 248, 255));
        contentPane.add(rbOld);
        

        editionGroup = new ButtonGroup();
        editionGroup.add(rbNew);
        editionGroup.add(rbOld);

        JLabel lblIssueDate = new JLabel("Issue Date:");
        lblIssueDate.setBounds(300, 115, 100, 20);
        contentPane.add(lblIssueDate);
        
        txtIssueDate = new JTextField("DD/MM/YYYY");
        txtIssueDate.setBounds(300, 134, 200, 25);
        contentPane.add(txtIssueDate);

        JLabel lblReturnDate = new JLabel("Return Date:");
        lblReturnDate.setBounds(60, 201, 100, 20);
        contentPane.add(lblReturnDate);
        
        txtReturnDate = new JTextField("DD/MM/YYYY");
        txtReturnDate.setBounds(60, 219, 200, 25);
        contentPane.add(txtReturnDate);

        JLabel lblRemarks = new JLabel("Remarks:");
        lblRemarks.setBounds(300, 167, 100, 20);
        contentPane.add(lblRemarks);
        
        txtRemarks = new JTextArea();
        txtRemarks.setBounds(300, 184, 200, 60);
        txtRemarks.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        contentPane.add(txtRemarks);

        JButton btnIssue = new JButton("Issue Book");
        btnIssue.setBounds(60, 274, 95, 30);
        contentPane.add(btnIssue);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(165, 274, 95, 30);
        contentPane.add(btnReset);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(405, 274, 95, 30);
        contentPane.add(btnExit);


        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtName.setText("");
                txtRollNo.setText("");
                txtBookTitle.setText("");
                txtIssueDate.setText("DD/MM/YYYY");
                txtReturnDate.setText("DD/MM/YYYY");
                txtRemarks.setText("");
                cbCategory.setSelectedIndex(0);
                editionGroup.clearSelection();
            }
        });

        btnIssue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = txtName.getText().trim();
                    String roll = txtRollNo.getText().trim();
                    String title = txtBookTitle.getText().trim();
                    
                    if (name.isEmpty() || roll.isEmpty() || title.isEmpty()) {
                        throw new EmptyFieldException("Name, Roll Number, and Book Title fields cannot be empty.");
                    }

                    if (roll.matches(".*[a-zA-Z]+.*")) {
                        throw new InvalidRollNumberException("Roll Number cannot contain alphabets.");
                    }
                    
                    if (roll.length() < 4) {
                        throw new InvalidRollNumberException("Invalid Roll Number format.");
                    }

                    long numericRoll = Long.parseLong(roll); 

                    String message = "Validations passed successfully!\n\n" +
                                     "Name: " + name + "\n" +
                                     "Roll No: " + roll + "\n" +
                                     "Book: " + title;
                    JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);

                } catch (EmptyFieldException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Missing Field", JOptionPane.ERROR_MESSAGE);
                } catch (InvalidRollNumberException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Number Format Error: Roll number must contain only numeric values.", "Format Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}