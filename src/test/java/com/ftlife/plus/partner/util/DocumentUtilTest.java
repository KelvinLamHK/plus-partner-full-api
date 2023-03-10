package com.ftlife.plus.partner.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class DocumentUtilTest {
    DocumentUtil documentUtil = new DocumentUtil();

    @TempDir
    File testDirectory;

    @Test
    void testDocumentUtil () throws IOException {
        assertTrue("Should be a directory ", this.testDirectory.isDirectory());
        var testFile = new File(testDirectory, "test.txt");
        Files.write(testFile.toPath(), "a".getBytes());
        var testFilePath = testFile.getAbsolutePath();
        var file = documentUtil.readDocumentToFileByPathString(testFilePath);
        var base64String = documentUtil.fileToBase64String(file);

        assertEquals(File.class,file.getClass());
        assertEquals(String.class,base64String.getClass());
        assertEquals(ByteArrayInputStream.class,documentUtil.base64StringToInputStream(base64String).getClass());
        assertEquals(String.class,documentUtil.fileFullPathStringToFilePathString(testFilePath).getClass());
        assertEquals(String.class, documentUtil.fileFullPathStringToNameString(testFilePath).getClass());
    }
}
