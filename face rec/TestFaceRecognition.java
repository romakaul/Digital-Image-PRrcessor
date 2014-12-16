
import java.lang.*;
import java.io.*;



public class TestFaceRecognition  
{	public static void fun(String dir,String file)
	{	try 
		{        EigenFaceCreator creator = new EigenFaceCreator();
        //creator.USE_CACHE = -1;
		        System.out.println("Constructing face-spaces from "+dir+"...");
        		creator.readFaceBundles(dir);
        		System.out.println("Comparing "+file+" ...");
        		String result = creator.checkAgainst(file);
        		System.out.println("Most closly reseambling: "+result+" with "+creator.DISTANCE+" distance.");
      		} 
		catch (Exception e) { e.printStackTrace(); }
    	}

    	public static void main(String args[]) 
	{

        String dir = "c:\\1";//args[0];
        String file = "c:\\nav.jpg";//args[1];

	fun(dir,file);      
	}
}

