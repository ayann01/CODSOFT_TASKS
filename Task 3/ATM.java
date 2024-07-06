import javax.swing.*;
import java.awt.event.*;

public class ATM extends JFrame {
    private BankAccount account;
    private JLabel balanceLabel;
    private JTextField amountField;
    private JTextArea messageArea;

    public ATM(BankAccount account) {
        this.account = account;
        initComponents();
    }

    private void initComponents() {
        setTitle("ATM Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        balanceLabel = new JLabel("Balance: $" + account.getBalance());
        amountField = new JTextField(10);
        messageArea = new JTextArea(5, 30);
        messageArea.setEditable(false);

        JButton checkBalanceButton = new JButton("Check Balance");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");

        checkBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkBalance();
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });

        JPanel panel = new JPanel();
        panel.add(balanceLabel);
        panel.add(new JLabel("Amount: "));
        panel.add(amountField);
        panel.add(checkBalanceButton);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(new JScrollPane(messageArea));

        add(panel);
    }

    private void checkBalance() {
        balanceLabel.setText("Balance: $" + account.getBalance());
        messageArea.setText("Your current balance is: $" + account.getBalance());
    }

    private void deposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            account.deposit(amount);
            balanceLabel.setText("Balance: $" + account.getBalance());
            messageArea.setText("Deposited $" + amount + ". \nNew balance is: $" + account.getBalance());
        } catch (NumberFormatException e) {
            messageArea.setText("Invalid amount entered. Please enter a numeric value.");
        } catch (IllegalArgumentException e) {
            messageArea.setText(e.getMessage());
        }
    }

    private void withdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            account.withdraw(amount);
            balanceLabel.setText("Balance: $" + account.getBalance());
            messageArea.setText("Withdrew $" + amount + ". New balance is: $" + account.getBalance());
        } catch (NumberFormatException e) {
            messageArea.setText("Invalid amount entered. Please enter a numeric value.");
        } catch (IllegalArgumentException e) {
            messageArea.setText(e.getMessage());
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00);
        ATM atm = new ATM(account);
        atm.setVisible(true);
    }
}
