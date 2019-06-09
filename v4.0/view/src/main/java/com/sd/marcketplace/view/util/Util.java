package com.sd.marcketplace.view.util;

import java.nio.file.FileSystems;

public final class Util {
	
	public static String getCurrentWorkDir() {
		String absolutePath = FileSystems.getDefault().getPath(".").toAbsolutePath().toString();
		return absolutePath.substring(0, absolutePath.length()-1);
	}

}
