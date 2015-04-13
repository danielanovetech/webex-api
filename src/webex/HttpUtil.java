package webex;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;

/**
 * Created by bonjan on 2015/4/1.
 */
public class HttpUtil {

    private static String xmlServerURL = "";

    /**
     * @param reqXML
     * @return xml String response
     */
    public static String sendXmlRequest(String reqXML) {

        String respXML = "";

        // connect to XML server
        URL urlXMLServer = null;
        URLConnection urlConnectionXMLServer = null;

        try {
            urlXMLServer = new URL(xmlServerURL);
            urlConnectionXMLServer = urlXMLServer.openConnection();
            urlConnectionXMLServer.setRequestProperty("Content-Type", "application/xml; charset=utf-8");
            urlConnectionXMLServer.setDoOutput(true);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // send request
        PrintWriter out = null;
        try {
            assert urlConnectionXMLServer != null;
            out = new PrintWriter(urlConnectionXMLServer.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert out != null;
        out.println(reqXML);
        out.close();

        // read response
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(urlConnectionXMLServer.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String line;
        assert in != null;
        try {
            while ((line = in.readLine()) != null) {
                respXML += line;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // output response
        try {
            respXML = URLDecoder.decode(respXML, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return respXML;
    }

    public static String getXmlServerURL() {
        return xmlServerURL;
    }

    public static void setXmlServerURL(String xmlServerURL) {
        HttpUtil.xmlServerURL = xmlServerURL;
    }
}
