
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
//import java.awt.print.*;

public class ImagePanel extends JPanel //implements Printable
{
	private BufferedImage image;
	
	public ImagePanel()
	{
		super();
		
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(image!=null)
		{
			g.drawImage(image,0,0,this);
		}
	}
	
	public void loadImage(String name)
	{
		Image loadedImage=Toolkit.getDefaultToolkit().getImage(name);
		MediaTracker tracker=new MediaTracker(this);
		tracker.addImage(loadedImage,0);
		try{tracker.waitForID(0);}
		catch(InterruptedException e){}
		image=new BufferedImage(loadedImage.getWidth(null),loadedImage.getHeight(null),BufferedImage.TYPE_INT_RGB);
		Graphics2D g2=image.createGraphics();
		g2.drawImage(loadedImage,0,0,null);
		repaint();
	}
	
	public void filter(BufferedImageOp op)
	{
		BufferedImage filteredImage=new BufferedImage(image.getWidth(),image.getHeight(),image.getType());
		op.filter(image,filteredImage);
		image=filteredImage;
		repaint();
	}
	
	private void convolve(float[] elements)
	{
		Kernel kernel=new Kernel(3,3,elements);
		ConvolveOp op=new ConvolveOp(kernel);
		filter(op);
	}
	
	public void blur()
	{
		if(image==null)
			return;
		
		float weight=1.0f/9.0f;
		float[] elements=new float[9];
		for(int i=0;i<9;i++)
			elements[i]=weight;
		convolve(elements);
	}
	
	public void sharpen()
	{
		if(image==null)
			return;
		
		float[] elements={0.0f,-1.0f,0.0f,-1.0f,5.0f,-1.0f,0.0f,-1.0f,0.0f};
		
		convolve(elements);
	}
	
	public void edgeDetect()
	{
		if(image==null)
			return;
		
		float[] elements={0.0f,-1.0f,0.0f,-1.0f,4.0f,-1.0f,0.0f,-1.0f,0.0f};
		
		convolve(elements);
	}
	
	public void brighten()
	{
		if(image==null)
			return;
		
		float a=1.5f;
		float b=-20.0f;
		RescaleOp op=new RescaleOp(a,b,null);
		filter(op);
	}
	
	public void negative()
	{
		if(image==null)
			return;
		
		byte negative[]=new byte[256];
		for(int i=0;i<256;i++)
			negative[i]=(byte)(255-i);
		ByteLookupTable table=new ByteLookupTable(0,negative);
		LookupOp op=new LookupOp(table,null);
		filter(op);
	}
	
	public void rotate()
	{
		if(image==null)
			return;
		
		AffineTransform transform=AffineTransform.getRotateInstance(Math.toRadians(5),image.getWidth()/2,image.getHeight()/2);
		AffineTransformOp op=new AffineTransformOp(transform,AffineTransformOp.TYPE_BILINEAR);
		filter(op);
	}
	
	public void flip()
	{
		if(image==null)
			return;
		
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
	    tx.translate(-image.getWidth(null), 0);
	    AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		filter(op);
	}
	
	public void effect1()
	{
		if(image==null)
			return;
		
		float weight=1.0f/20.0f;
		float[] elements=new float[9];
		for(int i=0;i<9;i++)
			elements[i]=weight;
		convolve(elements);		
	}
	
	public void effect2()
	{
		if(image==null)
			return;
		
		float weight=10.0f/20.0f;
		float[] elements=new float[15];
		for(int i=0;i<15;i++)
			elements[i]=weight;
		convolve(elements);		

	}
		public void printDocument()
		{
			PrintUtilities.printComponent(this);
		}
	
	public void effect3()
	{
		if(image==null)
			return;
		
		rotate();
		negative();
	}
	
	public void effect4()
	{
		if(image==null)
			return;
		
		byte negative[]=new byte[25];
		for(int i=0;i<25;i++)
			negative[i]=(byte)(24-i);
		ByteLookupTable table=new ByteLookupTable(0,negative);
		LookupOp op=new LookupOp(table,null);
		filter(op);

	}
	
	public void enlarge(){

			    int w = 2 * image.getWidth();
			    int h = 2 * image.getHeight();

			    BufferedImage enlargedImage = new BufferedImage(w, h, image.getType());

			    for (int y = 0; y < h; ++y){
			      for (int x = 0; x < w; ++x){
			        enlargedImage.setRGB(x, y, image.getRGB(x / 2, y / 2));
			      }
			    }
			    image = enlargedImage;
			    repaint();
			   
			  }
	
	
	 public void shrink() {
		    int w = image.getWidth() / 2;
		    int h = image.getHeight() / 2;

		    BufferedImage shrunkImage = new BufferedImage(w, h, image.getType());

		    for (int y = 0; y < h; ++y)
		      for (int x = 0; x < w; ++x)
		        shrunkImage.setRGB(x, y, image.getRGB(x * 2, y * 2));

		    image = shrunkImage;
		    repaint();
		  }
	 
	 public void imageRecognition(String dir , String path) {
		 TestFaceRecognition.fun(dir,path);
	 }
}