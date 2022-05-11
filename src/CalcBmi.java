import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalcBmi  extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JButton buttonSend;
    private JButton buttonCancel;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldAge;
    private JRadioButton manRadioButton;
    private JRadioButton womanRadioButton;
    private JSlider slider1;
    private JRadioButton smallRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton largeRadioButton;
    private JLabel valueHeight;
    private JSlider slider2;
    private JLabel valueOfWeigt;
    private  double slimness;

    public CalcBmi(){
        JFrame frame = new JFrame("CalcBmi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(Constants.WIDTH,Constants.HEIGHT);
        JButton jButton=new JButton("send");
        jButton.setBounds(80,20,200,20);
        JPanel J=new JPanel();
        J.add(jButton);
        frame.add(J);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
