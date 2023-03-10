package com.ftlife.plus.partner.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftlife.plus.partner.configuration.LogConfig;
import com.ftlife.plus.partner.parameter.ApiLogParameter;
import com.ftlife.plus.partner.parameter.RequestParameter;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

    private static String POST = "POST";
    private static String GET = "GET";
    private static String CONTENT_TYPE_URLENCODED = "application/x-www-form-urlencoded";
    private static String CONTENT_TYPE_JSON = "application/json";

    private String httpRequest(String method, String contentType, String urlStr, String paras) throws IOException {
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder content = new StringBuilder();
        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("accept", "*/*");
        con.setRequestProperty("connection", "Keep-Alive");
        con.setRequestProperty("Content-Type", contentType);
        con.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        con.setConnectTimeout(10000);
        con.setReadTimeout(10000);
        con.setRequestMethod(method);

        if (paras != null && !paras.isEmpty()) {
            con.setDoOutput(true);
            out = new PrintWriter(new OutputStreamWriter(con.getOutputStream(), "UTF-8"));
            out.print(paras);
            out.flush();
        }

        in = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        if (out != null) {
            out.close();
        }
            in.close();

        return content.toString();
    }

    /**
     * GET
     *
     * @param url
     * @param paras
     * @return
     */
    public String httpGetRequest(String url, String paras) throws IOException{
        return httpRequest(GET, CONTENT_TYPE_URLENCODED, url, paras);
    }

    /**
     * POST
     *
     * @param url
     * @param paras
     * @return
     */
    public String httpPostRequest(String url, String paras) throws IOException{
        return httpRequest(POST, CONTENT_TYPE_JSON, url, paras);
    }

    /**
     * inputStream
     *
     * @param request
     * @return
     */
    public String parseRequest(HttpServletRequest request) throws IOException {
        StringBuilder buffer = new StringBuilder();

        InputStream in = request.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        String line = "";
        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }
        br.close();
        in.close();
        return buffer.toString();
    }

    public String logResponseRequest(HttpServletRequest httpServletRequest, RequestParameter requestParameter, LogConfig logConfig, Object responseObject, Object errorObject) throws IOException {
        var objectMapper = new ObjectMapper();
        var apiLogParameter = new ApiLogParameter();
        apiLogParameter.setRequestUrl(httpServletRequest.getRequestURI());
        apiLogParameter.setIpAddress(httpServletRequest.getRemoteAddr());
        apiLogParameter.setApplication(logConfig.getApplicationName());
        apiLogParameter.setCreatedBy("partner-plus");
        apiLogParameter.setRequestBody(objectMapper.writeValueAsString(requestParameter));
        apiLogParameter.setResponse(objectMapper.writeValueAsString(responseObject));
        apiLogParameter.setError(objectMapper.writeValueAsString(errorObject));
        return httpPostRequest(logConfig.getLogUrl(), objectMapper.writeValueAsString(apiLogParameter));

    }
}