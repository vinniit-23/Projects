import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.*;

class LoginS2 extends JFrame {
    JLabel l1, l2, l3,l4,l5;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;

    LoginS2(String s1) {
        super(s1);
    }

    void setComponents() {
 Cursor c1 =new Cursor(Cursor.HAND_CURSOR);
 Cursor c2 =new Cursor(Cursor.WAIT_CURSOR);
 Font f1 = new Font("Arial", Font.BOLD, 20);
 Font f2 = new Font("Arial", Font.BOLD, 15);
        setTitle("Login Form");
        setResizable(false);
        setBackground(Color.LIGHT_GRAY);
        setForeground(Color.BLACK);
        setFont(new Font("Arial", Font.BOLD, 20));

     //ImageIcon i1 = new ImageIcon("C:/Users/pande/OneDrive/Pictures/Camera Roll/WhatsApp Image 2025-04-05 at 00.16.46_25d5e8d1.jpg");      


        l1 = new JLabel("Welcome");
        l2 = new JLabel("Username:");
        l3 = new JLabel("Password:");
        l4 = new JLabel();
       // l5 = new JLabel();
        t1 = new JTextField();
        t2 = new JPasswordField();
        b1 = new JButton("Login");
        b2 = new JButton("Clear");


        //l5.setIcon(i1);


        setLayout(null);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        //add(l5);
        add(t1);
        add(t2);
        add(b1);
        add(b2); 

        l1.setBounds(300, 90, 300, 30);
        l1.setFont(f1);
        l1.setForeground(Color.black);
        l1.setBackground(Color.white);
        l2.setFont(f2);
        l3.setFont(f2);
        l2.setBounds(100, 200, 100, 30);
        l3.setBounds(100, 350, 100, 30);
        l4.setBounds(100, 550, 200, 30);
        //l5.setBounds(200, 10, 150, 150);
        t1.setBounds(350, 200, 100, 30);
        t2.setBounds(350, 350, 100, 30);
        b1.setBounds(200, 450, 100, 30);
        b2.setBounds(400, 450, 100, 30);
        b1.addActionListener(new Log());
        b2.addActionListener(new Clear());
        t1.setCursor(c1);
        t2.setCursor(c1);
        b1.setCursor(c1);
        b2.setCursor(c1);
        b1.setForeground(Color.GREEN);
        b1.setBackground(Color.black);
        b2.setForeground(Color.GREEN);
        b2.setBackground(Color.black);
        t1.setBackground(Color.black);
        t1.setBackground(Color.white);
        t2.setBackground(Color.black);
        t2.setBackground(Color.white);
        b1.addMouseListener(new ML1());
        b2.addMouseListener(new ML2());
       
        
    }

    public static void main(String[] args) {
        LoginS2 frame = new LoginS2("Login Form");
       frame.getContentPane().setBackground(Color.white);

        frame.setVisible(true);
        frame.setSize(700, 700);
        frame.setComponents();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    class Log implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s1 = t1.getText();
            String s2 = new String(t2.getPassword());
            if (s1.equals("admin") && s2.equals("admin")) {
                l4.setText("Login Successful");
                JOptionPane.showMessageDialog(null, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                String s3 = "Welcome " + s1;
                JOptionPane.showMessageDialog(null, s3, "Welcome", JOptionPane.INFORMATION_MESSAGE);
                String name =JOptionPane.showInputDialog("Enter your name:");
                JOptionPane.showMessageDialog(null, "Hello " + name + ", Welcome to the application!", "Greeting", JOptionPane.INFORMATION_MESSAGE);
                // Proceed to the next step of your application here
            } else {
                l4.setText("Invalid Username or Password");
             JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Alert", JOptionPane.ERROR_MESSAGE);
            /**
             * Prompts the user to enter their name using a dialog box.
             * 
             * This method uses `JOptionPane.showInputDialog` to display a dialog box
             * where the user can input their name as a string. The entered name is
             * then stored in the variable `name`.
             *
             * Note:
             * - Ensure that the `javax.swing.JOptionPane` class is imported to use this method.
             * - The dialog box will block further execution until the user provides input or closes the dialog.
             */
             String name =JOptionPane.showInputDialog("Enter your name:");
            }
        }

    }
    class Clear implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e1) {
            t1.setText("");
            t2.setText("");
            l4.setText("");
        JOptionPane.showMessageDialog(null, "cleared Successful", "clear", JOptionPane.INFORMATION_MESSAGE);

        }

    }
    class ML1 implements MouseListener{
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            b2.setBackground(Color.black);
            
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
           
        b1.setBackground(Color.white);

            
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub

            b1.setBackground(Color.black);
        }
    }
    class ML2 implements MouseListener{
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            b2.setBackground(Color.black);
            
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
    
        b2.setBackground(Color.white);

            
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub

            b2.setBackground(Color.black);
        }
    }
}
