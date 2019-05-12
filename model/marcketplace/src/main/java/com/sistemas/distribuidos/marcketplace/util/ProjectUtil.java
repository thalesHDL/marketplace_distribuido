package com.sistemas.distribuidos.marcketplace.util;


import java.io.File;
import java.io.IOException;


public final class ProjectUtil  {

	public static String getDbFilePath() {
		try {
			File currentDirFile = new File(".");
			String dbFilePath = currentDirFile.getCanonicalPath().concat("/src/resources/db/");
			return dbFilePath;
		} catch (IOException e) {
			// TODO generate catch block
			System.out.println("Error initializing stream");
			return "";
		}
		
	}

}