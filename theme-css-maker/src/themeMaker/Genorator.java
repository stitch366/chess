package themeMaker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Genorator {
	private final File outputDir = new File("C:/ThemeGenoratorOutput");
	private final File baseFile = new File("C:/ThemeGenoratorOutput/base/application.css");
	private ArrayList<String> baseTheme = new ArrayList<String>(0);
	public Genorator()
	{
		getBaseFile();
	}
	private void getBaseFile()
	{
		ArrayList<String> themeFile = new ArrayList<String>(0);
	    FileInputStream fis = null;
	   
	      try {
			fis = new FileInputStream(baseFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line = null;
		  	try {
				while ((line = br.readLine()) != null) {
					themeFile.add(line);
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    this.baseTheme = themeFile;
	}
	public void MakeNewTheme(String themeName)
	{
		String tName = themeName.toLowerCase();
		String FilePath = "C:/ThemeGenoratorOutput/"+tName+".css";
		ArrayList<String> newTheme = ModifyBase(tName);
		File newStylesheet = new File(FilePath);
		if(!outputDir.exists())
		{
			outputDir.mkdir();
		}
		try {
			newStylesheet.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(newStylesheet);
		 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	 
				
			try {
				for (int i = 0; i < newTheme.size(); i++) 
				{
					bw.write(newTheme.get(i));
					bw.newLine();
				}
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
	  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private ArrayList<String> ModifyBase(String newTheme)
	{
		ArrayList<String> themeFile = new ArrayList<String>(0);
		String line;
		for(int x = 0; x < baseTheme.size(); x++)
		{
			line = baseTheme.get(x).replaceAll("/classic/", "/"+newTheme+"/");
			themeFile.add(line);
		}
		
		return themeFile;
	}
}