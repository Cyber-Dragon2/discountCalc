import javax.swing.*; //importing swing package
import java.awt.*; //importing awt package
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class learning implements ActionListener {
    JFrame jf;
    JButton btn, reset;
    JLabel finalPriceResult, savedPriceResult, percentSign, creator;
    JTextField percentinp;
    JTextField numinp;

    public learning() {
        jf = new JFrame("Discount Calculator"); // Creating a JFrame with name MyWindow
        creator = new JLabel("Created by: Amritpal Singh");
        creator.setFont(new Font("sans-serif", Font.BOLD, 14));
        creator.setBounds(195, 305, 200, 50);
        Image icon = Toolkit.getDefaultToolkit().getImage("./assets/icon.png");
        jf.setIconImage(icon);
        btn = new JButton("Calculate");// Creating a Button named Say Hello
        btn.setBounds(205, 280, 130, 35);
        btn.setFont(new Font("sans-serif", Font.BOLD, 18));
        btn.addActionListener(this);
        reset = new JButton("Reset");// Creating a Button named Say Hello
        reset.setBounds(55, 280, 130, 35);
        reset.setFont(new Font("sans-serif", Font.BOLD, 18));
        reset.addActionListener(this);
        JLabel numlabel = new JLabel("Total Price : ");
        numlabel.setFont(new Font("sans-serif", Font.PLAIN, 22));
        numlabel.setBounds(20, 10, 150, 50);
        JLabel percentlabel = new JLabel("Discount : ");
        percentlabel.setFont(new Font("sans-serif", Font.PLAIN, 22));
        percentlabel.setBounds(20, 80, 150, 50);
        numinp = new JTextField();
        numinp.setFont(new Font("sans-serif", Font.PLAIN, 25));
        numinp.setToolTipText("Enter the price of your product");
        numinp.setBounds(180, 15, 180, 35);
        percentSign = new JLabel("%");
        percentSign.setFont(new Font("sans-serif", Font.PLAIN, 25));
        percentSign.setBounds(340, 85, 30, 35);
        percentinp = new JTextField();
        percentinp.setToolTipText("Enter the Discount %age product is having");
        percentinp.setFont(new Font("sans-serif", Font.PLAIN, 25));
        percentinp.setBounds(180, 85, 160, 35);
        finalPriceResult = new JLabel("You pay");
        finalPriceResult.setFont(new Font("sans-serif", Font.PLAIN, 33));
        finalPriceResult.setBackground(Color.gray);
        finalPriceResult.setForeground(Color.white);
        finalPriceResult.setOpaque(true);
        finalPriceResult.setVerticalAlignment(SwingConstants.CENTER);
        finalPriceResult.setHorizontalAlignment(SwingConstants.CENTER);
        finalPriceResult.setBounds(4, 138, 376, 60);
        savedPriceResult = new JLabel("You save");
        savedPriceResult.setFont(new Font("sans-serif", Font.PLAIN, 33));
        savedPriceResult.setBackground(Color.gray);
        savedPriceResult.setForeground(Color.white);
        savedPriceResult.setOpaque(true);
        savedPriceResult.setVerticalAlignment(SwingConstants.CENTER);
        savedPriceResult.setHorizontalAlignment(SwingConstants.CENTER);
        savedPriceResult.setBounds(4, 202, 376, 60);

        jf.add(btn); // adding button to frame
        jf.add(numlabel);
        jf.add(percentlabel);
        jf.add(numinp);
        jf.add(percentSign);
        jf.add(percentinp);
        jf.add(finalPriceResult);
        jf.add(savedPriceResult);
        jf.add(reset);
        jf.add(creator);

        jf.setLayout(null); // setting layout using FlowLayout object
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // setting close operation.
        jf.setSize(400, 385); // setting size
        jf.setVisible(true); // setting frame visibility
        jf.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object see = e.getSource();

        if (see == (btn)) { // Checking if the object returned is of btn
            if (numinp.getText().length() == 0 || percentinp.getText().length() == 0) {
                changeResultsText("Enter", "something!");
            } else {
                try {
                    int price = Integer.parseInt(numinp.getText());
                    float percentval = Float.parseFloat(percentinp.getText());
                    if (percentval > 100 || percentval < 0) {
                        changeResultsText("Discount percentage is", "Invalid, Try Again!");
                    } else {
                        float saved = ((percentval / 100) * price);
                        float finalPrice = price - saved;
                        changeResultsText(String.format("%.2f", finalPrice), String.format("%.2f", saved));
                        resetInputs();
                    }

                } catch (Exception excep) {
                    changeResultsText("Input Values can only", "be number, Try Again!");
                }
            }
        } else if (see == (reset)) {
            resetInputs();
            changeResultsText("You pay", "You Save");
        }
    }

    public void changeResultsText(String s1, String s2) {
        finalPriceResult.setText(s1);
        savedPriceResult.setText(s2);
    }

    public void resetInputs() {
        numinp.setText("");
        percentinp.setText("");
    }

    public static void main(String[] args) {
        new learning();
    }
}