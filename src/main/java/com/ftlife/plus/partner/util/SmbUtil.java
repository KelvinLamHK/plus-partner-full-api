package com.ftlife.plus.partner.util;

import com.ftlife.plus.partner.configuration.SMBConfig;
import com.hierynomus.msdtyp.AccessMask;
import com.hierynomus.mssmb2.SMB2CreateDisposition;
import com.hierynomus.mssmb2.SMB2ShareAccess;
import com.hierynomus.smbj.SMBClient;
import com.hierynomus.smbj.SmbConfig;
import com.hierynomus.smbj.auth.AuthenticationContext;
import com.hierynomus.smbj.connection.Connection;
import com.hierynomus.smbj.session.Session;
import com.hierynomus.smbj.share.DiskShare;
import com.hierynomus.smbj.share.File;
import org.apache.commons.io.IOUtils;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.EnumSet;
import java.util.List;

public class SmbUtil {

    public static DiskShare getDiskShare(SMBConfig smbConfig) throws IOException {
        SmbConfig smbConfiguration = SmbConfig.builder().build();
        SMBClient smbClient = new SMBClient(smbConfiguration);

        Connection connection = smbClient.connect(smbConfig.getHost());
        AuthenticationContext authenticationContext = new AuthenticationContext(smbConfig.getUsername(), smbConfig.getPassword().toCharArray(), smbConfig.getDomain());
        Session session = connection.authenticate(authenticationContext);

        return (DiskShare) session.connectShare(smbConfig.getShare());
    }


    public static void uploadDocument(DiskShare diskShare, String base64FileString, String fileFullPathString) throws IOException {
        createFolders(diskShare, fileFullPathString);

        byte[] fileBytes = Base64.getDecoder().decode(base64FileString);
        try (InputStream inputStream = new ByteArrayInputStream(fileBytes);
             File remoteFile = diskShare.openFile(fileFullPathString, EnumSet.of(AccessMask.GENERIC_WRITE), null, SMB2ShareAccess.ALL, SMB2CreateDisposition.FILE_OVERWRITE_IF, null)) {
            IOUtils.copy(inputStream, remoteFile.getOutputStream());
        }
    }

    private static void createFolders(DiskShare diskShare, String fileFullPathString) {
        String[] folders = fileFullPathString.split("/|\\\\");
        StringBuilder currentPath = new StringBuilder();

        for (String folder : folders) {
            if (folder.length() > 0) {
                currentPath.append(folder).append("\\");
                if (!diskShare.folderExists(currentPath.toString())) {
                    diskShare.mkdir(currentPath.toString());
                }
            }
        }
    }

    public static String downloadDocument(DiskShare diskShare, String documentFullPath) throws IOException {
        try (File remoteFile = diskShare.openFile(documentFullPath, EnumSet.of(AccessMask.GENERIC_READ), null, SMB2ShareAccess.ALL, SMB2CreateDisposition.FILE_OPEN, null);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            IOUtils.copy(remoteFile.getInputStream(), outputStream);
            byte[] fileBytes = outputStream.toByteArray();
            return Base64.getEncoder().encodeToString(fileBytes);
        }
    }
}