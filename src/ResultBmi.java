import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


    // TODO: finsh the secound frame (moc).
    // FIXME: Problem with all labels that contains (1) as described below:

public class ResultBmi extends  JFrame implements  ActionListener {

    private JPanel contentPane;
    private JButton buttonCancel;
    private JLabel fullName;
    private JLabel resultBmi;
    private JLabel currentWeight;
    private JLabel idealWeight;
    private JFrame frame;
    private JLabel fullName1;
    private JLabel resultBmi1;
    private JLabel currentWeight1;
    private JLabel idealWeight1;



   public ResultBmi(String name ,String weightStatus, int weight, double myIdealWeight){
       dispose();
       JFrame frame = new JFrame("Result Bmi");
       frame.setLayout(new BorderLayout(20,20));
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setBackground(Color.GRAY);
       frame.setVisible(true);
       frame.setSize(Constants.WIDTH, Constants.HEIGHT);


       fullName = new JLabel("Full Name:");
       fullName.setBounds(20, 0, 200, 80);
       fullName1=new JLabel();
       fullName1.setText(name);
       contentPane = new JPanel();
       frame.add(fullName);



       resultBmi = new JLabel("Result Bmi");
       resultBmi1.setText(weightStatus);
       resultBmi.setBounds(20,0,200,80);
       resultBmi1.setBounds(20,20,200,80);
       frame.add(resultBmi);


       currentWeight = new JLabel("Current Weight");
       currentWeight1.setText(weight + "");
       currentWeight.setBounds(20,0,200,80);
       frame.add(currentWeight);

       this.idealWeight=new JLabel("");
       idealWeight1.setText( myIdealWeight + "");
       idealWeight.setBounds(20,0,200,80);
       frame.add(idealWeight);















       buttonCancel=new JButton("Exit");




       buttonCancel.addActionListener(new ActionListener() {

           public void actionPerformed(ActionEvent e) {
               onCancel();
           }
       });
      // fullName=new JLabel();
       this.fullName.setText(name);
     //  this.fullName1.setText(name);
       this.resultBmi.setText(weightStatus);
       this.currentWeight.setText(weight + "");
       this.idealWeight.setText(idealWeight + "");




       frame.add(buttonCancel,BorderLayout.SOUTH);


   }
    private void onCancel() {
        this.setVisible(false);
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
