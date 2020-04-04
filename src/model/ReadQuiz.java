package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadQuiz {
	private Scanner input;
	private String filename = "WEB-INF/quiz.txt";

	// enable user to open file
	public void openFile() {
		try {
			//input = new Scanner(new File(filename), "utf-8");
			input = new Scanner(new File("./web/WEB-INF/quiz.txt"), "utf-8");
		} // end try
		catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Error opening file.");
			System.exit(1);
		} // end catch
	} // end method openFile

	// read quiz from file
	public void readQuestions() {
		// Quiz quiz;
		int count = 0;

		try
		// read records from file using Scanner object
		{
			while (input.hasNextLine()) {
				StringTokenizer tokens = new StringTokenizer(input.nextLine());
				++count;
				// quiz = new Quiz (count);
				if (tokens.hasMoreTokens()) {
					String token = tokens.nextToken();
					System.out.println("Question-" + count + ": " + token);
					// quiz.setQuestion( token );
					// quiz.setAnswer(1);
				}
				while (tokens.hasMoreTokens()) {
					String token = tokens.nextToken();
					token = token.replace("-", " ");
					// quiz.addOption( token );
					System.out.println("Option: " + token);
				}
			} // end while
		} // end try
		catch (IllegalStateException stateException) {
			System.err.println("Error reading from file.");
			System.exit(1);
		} // end catch
	} // end method readRecords

	// close file and terminate application
	public void closeFile() {
		if (input != null)
			input.close(); // close file
	} // end method closeFile

	public static void main(String args[]) {
		ReadQuiz rq = new ReadQuiz();
		rq.openFile();
		rq.readQuestions();
		rq.closeFile();
	} // end main
} // end class ReadTextFile
