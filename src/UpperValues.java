import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UpperValues  extends  JFrame implements ActionListener {
    private JPanel firstContentPanel;
    private JPanel secondContentPanel;
    private JPanel thirdContentPanel;
    private JLabel firstName;
    private JLabel lastName;
    private JLabel age;
    private JLabel gender;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldAge;
    private JRadioButton manRadioButton;
    private JRadioButton womanRadioButton;

    public UpperValues() {
        firstName = new JLabel("First Name:");
        textFieldFirstName = new JTextField();
        firstName.setBounds(20, 0, 200, 80);
        textFieldFirstName.setBounds(90, 30, 70, 20);
        firstContentPanel = new JPanel();
        firstContentPanel.setLayout(null);
        firstContentPanel.setBounds(10, 10, 580, 200);
        firstContentPanel.add(firstName);
        firstContentPanel.add(textFieldFirstName);
        firstContentPanel.setBackground(Color.white);



        //-------------------------------------------------------------------------------
        lastName = new JLabel("Last Name:");
        textFieldLastName = new JTextField();
        lastName.setBounds(170, -60, 200, 200);
        textFieldLastName.setBounds(240, 30, 70, 20);
        firstContentPanel.setBounds(0, 10, 58033, 600);
        firstContentPanel.add(lastName);
        firstContentPanel.add(textFieldLastName);
        firstContentPanel.setPreferredSize(new Dimension(200,200));


        //-----------------------------------------------------------------------------------
        age = new JLabel("Age:");
        textFieldAge = new JTextField();
        age.setBounds(330, -60, 200, 200);
        textFieldAge.setBounds(360, 30, 70, 20);
        firstContentPanel.add(age);
        firstContentPanel.add(textFieldAge);
        //---------------------------------------------------------------------------------}
        gender=new JLabel("Gender:");
        manRadioButton=new JRadioButton("Man");
        womanRadioButton=new JRadioButton("Woman");
        gender.setBounds(35,40,100,80);
        manRadioButton.setBounds(120,55,100,50);
        manRadioButton.setBackground(Color.white);
        womanRadioButton.setBounds(220,55,100,50);
        womanRadioButton.setBackground(Color.white);
        firstContentPanel.add(gender);
        firstContentPanel.add(manRadioButton);
        firstContentPanel.add(womanRadioButton);
        //firstContentPanel.setPreferredSize(new Dimension(2));
        //---------------------------------------------------------------------------

        manRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                womanRadioButton.setSelected(false);
            }
        });
        womanRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manRadioButton.setSelected(false);
            }
        });

        textFieldFirstName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);


            }
        });
    }

    public JPanel getFirstContentPanel() {
        return firstContentPanel;
    }

    public void setFirstContentPanel(JPanel firstContentPanel) {
        this.firstContentPanel = firstContentPanel;
    }

    public JTextField getTextFieldFirstName() {
        return textFieldFirstName;
    }

    public void setTextFieldFirstName(JTextField textFieldFirstName) {
        this.textFieldFirstName = textFieldFirstName;
    }

    public JTextField getTextFieldLastName() {
        return textFieldLastName;
    }

    public void setTextFieldLastName(JTextField textFieldLastName) {
        this.textFieldLastName = textFieldLastName;
    }

    public JTextField getTextFieldAge() {
        return textFieldAge;
    }

    public void setTextFieldAge(JTextField textFieldAge) {
        this.textFieldAge = textFieldAge;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
