package com.sistemas.distribuidos.marcketplace.util;


import com.sistemas.distribuidos.marcketplace.util.enumerate.StatusAction;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


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
			// TODO generate catch block
			System.out.println("File not found");
		} catch (IOException e) {
			// TODO generate catch block
			System.out.println("Error initializing stream");
		}

	}

	public static void writeBinaryFile(String path, List<Object> listObj) {
		for(Object obj : listObj) {
			writeBinaryFile(path, obj);
		}
	}

	// TODO: implement a function to read binary file (readBinaryFile)

}