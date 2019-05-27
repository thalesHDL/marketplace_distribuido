package com.sd.marcketplace.view.util;

import java.nio.file.FileSystems;

public final class FileUtil {
		
	public static String getCurrentPath() {
		String path = FileSystems.getDefault().getPath(".").toAbsolutePath().toString();
		return path.substring(0, path.length());
	}

}
