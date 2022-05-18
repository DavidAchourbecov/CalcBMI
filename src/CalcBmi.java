import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CalcBmi  extends JFrame implements ActionListener {



    private JPanel thirdContentPanel;
    private JFrame frame;
    private JButton buttonSend;
    private JButton buttonCancel;


    private UpperValues upperValues;
    private  MiddleValues middleValues;



    public CalcBmi() {
        JFrame frame = new JFrame("CalcBmi");
        frame.setLayout(new  BorderLayout(40,40));
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


        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
       this.addTextFieldsListeners();


    }


    private void onOK() {
       //System.out.println(this.resultOfIdealWeight());
       // this.setVisible(false);
      // ResultBmi ResultBmi= new ResultBmi(this.getName(), this.resultBmi(), this.getWeight(), this.resultOfIdealWeight());
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        dispose();


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
        double height=(double)this.middleValues.getSlider2H().getValue();
        double age= Double.parseDouble(this.upperValues.getTextFieldAge().getText());
        idealWeight=(height-Constants.HUNDRED + (age/Constants.TEN)) *Constants.SMALL*this.middleValues.getSlimness();
        return idealWeight;
   }

    public String getName(){
        return this.upperValues.getTextFieldFirstName().getText() + " " + this.upperValues.getTextFieldLastName().getText();
    }

    private double calculateBmi(){
        double height= (double) this.middleValues.getSlider2H().getValue()/100;
        double weight=(double) this.middleValues.getSlider1W().getValue();

        return weight/Math.pow(height,2);
    }

    public int getWeight(){

        return this.middleValues.getSlider1W().getValue();

    }

    private void onCancel() {
        System.exit(0);
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
         if (e.getSource()==buttonCancel){
             this.onCancel();
         }
    }
}
