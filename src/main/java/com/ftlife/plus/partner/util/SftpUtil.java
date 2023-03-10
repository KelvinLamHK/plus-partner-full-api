package com.ftlife.plus.partner.util;
import com.ftlife.plus.partner.configuration.SFTPConfig;
import com.jcraft.jsch.*;
import org.apache.commons.io.IOUtils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class SftpUtil {
    private ChannelSftp setupJsch(SFTPConfig sftpConfig) throws JSchException {
        JSch jsch = new JSch();
        java.util.Properties config = new java.util.Properties();
        Session jschSession = jsch.getSession(sftpConfig.getUsername(),sftpConfig.getDestination(),Integer.parseInt(sftpConfig.getPort()));
        jschSession.setPassword(sftpConfig.getPassword());
        jschSession.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
        config.put("StrictHostKeyChecking", "no");
        jschSession.setConfig(config);
        jschSession.connect();
        return (ChannelSftp) jschSession.openChannel("sftp");
    }

    public void uploadDocument(SFTPConfig sftpConfig, String base64FileString, String fileFullPathString) throws JSchException, SftpException {
        ChannelSftp channelSftp = setupJsch(sftpConfig);
        channelSftp.connect();
        DocumentUtil documentUtil = new DocumentUtil();
        createFolder(fileFullPathString, channelSftp);
        InputStream inputStream = documentUtil.base64StringToInputStream(base64FileString);
        channelSftp.put(inputStream, documentUtil.fileFullPathStringToNameString(fileFullPathString));
        channelSftp.exit();
    }

    private void createFolder (String fileFullPathString, ChannelSftp channelSftp) throws SftpException {

        DocumentUtil documentUtil = new DocumentUtil();
        String filePathString = documentUtil.fileFullPathStringToFilePathString(fileFullPathString);
        String[] folders = filePathString.split( "/|\\\\" );
        for ( String folder : folders ) {
            if ( folder.length() > 0 ) {
                try {
                    channelSftp.cd( folder );
                }
                catch ( SftpException e ) {
                    channelSftp.mkdir( folder );
                    channelSftp.cd( folder );
                }
            }
        }
    }

    public String downloadDocument (SFTPConfig sftpConfig, String documentFullPath) throws JSchException, SftpException, IOException {
        ChannelSftp channelSftp = setupJsch(sftpConfig);
        channelSftp.connect();
        InputStream inputStream = channelSftp.get(documentFullPath);
        byte[] sourceBytes = IOUtils.toByteArray(inputStream);
        String encodedString = Base64.getEncoder().encodeToString(sourceBytes);
        channelSftp.exit();
        return encodedString;
    }


}
