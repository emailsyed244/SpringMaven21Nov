package test.nov21.common;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class FileActions {
	protected static final Logger LOG = org.slf4j.LoggerFactory.getLogger(FileActions.class);
	
	public File findFile(String fileName, String folderPath) throws IOException {
		File dir = new File(folderPath);
		List<File> files = (List<File>) FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, null);
        for (File file : files) {
            if (file.getName().contains(fileName)) {
                return file;
            }
        }
        return null;
    }

	public File findFile(String fileName, String extension, String folderPath) throws IOException {
		File dir = new File(folderPath);
		List<File> files = (List<File>) FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, null);
		for (File file : files) {
			if (file.getName().contains(fileName) && file.getName().contains(extension)) {
				return file;
			}
		}
		return null;
	}

	public void deleteFile(File fileToDelete) {
		if (fileToDelete != null && fileToDelete.exists()) {
			fileToDelete.delete();
		} else {
			LOG.info("Specified file does not exist");
		}
	}

}
