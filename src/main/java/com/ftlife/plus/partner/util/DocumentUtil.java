package com.ftlife.plus.partner.util;

import org.apache.commons.io.FileUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Base64;

public class DocumentUtil {

    public File readDocumentToFileByPathString (String pathString){
        return new File(pathString);
    }

    public String fileToBase64String (File file) throws IOException {
        var fileContent = FileUtils.readFileToByteArray(file);
        return Base64.getEncoder().encodeToString(fileContent);
    }

    public InputStream base64StringToInputStream (String base64String) {
        var decodedBytes = Base64.getDecoder().decode(base64String);
        return new ByteArrayInputStream(decodedBytes);
    }

    public String fileFullPathStringToFilePathString (String fileFullPathString){
        var fileFullPath = Paths.get(fileFullPathString);
        return  fileFullPath.getParent().toString();
    }

    public String fileFullPathStringToNameString (String fileFullPathString){
        var fileFullPath = Paths.get(fileFullPathString);
        return fileFullPath.getFileName().toString();
    }

}
