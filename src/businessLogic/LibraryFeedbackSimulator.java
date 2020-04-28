package businessLogic;

import java.io.File;

public class LibraryFeedbackSimulator {
	
	public void LibraryFeedBackSimulator() {
	}
	
	public File askForBookFile(String code) {
		File bookInfo = new File("Resources/SimulatorBooks/"+code+"txt");
		return bookInfo;
	}
}
