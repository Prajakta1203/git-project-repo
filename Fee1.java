/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fee1;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
  
// Creating the fee class
public class Fee1 extends Frame {
  
    JLabel l1, l2, l3, l4,
        l5, l6, l7, l13,
        l14;
  
    JTextField tf1, tf2, tf3,
        tf4, tf5,
        tf6, tf7;
  
    JTextArea  area1;
 
    /**
     *
     * @return
     */
    public static Connection getConnection(){
        try{
            String databaseUrl = "jdbc:mysql://localhost:3306/register";
            String userName = "root";
            String password = "Praju";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(databaseUrl,userName,password);
            System.out.println("database connected");
            return conn;
        }catch (Exception e)
        {
            System.out.println("some error "+ e);
        }
       return null;
    }
  
    Fee1()
    {
        l1 = new JLabel(
                "Registration");
        l1.setBounds(150,50, 400, 30);
        l1.setSize(150,100);
        l1.setFont(new Font("Verdana", Font.PLAIN, 18));
        l2 = new JLabel(
            "Name of the Student:");
        l2.setBounds(50, 150, 250, 20);
  
        tf1 = new JTextField();
        tf1.setBounds(250, 150, 250, 20);
  
        l3 = new JLabel(
            "Name of the Father:");
        l3.setBounds(50, 200, 250, 20);
  
        tf2 = new JTextField();
        tf2.setBounds(250, 200, 250, 20);
  
        l4 = new JLabel("Roll Number:");
        l4.setBounds(50, 250, 250, 20);
  
        tf3 = new JTextField();
        tf3.setBounds(250, 250, 250, 20);
  
        l5 = new JLabel("Email ID:");
        l5.setBounds(50, 300, 250, 20);
  
        tf4 = new JTextField();
        tf4.setBounds(250, 300, 250, 20);
  
        l6 = new JLabel("Contact Number:");
        l6.setBounds(50, 350, 250, 20);
  
        tf5 = new JTextField();
        tf5.setBounds(250, 350, 250, 20);
  
        l7 = new JLabel("Address:");
        l7.setBounds(50, 400, 250, 20);
  
        area1 = new JTextArea();
        area1.setBounds(250, 400, 250, 90);
  
  
        l13 = new JLabel(
            "Points Secured in 10th:");
        l13.setBounds(60, 500, 250, 20);
  
        tf6 = new JTextField();
        tf6.setBounds(250, 500, 250, 20);
  
        l14 = new JLabel("Percentage in 12th:");
        l14.setBounds(60, 550, 250, 20);
  
        tf7 = new JTextField();
        tf7.setBounds(250, 550, 250, 20);
  
        JButton b = new JButton("Create");
        b.setBounds(200, 700, 150, 30);
        JButton b2 = new JButton("Insert");
        b2.setBounds(350, 700, 150, 30);
        JButton d = new JButton("Delete");
        d.setBounds(450, 700, 150, 30);
        
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l13);
        add(l14);
        add(tf1);
        add(tf2);
        add(tf3);
        add(tf4);
        add(tf5);
        add(tf6);
        add(tf7);
        add(area1);
        add(b);
        add(b2);
        add(d);
  
b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
       {
          try{
              String q = "CREATE TABLE DETAILS(NAME VARCHAR(60) ,NAME_OF_FATHER VARCHAR(60),ROLL_NO INT PRIMARY KEY,EMAIL_ID VARCHAR(60),CONTACT BIGINT,ADDRESS VARCHAR(80),SCORE_10 INT,SCORE_12 INT)";
              Statement sta = getConnection().createStatement();  
              sta.executeUpdate(q);
              System.out.println("table created in database");
                     
          }
          catch(Exception e1)
          {
              System.out.println(e1);
          }
       }
       });
        b2.addActionListener(
            new ActionListener() {
            private Component ADDButton;
                public void actionPerformed(ActionEvent e) {
       
    
             try
            {
            Statement sta = getConnection().createStatement();
            int result = sta.executeUpdate("INSERT INTO DETAILS(NAME,NAME_OF_FATHER,ROLL_NO,EMAIL_ID,CONTACT,ADDRESS,SCORE_10,SCORE_12 )VALUES('"+tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+tf4.getText()+"','"+tf5.getText()+"','"+area1.getText()+"','"+tf6.getText()+"','"+tf7.getText()+"')");
            System.out.println(result);
            JOptionPane.showMessageDialog(ADDButton,"Inserted successfully");
            if(result==1)
            {
                 System.out.println("data inserted");
            }
            else
            {
                 System.out.println("some error");
            }
            
        }catch(Exception e1)
        {
            System.out.println(e1);
        }
        
    
                    
                }
            });
  
        d.addActionListener(
           new ActionListener() {
            private Component ADDButton;
               public void actionPerformed(ActionEvent e)
               {
                   String NAME =  tf1.getText();
                   String NAME_OF_FATHER =  tf2.getText();
                   String ROLL_NO =  tf3.getText();
                   String EMAIL_ID =  tf4.getText();
                   String CONTACT =  tf5.getText();
                   String ADDRESS =  area1.getText();
                   String SCORE_10 =  tf6.getText();
                   String SCORE_12 =  tf7.getText();
                   int roll = Integer.parseInt(ROLL_NO);
               
                  try
                       {
                        Statement sta = getConnection().createStatement();
                        String sql = "DELETE FROM DETAILS WHERE ROLL_NO='"+roll+"';";
                        sta.executeUpdate(sql);
                        JOptionPane.showMessageDialog(ADDButton,"deleted successfully");
                        sta.close();
               }
                  catch(Exception e2){
                      System.out.println(e2);
                  }
               }
         });
    

        addWindowListener(
            new WindowAdapter() {
                public void windowClosing(
                    WindowEvent we)
                {
                    System.exit(0);
                }
            });
        setSize(800, 800);
        setLayout(null);
        setVisible(true);
        setBackground(Color.gray);
    }
    
      
    
    public static void main(String[] args)
    {
         new Fee1();
         getConnection();
    }
}
