import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {

    final private Font MainFont = new Font("SansSerif", Font.BOLD,20);
    JPanel MainPanel, FormPanel, ButtonPanel;
    JButton btnSubmit, btnShow, btnClear;
    JLabel lbName, lbAge, lbGender;
    JTextField tfName, tfAge, tfGender;
    Person p = new Person();


    public void initialize(){
        /*********** LABEL ***********/  
        lbName = new JLabel("Name");
        lbName.setFont(MainFont);
        lbName.setForeground(Color.WHITE);
 
        tfName = new JTextField();
        tfName.setFont(MainFont);
 
        lbAge = new JLabel("Age");
        lbAge.setFont(MainFont);
        lbAge.setForeground(Color.WHITE);
 
        tfAge = new JTextField();
        tfAge.setFont(MainFont);
 
        lbGender = new JLabel("Gender");
        lbGender.setFont(MainFont);
        lbGender.setForeground(Color.WHITE);
 
        tfGender = new JTextField();
        tfGender.setFont(MainFont);
 
        
        /*********** BUTTONS *********/

        btnSubmit = new JButton("Submit");
        btnSubmit.setFont(MainFont);
        btnSubmit.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e){
             if(!(tfName.getText().equals("") && tfAge.getText().equals("") && tfGender.getText().equals(""))){
                p.setName(tfName.getText());
                p.setAge(tfAge.getText());
                p.setGender(tfGender.getText());
                JOptionPane.showMessageDialog(MainPanel, "Submitted");
             }
             else if(tfName.getText().equals("") && tfAge.getText().equals("") && tfGender.getText().equals("")){
                JOptionPane.showMessageDialog(MainPanel,"No Input");
             }
             
         }
        });
 
        btnShow = new JButton("Show");
        btnShow.setFont(MainFont);
        btnShow.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(MainPanel, "Name: "+p.getName()+"\nAge: "+p.getAge()+"\nGender: " +p.getGender());
            
         }
        });

        btnClear = new JButton("Clear");
        btnClear.setFont(MainFont);
        btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                tfName.setText("");
                tfAge.setText("");
                tfGender.setText("");
            }
        });
 
       /*********** PANNELS *********/

       ButtonPanel = new JPanel();
       ButtonPanel.setLayout(new GridLayout(3,1,5,5));
       ButtonPanel.add(btnSubmit);
       ButtonPanel.add(btnShow);
       ButtonPanel.add(btnClear);
       ButtonPanel.setOpaque(false);
       
       FormPanel = new JPanel();
       FormPanel.setLayout(new GridLayout(10,1,5,5));
       FormPanel.add(lbName);
       FormPanel.add(tfName);
       FormPanel.add(lbAge);
       FormPanel.add(tfAge);
       FormPanel.add(lbGender);
       FormPanel.add(tfGender);
       FormPanel.setOpaque(false);

       MainPanel = new JPanel();
       MainPanel.setLayout(new BorderLayout());
       MainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
       MainPanel.setBackground(Color.BLACK);
       MainPanel.add(FormPanel, BorderLayout.CENTER);
       MainPanel.add(ButtonPanel, BorderLayout.SOUTH);

        
        setTitle("Person Profile");
        add(MainPanel);
        setSize(400,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        
        

    }

    public static void main(String[]args){
        GUI Frame = new GUI();
        Frame.initialize();
    }

}