package findWord;

import java.io.File;
import java.util.Scanner;

public class FindWord {

	public static void main(String[] args) throws Exception {

		if (args.length == 0) {
			System.out.println("Type path.");
			return;
		}

		String word = "import";

		File file = new File(args[0]);

		if (file.isFile()) {
			findWord(file, word);
		} else if (file.isDirectory()) {
			scanDirectory(file, word);
		}

	}

	private static void scanDirectory(File file, String word) throws Exception {
		File[] files = file.listFiles();

		for (File file2 : files) {
			if (file2.isFile()) {
				findWord(file2, word);
			} else if (file2.isDirectory()) {
				scanDirectory(file2, word);
			}
		}

	}

	private static void findWord(File file, String word) throws Exception {
		Scanner scanner = new Scanner(file);
		String lineStr;
		int lineNum = 0;

		while (scanner.hasNextLine()) {
			lineNum++;
			lineStr = scanner.nextLine();
			if (lineStr.contains(word)) {
				System.out.println("Found! at [" + file.getAbsolutePath() + ":"
						+ lineNum + "]");
			}

		}

		scanner.close();

	}

}
