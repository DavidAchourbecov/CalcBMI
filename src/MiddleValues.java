import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MiddleValues extends JFrame implements ActionListener {
    private JPanel secondContentPanel;
    private JPanel thirdContentPanel;




    private JLabel bodyForm;
    private JLabel currentWeight;
    private JLabel currentHeight;



    private JSlider slider1W;
    private JRadioButton smallRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton largeRadioButton;
    private JLabel valueHeight;
    private JSlider slider2H;
    private JLabel valueOfWeight;
    private  double slimness;


    public  MiddleValues(){
        secondContentPanel = new JPanel();
        secondContentPanel.setBounds(10,50,580,200);
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
        //secondContentPanel.setBackground(Color.BLUE);
        //secondContentPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 25));

        //------------------------------------------------------------------------->
        currentWeight = new JLabel("Actual Weight:");
        slider1W = new JSlider(0,300);
        slider1W.setValue(0);
        valueOfWeight=new JLabel();
        // slider1.add(valueOfWeight);
        currentWeight.setBounds(10,100,10,80);
        // slider1.setBounds(5,100,10,80);
        secondContentPanel.add(currentWeight);
        secondContentPanel.add(slider1W);
         secondContentPanel.add(valueOfWeight);

        //-------------------------------------------------------------------------------
        currentHeight = new JLabel("Height:");
        slider2H = new JSlider(140,190);
        slider2H.setValue(140);
        valueHeight= new JLabel();
        currentHeight.setBounds(10,80,10,80);
        secondContentPanel.add(currentHeight);
        secondContentPanel.add(slider2H);
        secondContentPanel.add(valueHeight);
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

        slider1W.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valueOfWeight.setText(slider1W.getValue() + "KG");

            }
        });

        slider2H.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valueHeight.setText(slider2H.getValue() + "CM");

            }
        });

    }

    public JPanel getSecondContentPanel() {
        return secondContentPanel;
    }

    public void setSecondContentPanel(JPanel secondContentPanel) {
        this.secondContentPanel = secondContentPanel;
    }

    public double getSlimness() {
        return slimness;
    }

    public void setSlimness(double slimness) {
        this.slimness = slimness;
    }

    public JSlider getSlider1W() {
        return slider1W;
    }

    public JSlider getSlider2H() {
        return slider2H;
    }

    public void actionPerformed(ActionEvent e) {

    }

}


