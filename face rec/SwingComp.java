

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class SwingComp
{
	public SwingComp()
	{
		System.out.println("Cannot create object");
	}

	public static void main(String args[])
		{
			ImageProcessor frm=new ImageProcessor();
			frm.show();
		}
	
	public static JMenuItem createMenuItems(JMenu mnu,ActionListener listener, String text)
	{
		JMenuItem mi=new JMenuItem(text);
		mi.addActionListener(listener);
		mnu.add(mi);
		return mi;
	}
	
	public static JMenuItem createMenuItems(JMenu mnu,ActionListener listener, String text, String actionCommand)
	{
		JMenuItem mi=new JMenuItem(text);
		mi.addActionListener(listener);
		mi.setActionCommand(actionCommand);
		mnu.add(mi);
		return mi;
	}
	
	public static JMenu createMenu(JMenuBar mBar,String text)
	{
		JMenu mnu=new JMenu(text);
		mBar.add(mnu);
		
		return mnu;
	}
	
	public static JMenu createMenu(JMenu mnuParent,String text)
	{
		JMenu mnu=new JMenu(text);
		mnuParent.add(mnu);
		return mnu;
	}
	public static JToolBar createToolBar()
	{
				JToolBar tb=new JToolBar();
				JButton b1=new JButton();
				b1.setIcon(new ImageIcon("open.gif"));
				/*b1.addMouseListener(new MouseAdapter()
				{
					public final void mouseEntered(MouseEvent ae)
					{
						b1.setToolTipText("Save");
						
					}
				});*/
				tb.add(b1);
				
				JButton b2=new JButton();
				b2.setIcon(new ImageIcon("save.gif"));
				/*b1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{
						//JFileChooser fc=new JFileChooser();
						//showOpenDialog(this);
											
					}
				});*/
				tb.add(b2);
				
				JButton b3=new JButton();
				b3.setIcon(new ImageIcon("slide.gif"));
				tb.add(b3);
				
				JButton b4=new JButton();
				b4.setIcon(new ImageIcon("info.gif"));
				tb.add(b4);
				
				JButton b5=new JButton();
				b5.setIcon(new ImageIcon("help.gif"));
				tb.add(b5);
				
				/*JButton b6=new JButton();
				b6.setIcon(new ImageIcon(".gif"));
				tb.add(b6);
				
				JButton b7=new JButton();
				b7.setIcon(new ImageIcon(".gif"));
				tb.add(b7);*/
				return tb;
	}
		
}
	
