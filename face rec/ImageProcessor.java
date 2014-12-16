
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

public class ImageProcessor extends JFrame

{
/**
	 * 
	 */
	private static final long serialVersionUID = -5104599651080142768L;


public static String path;
public static String dir = "c:\\1";
	
		
	private ImagePanel panel;
	private JMenuItem openItem,print1,saveItem,exitItem,blurItem,sharpenItem,
						brightenItem,edgeDetectItem,negativeItem,rotateItem,effect1,effect2,
							effect3,effect4,about,info,reset,flip , enlarge ,shrink ,imageRecognition;
	private JScrollPane scrollPane=null;
	private Container contentPane;
	
	private JToolBar tb;
	String filename;
	
	public ImageProcessor()
	{
		System.out.println("HI ROMA U R MAD");
		setTitle("Image Processing System");
		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});
		contentPane=getContentPane();
		panel=new ImagePanel();
//		panel.loadImage("113.gif");
		scrollPane= new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
		this.add(scrollPane);
		JMenuBar menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu=SwingComp.createMenu(menuBar,"File");
		JMenu effectsMenu=SwingComp.createMenu(menuBar,"Effects");
		JMenu otherEffects=SwingComp.createMenu(menuBar,"Other Effects");
		JMenu helpMenu=SwingComp.createMenu(menuBar,"Help");	
		
		MenuHandler mnHandler=new MenuHandler();
		openItem=SwingComp.createMenuItems(fileMenu,mnHandler,"Open");
		saveItem=SwingComp.createMenuItems(fileMenu,mnHandler,"Save");
		print1=SwingComp.createMenuItems(fileMenu,mnHandler,"Print");
		reset = SwingComp.createMenuItems(fileMenu,mnHandler,"Reset");
		exitItem=SwingComp.createMenuItems(fileMenu,mnHandler,"Exit");
		blurItem=SwingComp.createMenuItems(effectsMenu,mnHandler,"Blur");
		sharpenItem=SwingComp.createMenuItems(effectsMenu,mnHandler,"Sharpen");
		brightenItem=SwingComp.createMenuItems(effectsMenu,mnHandler,"Brighten");
		edgeDetectItem=SwingComp.createMenuItems(effectsMenu,mnHandler,"Edge Detect");
		negativeItem=SwingComp.createMenuItems(effectsMenu,mnHandler,"Negative");
		flip=SwingComp.createMenuItems(effectsMenu,mnHandler,"Flip");
		enlarge=SwingComp.createMenuItems(effectsMenu,mnHandler,"Enlarge");
		shrink=SwingComp.createMenuItems(effectsMenu,mnHandler,"Shrink");
		rotateItem=SwingComp.createMenuItems(effectsMenu,mnHandler,"Rotate");
		imageRecognition=SwingComp.createMenuItems(effectsMenu,mnHandler,"Image Recognition");
		effect1=SwingComp.createMenuItems(otherEffects,mnHandler,"Effect1");
		effect2=SwingComp.createMenuItems(otherEffects,mnHandler,"Effect2");
		effect3=SwingComp.createMenuItems(otherEffects,mnHandler,"Effect3");
		effect4=SwingComp.createMenuItems(otherEffects,mnHandler,"Effect4");
		about=SwingComp.createMenuItems(helpMenu,mnHandler,"About");
		info=SwingComp.createMenuItems(helpMenu,mnHandler,"Information");
		tb=SwingComp.createToolBar();
		
		contentPane.add(tb,"North");
		
		
		this.setMDISize();
	}
		
	private void setMDISize()
		{
			Toolkit tk=Toolkit.getDefaultToolkit();
			Dimension d=tk.getScreenSize();
			int screenHeight=d.height;
			int screenWidth=d.width;
			this.setSize(screenWidth,screenHeight);
		}
		
	private class MenuHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			Object source=evt.getSource();
			if(source==openItem)
			{
				JFileChooser chooser=new JFileChooser();
				chooser.setCurrentDirectory(new File("."));
				chooser.setFileFilter(new javax.swing.filechooser.FileFilter()
				{
					public boolean accept(File f)
					{
						String name=f.getName().toLowerCase();
						return name.endsWith(".gif")||name.endsWith(".jpg")||name.endsWith(".jpeg")||f.isDirectory();
					}
					
					public String getDescription()
					{
						return "Images";
					}
				});
				
				int r=chooser.showOpenDialog(ImageProcessor.this);
				if(r==JFileChooser.APPROVE_OPTION)
				{
					filename=chooser.getSelectedFile().getAbsolutePath();
					path=filename;
					//dir = chooser.getSelectedFile().getParent();
					panel.loadImage(filename);
					
				}
			}
			else if(source==saveItem)
			{
				/*BufferedImage bi;
				String format="jpg";
				try
				{
					bi= ImageIO.read(new File("bld.jpg"));
				}
				catch(Exception ex)
				{
				}*/
				 File saveFile = new File("savedimage");
            	JFileChooser chooser = new JFileChooser();
             	chooser.setSelectedFile(saveFile);
             	int rval = chooser.showSaveDialog(ImageProcessor.this);
             	if (rval == JFileChooser.APPROVE_OPTION) {
                 	saveFile = chooser.getSelectedFile();
                 /* Write the filtered image in the selected format,
                  * to the file chosen by the user.
                  */
                /* try {
                     ImageIO.write(bi, format, saveFile);
                 } catch (IOException ex) {
                 }*/
             }
				
				
			}
			else if(source==exitItem)
					System.exit(0);
			else if(source==blurItem)
					panel.blur();
			else if(source==sharpenItem)
					panel.sharpen();
			else if(source==brightenItem)
					panel.brighten();
			else if(source==edgeDetectItem)
					panel.edgeDetect();		
			else if(source==negativeItem)
					panel.negative();
			else if(source==rotateItem)
					panel.rotate();
			else if(source==imageRecognition)
				panel.imageRecognition(dir,path);
			else if(source==effect1)
					panel.effect1();
			else if(source==effect2)
					panel.effect2();
			else if(source==effect3)
					panel.effect3();
			else if(source==effect4)
					panel.effect4();
			else if(source==about)
			{
				String message="Presented by : Roma Kaul";
				JOptionPane.showMessageDialog(ImageProcessor.this,message,"Information",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(source==info)
			{
				InfoFrame f=new InfoFrame();
			}
			else if(source==print1)
					panel.printDocument();
			
			else if(source == reset){
				panel.loadImage(path);
			}
			else if(source == flip){
				panel.flip();
			}
			else if(source == enlarge){
				panel.enlarge();
			}
			else if(source == shrink){
				panel.shrink();
			}
		}
		
		
	}
}