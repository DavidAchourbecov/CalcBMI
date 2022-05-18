import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CalcBmi  extends JFrame implements ActionListener {


    private JPanel secondContentPanel;
    private JPanel thirdContentPanel;

    private JLabel bodyForm;
    private JLabel currentWright;
    private JLabel currentHeight;


    private JButton buttonSend;
    private JButton buttonCancel;
    private JSlider slider1;
    private JRadioButton smallRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton largeRadioButton;
    private JLabel valueHeight;
    private JSlider slider2;
    private JLabel valueOfWeight;
    private  double slimness;
    private UpperValues upperValues;



    public CalcBmi() {
        JFrame frame = new JFrame("CalcBmi");
         frame.setLayout(new  BorderLayout(10,10));


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.GRAY);



        frame.setVisible(true);
        frame.setSize(Constants.WIDTH, Constants.HEIGHT);
        upperValues=new UpperValues();


        frame.add(upperValues.getFirstContentPanel(),BorderLayout.NORTH);


        buttonSend = new JButton("send");
        buttonCancel = new JButton("Exit");
        thirdContentPanel=new JPanel();
        thirdContentPanel.add(buttonSend);
        thirdContentPanel.add(buttonCancel);
        frame.add(thirdContentPanel,BorderLayout.SOUTH);
        frame.setVisible(true);



        //--------------------------------------------------------------------------------->
        secondContentPanel = new JPanel();
        bodyForm = new JLabel("Body Form:");
        smallRadioButton = new JRadioButton("Small");
        mediumRadioButton = new JRadioButton("Medium");
        largeRadioButton = new JRadioButton("Large");
        bodyForm.setBounds(0,200,10,80);
        smallRadioButton.setBounds(60,220,100,50);
        smallRadioButton.setBackground(Color.white);
        mediumRadioButton.setBounds(60,220,100,50);
        mediumRadioButton.setBackground(Color.white);
        largeRadioButton.setBounds(60,220,100,50);
        largeRadioButton.setBackground(Color.white);
        secondContentPanel.add(bodyForm);
        secondContentPanel.add(smallRadioButton);
        secondContentPanel.add(mediumRadioButton);
        secondContentPanel.add(largeRadioButton);
        secondContentPanel.setBackground(Color.BLUE);
        frame.add(secondContentPanel,BorderLayout.WEST);

        //------------------------------------------------------------------------->
        valueOfWeight = new JLabel("Actual Weight");
        slider1 = new JSlider(40,180);
       // slider1.add(valueOfWeight);
        //valueOfWeight.setBounds(0,100,10,80);
       // slider1.setBounds(5,100,10,80);
        secondContentPanel.add(valueOfWeight);
        secondContentPanel.add(slider1);
        //-------------------------------------------------------------------------------
        valueHeight = new JLabel("Height");
        slider2 = new JSlider(40,140);
        //valueHeight.setBounds(0,100,10,80);
        secondContentPanel.add(valueHeight);
        secondContentPanel.add(slider2);
        //-------------------------------------------------------------------------------




























        smallRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slimness=Constants.SMALL;
                mediumRadioButton.setSelected(false);
                largeRadioButton.setSelected(false);

            }
        });
        mediumRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slimness=Constants.MEDIUM;
                smallRadioButton.setSelected(false);
                largeRadioButton.setSelected(false);

            }
        });
        largeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slimness=Constants.LARGE;
                smallRadioButton.setSelected(false);
                mediumRadioButton.setSelected(false);
            }
        });

        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valueHeight.setText(slider1.getValue() + "cm");

            }
        });

        slider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valueOfWeight.setText(slider2.getValue() + "Kg");

            }
        });





    }


    private void onOK() {

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

//    public double resultOfIdealWeight (){
//        double idealWeight=0;
//        double height=(double)this.slider1.getValue();
//        double age= Double.parseDouble(this.textFieldAge.getText());
//        idealWeight=(height-Constants.HUNDRED + (age/Constants.TEN)) *Constants.SMALL*this.slimness;
//        return idealWeight;
//    }
//
//    public String getName(){
//        return this.textFieldFirstName.getText() + " " + this.textFieldLastName.getText();
//    }

    private double calculateBmi(){
        double height= (double) this.slider1.getValue()/100;
        double weight=(double) this.slider2.getValue();

        return weight/Math.pow(height,2);
    }

    public int getWeight(){

        return this.middleValues.getSlider1W().getValue();

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
         if(e.getSource()==buttonSend){
            this.onOK();
        }
    }
}
