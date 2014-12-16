
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class InfoFrame extends JFrame
{
	
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	Container c;
	InfoFrame()
	{
		setLayout(new GridLayout(7,2));
		c=getContentPane();
		l1=new JLabel("File Name");
		l2=new JLabel("Directory Name");		
		l3=new JLabel("Full Path");
		l4=new JLabel("File Size");
		l5=new JLabel("Resolution");
		l6=new JLabel("Print Size");
		l7=new JLabel("Compression");
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		t5=new JTextField(20);
		t6=new JTextField(20);
		t7=new JTextField(20);
		t1.setEnabled(true);
		t1.setText(ImageProcessor.path);
		System.out.println(ImageProcessor.path);
		t2.setEnabled(true);
		t3.setEnabled(true);
		t4.setEnabled(true);
		t5.setEnabled(true);
		t6.setEnabled(true);
		t7.setEnabled(true);
		c.add(l1);c.add(t1);
		c.add(l2);c.add(t2);
		c.add(l3);c.add(t3);
		c.add(l4);c.add(t4);
		c.add(l5);c.add(t5);
		c.add(l6);c.add(t6);
		c.add(l7);c.add(t7);
		pack();
		setVisible(true);
	}
	public static void main(String args[])
	{
		InfoFrame f=new InfoFrame();
	}}