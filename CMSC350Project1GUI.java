/**Author: Kevin Abrahams
 * Date: 01-06-2020
 * Description: CMSC350Project1GUI - Provide a class which provides a GUI for converting expressions from prefix to postfix and vice-versa.
 * 				This class relies on several GUI components, like buttons and text fields, to obtain input from the user.
 */
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class CMSC350Project1GUI extends JFrame {
    /**
     * Serial version uid
     */
    private static final long serialVersionUID = -5820045457105785412L;
    // Expression field
    private JTextField expression;
    // Expression label
    private JLabel expressionLabel;
    // Button for postfix to prefix
    private JButton postToPrefixBtn;
    // Button for prefix to postfix
    private JButton prefixToPostfix;
    // Result text field
    private JTextField result;
    // Result label
    private JLabel resultLabel;

    /**
     * Creates new form CMSC350Project1GUI
     */
    public CMSC350Project1GUI() {
        initComponents();
    }

    /**
     * Initialize the components
     *
     */
    private void initComponents() {

        expression = new JTextField();
        postToPrefixBtn = new JButton();
        prefixToPostfix = new JButton();
        expressionLabel = new JLabel();
        resultLabel = new JLabel();
        result = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Expression Evaluator");
        setMinimumSize(new Dimension(490, 300));
        setPreferredSize(new Dimension(490, 300));
        getContentPane().setLayout(null);
        getContentPane().add(expression);
        expression.setBounds(0, 30, 470, 40);

        postToPrefixBtn.setFont(new Font("Arial", 1, 15));
        postToPrefixBtn.setText("Postfix To Prefix");
        // Button action listener
        postToPrefixBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    postToPrefixBtnActionPerformed(evt);
                } catch (SyntaxError e) {
                    JOptionPane.showMessageDialog(CMSC350Project1GUI.this, e.getMessage(), "Error Message",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        getContentPane().add(postToPrefixBtn);
        postToPrefixBtn.setBounds(260, 90, 210, 40);

        prefixToPostfix.setFont(new Font("Arial", 1, 15));
        prefixToPostfix.setText("Prefix To Postfix");
        // Button action listener
        prefixToPostfix.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    prefixToPostfixActionPerformed(evt);
                } catch (SyntaxError e) {
                    JOptionPane.showMessageDialog(CMSC350Project1GUI.this, e.getMessage(), "Error Message",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        getContentPane().add(prefixToPostfix);
        prefixToPostfix.setBounds(0, 90, 210, 40);

        expressionLabel.setFont(new Font("Arial", 1, 15));
        expressionLabel.setText("Expression");
        getContentPane().add(expressionLabel);
        expressionLabel.setBounds(-1, 0, 80, 30);

        resultLabel.setFont(new Font("Arial", 1, 15));
        resultLabel.setText("Result");
        getContentPane().add(resultLabel);
        resultLabel.setBounds(0, 160, 60, 40);
        getContentPane().add(result);
        result.setBounds(60, 170, 410, 30);

        pack();
    }

    /**
     * Action listener for prefix to postfix button
     *
     * @param evt
     * @throws SyntaxError
     */
    private void prefixToPostfixActionPerformed(ActionEvent evt) throws SyntaxError {
        String exp = expression.getText();
        result.setText(ExpressionConverter.prefixToPostfix(exp));
    }

    private void postToPrefixBtnActionPerformed(ActionEvent evt) throws SyntaxError {
        String exp = expression.getText();
        result.setText(ExpressionConverter.postToPrefix(exp));
    }

    /**
     * Main method of the application
     *
     * @param args - Array of command line arguments
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CMSC350Project1GUI.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }

        CMSC350Project1GUI gui = new CMSC350Project1GUI();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }

}
