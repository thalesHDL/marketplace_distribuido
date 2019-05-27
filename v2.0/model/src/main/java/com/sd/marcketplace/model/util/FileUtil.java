package com.sd.marcketplace.model.util;

import java.nio.file.FileSystems;

public final class FileUtil {
	
	public static String getPath() {
		String path = FileSystems.getDefault().getPath(".").toAbsolutePath().toString();
		return path.substring(0, path.length()-1);
	}

}
