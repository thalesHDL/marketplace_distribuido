package com.sistemas.distribuidos.marcketplace.util;


import com.sistemas.distribuidos.marcketplace.util.enumerate.StatusAction;
import com.sistemas.distribuidos.marcketplace.exception.PersistenceExeception;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.util.List;
import java.util.ArrayList;


public final class FileUtil {

	public static void writeBinaryFile(String path, Object obj) {
		try {
			File file = new File(path);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objOutputStream = new ObjectOutputStream(fileOutputStream);

			// Write objects to file
			objOutputStream.writeObject(obj);

			objOutputStream.close();
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
	}
	public static void writeBinaryFile(String path, List<Object> listObj) {
		for(Object obj : listObj) {
			writeBinaryFile(path, obj);
		}
	}

	public static List<Object> readBinaryFile(String path) {
		try {
			File file = new File(path);
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objInputStream = new ObjectInputStream(fileInputStream);

			// Read objects from file
			List<Object> contentFile = new ArrayList<>();
			boolean loop = true;
			while(loop) {
				Object obj = objInputStream.readObject();
				if (fileInputStream.available() != 0) {
					contentFile.add(obj);
				} else {
					loop = false;
				}
			}

			objInputStream.close();
			fileInputStream.close();

			return contentFile;
		} catch(ClassNotFoundException e) {
			System.out.println("Class not found");
			return new ArrayList<>();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return new ArrayList<>();
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			return new ArrayList<>();
		}

	}

}