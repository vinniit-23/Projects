import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
class DigitalClock extends JFrame{
	JLabel l1,l2,l3,l4;
	SimpleDateFormat d1,d2;
	DigitalClock(String s1){
		super(s1);
	}
	DigitalClock(){}
	void setComponents(){
		l1 = new JLabel();
		l2 = new JLabel();
		l3 = new JLabel("Time:");
		l3.setFont(new Font("Verdana",Font.BOLD,40));
		l4 = new JLabel("Date:");
		l1.setFont(new Font("Verdana",Font.BOLD,40));
		Color c1 = Color.RED;
		Color c2 = c1.brighter();
		l1.setForeground(c2);
		l1.setBackground(Color.BLACK);
		l1.setOpaque(true);
		l2.setForeground(c2);
		l2.setBackground(Color.BLACK);
		l2.setOpaque(true);
		l2.setFont(new Font("Verdana",Font.BOLD,40));
		l3.setForeground(c2);
		l3.setBackground(Color.BLACK);
		l3.setOpaque(true);
		l4.setForeground(c2);
		l4.setBackground(Color.BLACK);
		l4.setOpaque(true);
		l4.setFont(new Font("Verdana",Font.BOLD,40));

		setLayout(null);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		l1.setBounds(100,200,300,100);
		l2.setBounds(100,400,300,100);
		l3.setBounds(100,100,300,100);
		l4.setBounds(100,300,300,100);
		d1=new SimpleDateFormat("hh:mm:ss a");
		d2=new SimpleDateFormat("dd/MM/yyyy");

		String time = d1.format(Calendar.getInstance().getTime());
		String date = d2.format(Calendar.getInstance().getTime());
		l1.setText(time);
		l2.setText(date);

		while(true){
			time = d1.format(Calendar.getInstance().getTime());
			date = d2.format(Calendar.getInstance().getTime());
			l1.setText(time);
			l2.setText(date);
			try{
				Thread.sleep(1000);
			}
			catch(Exception e){}
			
		}
	}
public static void main(String[] args){
	DigitalClock d1 = new DigitalClock("Digital Clock");
	d1.getContentPane().setBackground(Color.black);
	d1.setVisible(true);
	d1.setSize(600,600);
	d1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	d1.setComponents();
	


}
}