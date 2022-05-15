import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalcBmi  extends JFrame implements ActionListener {

    private JPanel firstContentPanel;
    private JPanel secondContentPanel;
    private JPanel thirdContentPanel;
    private JLabel firstName;
    private JLabel lastName;
    private JLabel age;
    private JLabel gender;
    private JLabel bodyForm;
    private JLabel currentWright;
    private JLabel currentHeight;


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
    private JLabel valueOfWeight;
    private  double slimness;



    public CalcBmi(){
        JFrame frame = new JFrame("CalcBmi");
         frame.setLayout(new  BorderLayout(10,10));
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
        frame.add(firstContentPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.GRAY);

        frame.setVisible(true);
        frame.setSize(Constants.WIDTH, Constants.HEIGHT);


        //-------------------------------------------------------------------------------
        lastName = new JLabel("Last Name:");
        textFieldLastName = new JTextField();
        lastName.setBounds(20, -20, 200, 200);
        textFieldLastName.setBounds(90, 70, 70, 20);
        firstContentPanel.setBounds(0, 10, 58033, 600);
        firstContentPanel.add(lastName);
        firstContentPanel.add(textFieldLastName);
        firstContentPanel.setPreferredSize(new Dimension(100,100));
        JPanel jPanel=new JPanel();
        jPanel.setPreferredSize(new Dimension(50,50));

        frame.add(firstContentPanel,BorderLayout.EAST);
        //-----------------------------------------------------------------------------------
        age = new JLabel("Age:");
        textFieldAge = new JTextField();
        age.setBounds(20, 10, 200, 200);
        textFieldAge.setBounds(55, 100, 70, 20);
        firstContentPanel.add(age);
        firstContentPanel.add(textFieldAge);
        //---------------------------------------------------------------------------------}
        gender=new JLabel("Gender:");
        manRadioButton=new JRadioButton("Man");
        womanRadioButton=new JRadioButton("Woman");
        gender.setBounds(5,185,100,80);
        manRadioButton.setBounds(60,200,100,50);
        manRadioButton.setBackground(Color.white);
        womanRadioButton.setBounds(160,200,100,50);
        womanRadioButton.setBackground(Color.white);
        firstContentPanel.add(gender);
        firstContentPanel.add(manRadioButton);
        firstContentPanel.add(womanRadioButton);
        //--------------------------------------------------------------------------------->
        bodyForm = new JLabel("Body Form:");



    }


    private void onOK() {
        System.out.println(this.textFieldFirstName.getText() + " " + this.textFieldLastName.getText());
        this.setVisible(false);
       // ResultBmi ResultBmi= new ResultBmi(this.getName(), this.resultBmi(), this.getWeight(), this.resultOfIdealWeight());
    }
    public String resultBmi(){
        double bmi =calculateBmi();
        String result="";

        if (bmi<=15){
            result=Constants.ANOREXIC;

        }else if (bmi>15 && bmi<18.5){
            result=Constants.UNDERWEIGHT;
        }else if (bmi>18.5 && bmi<24.9){
            result=Constants.NORMAL;

        }else if (bmi> 25 && bmi < 29.9){
            result=Constants.OVERWEIGHT;

        }else if (bmi > 30 && bmi < 35 ){
            result=Constants.OBESE;

        }else if (bmi >= 35){
            result = Constants.EXTREME_OBESE;
        }

        return result;
    }

    public double resultOfIdealWeight (){
        double idealWeight=0;
        double height=(double)this.slider1.getValue();
        double age= Double.parseDouble(this.textFieldAge.getText());
        idealWeight=(height-Constants.HUNDRED + (age/Constants.TEN)) *Constants.SMALL*this.slimness;
        return idealWeight;
    }

    public String getName(){
        return this.textFieldFirstName.getText() + " " + this.textFieldLastName.getText();
    }

    private double calculateBmi(){
        double height= (double) this.slider1.getValue()/100;
        double weight=(double) this.slider2.getValue();

        return weight/Math.pow(height,2);
    }

    public int getWeight(){
        return this.slider2.getValue();

    }


    private void onCancel() {

        this.setVisible(false);
    }

    private  void addTextFieldsListeners(){
        buttonSend.addMouseListener(new  MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getSource()==buttonSend) {
                    try {
                        Thread.sleep(10);
                        onOK();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }

                }
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
