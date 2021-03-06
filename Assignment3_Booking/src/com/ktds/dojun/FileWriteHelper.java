package com.ktds.dojun;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriteHelper {

	private static final String LOG_FOLDER_PATH = "./BookSaves";
	private static final String LOG_FILE_PATH = LOG_FOLDER_PATH + "./bookListFile.txt";

	// 사용자에게 사용할것만 쓰게 가이드 하는 샘

	public static void log(String message) {

		// d:\\logs 폴더를 생성한다.

		makeLogsFolder();

		// d:\\logs\\Calculator.log 파일을 생성한다.

		makeCalculatorLogFile();

		// d:\\logs\\Calculator.log 파일에 message를 기록한다.

		writeLog(message);

	}

	public static void makeLogsFolder() {
		File logsFolder = new File(LOG_FOLDER_PATH);
		if (!logsFolder.exists() || !logsFolder.isDirectory()) {

			logsFolder.mkdirs();
		}

	}

	public static void makeCalculatorLogFile() {
		File logFile = new File(LOG_FILE_PATH);

		if (!logFile.exists() || !logFile.isFile()) {

			try {

				logFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void deleteLogFile() {
		
	    {
	    	try{

	    		File file = new File(LOG_FILE_PATH);

	    		if(file.delete()){
	    			System.out.println(file.getName() + " is deleted!\n");
	    		}else{
	    			System.out.println("Delete operation is failed.\n");
	    		}

	    	}catch(Exception e){

	    		e.printStackTrace();

	    	}}}
	
	

	public static void writeLog(String message) {

		try {

			FileWriter fw = new FileWriter(LOG_FILE_PATH, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);

			out.println(message);
			out.flush();
			
			out.close();
			bw.close();
			fw.close();
            
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
