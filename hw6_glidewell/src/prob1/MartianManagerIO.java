package prob1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import prob2.*;

public class MartianManagerIO {

	/**
	 *  DO NOT ALTER THIS METHOD.
	 */
	public static void writeMartians(String fileName, MartianManager mm) {
		File file = new File(fileName);
        try {
			writeMartiansFile(file, mm);
		}
        catch (FileNotFoundException e) {
			System.out.println("Error writing file");
			e.printStackTrace();
		}
	}
	
	/**
	 *  YOU  WRITE THIS METHOD.
	 *  
	 *  Write the martians in the MartianManager to the file. The format is exactly the same
	 *  as specified in the homework document for reading valid data: G I V or R I V T.
	 */
	private static void writeMartiansFile(File file, MartianManager mm) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(file);
		for(int i=0; i<mm.getNumMartians(); i++) {
			Martian m = mm.getMartianAt(i);
			if(m instanceof GreenMartian) {
				writer.println("G " + m.getId() + " " + m.getVolume());
			}
			if(m instanceof RedMartian) {
				RedMartian v = (RedMartian)m;
				writer.println("R " + v.getId() + " " + v.getVolume() + " " + v.getTenacity());
			}
		}
		writer.close();
	}

	/**
	 *  DO NOT ALTER THIS METHOD.
	 */
	public static ReadReport readMartians(String fileName) {
		File file = new File(fileName);
		ReadReport report = null;
        try {
			report = readMartiansFile(file);
		}
        catch (FileNotFoundException e) {
			System.out.println("Error reading file");
			e.printStackTrace();
		}
		return report;
	}
	
	/**
	 * YOU WRITE THIS METHOD.
	 * 
	 * Reads a text file that contains Martian data and returns a ReadReport object. Details
	 * are in the homework document. 
	 * 
	 * @param file
	 * @return
	 * @throws RuntimeException
	 * @throws FileNotFoundException
	 */
	private static ReadReport readMartiansFile(File file) throws RuntimeException, FileNotFoundException {
		int numLinesRead = 0;
		int numSuccessfullyAdded = 0;
		int numAlreadyExist = 0;
		int numIllFormed = 0;
		String fileName = file.getName();
		MartianManager mm = new MartianManager();
		try {
		Scanner input = new Scanner(file);
		while(input.hasNext()){
			String line = input.nextLine();
			String[] tokens = line.split("\\s");
			if(!(tokens[0].equals("G") || tokens[0].equals("R"))) {
				numIllFormed += 1;
				continue;
			}
			if(tokens[0].equals("G")) {
				if(!(tokens.length == 3)) {
					numIllFormed += 1;
					continue;
				}
				if(checkNumbers(tokens)) {
					int x = Integer.parseInt(tokens[1]);
					int y = Integer.parseInt(tokens[2]);
					GreenMartian g = new GreenMartian(x,y);
					if(mm.addMartian(g)) {
						numSuccessfullyAdded += 1;
					}
					else {
						numAlreadyExist += 1; 
					}
				}
				else {
					numIllFormed += 1;
					continue;
				}
			}
			if(tokens[0].equals("R")) {
				if(!(tokens.length == 4)) {
					numIllFormed += 1;
					continue;
				}
				if(checkNumbers(tokens)) {
					int x = Integer.parseInt(tokens[1]);
					int y = Integer.parseInt(tokens[2]);
					int z = Integer.parseInt(tokens[3]);
					RedMartian g = new RedMartian(x,y, z);
					if(mm.addMartian(g)) {
						numSuccessfullyAdded += 1;
					}
					else {
						numAlreadyExist += 1; 
					}
				}
				else {
					numIllFormed += 1;
					continue;
				}
			}
		}
		input.close();
	}
		catch(FileNotFoundException e) {
			System.out.print(e);			
		}
		numLinesRead += numSuccessfullyAdded + numAlreadyExist + numIllFormed;
		ReadReport report = new ReadReport(mm, fileName, numLinesRead,numSuccessfullyAdded,numAlreadyExist,
										numIllFormed);
		return report;
	}
	
	//--------------
	// Helper Methods
	//--------------
		
	public static boolean isInteger(String str) {
		try {
			int x = Integer.parseInt(str);
			return true;
		}
		catch(NumberFormatException nfe) {
			return false;
			}
		}
	
	public static boolean checkNumbers(String[] tokens) {
		for(int i =1; i<tokens.length; i++) {
			if(!(isInteger(tokens[i]))) {
				return false;
			}
		}
		return true;
	}
	
	

}
