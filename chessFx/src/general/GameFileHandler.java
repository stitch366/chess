package general;

import java.io.File;
import java.util.ArrayList;

public class GameFileHandler {
	private final String fileExten = ".txt";
	public ArrayList<String> games = new ArrayList<String>(0);
	public ArrayList<String> fileList = new ArrayList<String>(0);
	
	GameFileHandler()
	{
		File folder = new File("C:/ChessFX/games");
		File[] listOfFiles = folder.listFiles();
		String game;
		for (File file : listOfFiles)
		{
			if (file.isFile()) 
			{
				fileList.add(file.getName());
				game = file.getName().replace(fileExten, "");
				games.add(game);
		    }
		}
	}
	
}
