package vn.edu.vinaenter.util;

import org.apache.commons.io.FilenameUtils;

public class FileUtil {
	public static String rename(String fileName) {
		if(!"".equals(fileName)) {
			return FilenameUtils.getBaseName(fileName) + "-" + System.nanoTime() + "." + FilenameUtils.getExtension(fileName);
		}
		return fileName;
	}
}
