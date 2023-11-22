import javax.swing.*;
import javax.swing.plaf.ColorChooserUI;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener{

    final private Font MainFont = new Font("SansSerif",Font.BOLD,20);
    JPanel MainPanel, FormPanel, ButtonPanel, rbPannel;
    JLabel lbInput1, lbInput2;
    JTextField tfName, tfAge;
    JButton btnSubmit,btnCheck,btnClear;
    String i1, i2;
    ButtonGroup rbgroup;
    JRadioButton rbMale, rbFemale, rbOthers;
    Person p = new Person();

    public void initialize(){
        lbInput1 = new JLabel("Name");
        lbInput1.setFont(MainFont);

        tfName= new JTextField();
        tfName.setFont(MainFont);

        lbInput2 = new JLabel("Age");
        lbInput2.setFont(MainFont);

        tfAge = new JTextField();
        tfAge.setFont(MainFont);

        //Radio Button
        rbMale = new JRadioButton("Male");
        rbMale.setFont(MainFont);
        rbMale.addActionListener(this);

        rbFemale = new JRadioButton("Female");
        rbFemale.setFont(MainFont);
        rbFemale.addActionListener(this);

        rbOthers = new JRadioButton("Other");
        rbOthers.setFont(MainFont);
        rbOthers.addActionListener(this);

        rbgroup = new ButtonGroup();
        rbgroup.add(rbMale);
        rbgroup.add(rbFemale);
        rbgroup.add(rbOthers);

        rbMale.setOpaque(false);
        rbFemale.setOpaque(false);
        rbOthers.setOpaque(false);

        

        //button
        btnSubmit = new JButton("Submit");
        btnSubmit.setFont(MainFont);
        btnSubmit.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e){
             if(!(tfName.getText().equals("") && tfAge.getText().equals(""))){
                p.setName(tfName.getText());
                p.setAge(tfAge.getText());
                
                JOptionPane.showMessageDialog(MainPanel, "Submitted");
             }
             else if(tfName.getText().equals("") && tfAge.getText().equals("")){
                JOptionPane.showMessageDialog(MainPanel,"No Input");
             }
             
         }
        });
        btnCheck = new JButton("Check");
        btnCheck.setFont(MainFont);
        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(MainPanel,"Name: "+p.getName()+"\nAge: "+p.getAge()+"\nGender: "+p.getGender());
            }
        });

        btnClear = new JButton("Clear");
        btnClear.setFont(MainFont);
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                tfName.setText("");
                tfAge.setText("");
                p.setAge("");
                p.setGender("");
                p.setName("");
            }
        });



       
        //Pannels

        rbPannel = new JPanel();
        rbPannel.setLayout(new GridLayout(1, 3, 5, 5));
        rbPannel.setFocusable(false);
        rbPannel.add(rbMale);
        rbPannel.add(rbFemale);
        rbPannel.add(rbOthers);


        ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new GridLayout(1, 3, 5, 5));
        ButtonPanel.setFocusable(false);
        ButtonPanel.add(btnSubmit);
        ButtonPanel.add(btnCheck);
        ButtonPanel.add(btnClear);

        FormPanel = new JPanel();
        FormPanel.setLayout(new GridLayout(4, 1, 5, 5));
        FormPanel.setFocusable(false);
        FormPanel.add(lbInput1);
        FormPanel.add(tfName);
        FormPanel.add(lbInput2);
        FormPanel.add(tfAge);

        MainPanel = new JPanel();
        MainPanel.setLayout(new BorderLayout());
        MainPanel.setBackground(Color.LIGHT_GRAY);
        MainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        MainPanel.setOpaque(false);
        MainPanel.add(FormPanel, BorderLayout.NORTH);
        MainPanel.add(rbPannel,BorderLayout.CENTER);
        MainPanel.add(ButtonPanel, BorderLayout.SOUTH);

        add(MainPanel);

        setTitle("Duplicate Input Checker");
        setSize(400,400);
        setMinimumSize(new Dimension(200,300));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);


    }

            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==rbMale){
                    p.setGender("Male");
                }
                else if(e.getSource() == rbFemale){
                    p.setGender("Female");
                }
                else if(e.getSource()==rbOthers){
                    p.setGender("Other");
                }

            }

    public static void main(String[]args){
        
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        Main Frame = new Main();
        Frame.initialize();
    }

}