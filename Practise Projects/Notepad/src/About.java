import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {
    About(){
        setBounds(400,100,600,500);
        setLayout(null);

        ImageIcon notepadIcon = new ImageIcon(ClassLoader.getSystemResource("icons/notepad.png"));
        Image icon = notepadIcon.getImage();
        setIconImage(icon);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/windows.png"));
        Image i2 = i1.getImage().getScaledInstance(300,60,Image.SCALE_DEFAULT);
        JLabel headIcons = new JLabel(new ImageIcon(i2));
        headIcons.setBounds(70,40,400,80);
        add(headIcons);

       ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/notepad.png"));
        Image i4 = i3.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        JLabel icons = new JLabel(new ImageIcon(i4));
        icons.setBounds(50,180,70,70);
        add(icons);

        JLabel text = new JLabel("<html>Made by vinit<br> version 0.1.(OS Build for java)<br>vinit: All rights are reserved</html>");
        text.setBounds(150,100,500,300);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN,16));
        add(text);

        JButton b1 = new JButton("OK");
        b1.addActionListener(this);
        b1.setBounds(150,350,120,25);
        add(b1);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new About();
    }
}
