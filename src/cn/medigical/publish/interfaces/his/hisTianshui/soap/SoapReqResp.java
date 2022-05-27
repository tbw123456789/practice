package cn.medigical.publish.interfaces.his.hisTianshui.soap;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class SoapReqResp {
    public Logger logger = Logger.getLogger("SoapReqResp");
    private static final String URLSTRING = "http://192.168.80.40:8099/Service.asmx";

    public String getSoapRequest() {
        StringBuffer sb = new StringBuffer();

        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n  <soap12:Body>\n      " +
                getSoapReqXml() + "\n" + "  </soap12:Body>\n" + "</soap12:Envelope>");

        return sb.toString();
    }

    public abstract String getSoapReqXml();

    public abstract void parseXML(String paramString);

    public abstract String getXmlStartStr();

    public String[] getCheckItemStr() {
        return null;
    }

    public String reqRespData() {
        String xml = getSoapRequest();

        String urlString = "http://192.168.80.40:8099/Service.asmx";

        HttpURLConnection httpConn = null;

        OutputStream out = null;
        String returnXml = "";
        BufferedReader reader;
        try {
            httpConn = (HttpURLConnection) new URL(urlString).openConnection();

            httpConn.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            httpConn.connect();
            out = httpConn.getOutputStream();
            httpConn.getOutputStream().write(xml.getBytes());
            out.flush();
            out.close();

            int code = httpConn.getResponseCode();
            String tempString = null;
            StringBuffer sb1 = new StringBuffer();

            if (code == 200) {
                reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
                while ((tempString = reader.readLine()) != null) {
                    sb1.append(tempString);
                }

                if (null != reader)
                    reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(httpConn.getErrorStream(), "UTF-8"));

                while ((tempString = reader.readLine()) != null) {
                    sb1.append(tempString);
                }
                if (null != reader) {
                    reader.close();
                }
            }

            returnXml = sb1.toString();
        } catch (Exception e) {
            this.logger.info(e.getMessage());
        }





        returnXml = returnXml.replace("&gt;", ">").replace("&lt;", "<");
        returnXml = returnXml.replace("<![CDATA[","").replace("]]>","");
        String xmlStartStr = getXmlStartStr();
        try {
            int xmlStartIndex = returnXml.indexOf("<" + xmlStartStr + ">") + ("<" + xmlStartStr + ">").length();
            int xmlEndIndex = returnXml.lastIndexOf("</" + xmlStartStr + ">");
            returnXml = returnXml.substring(xmlStartIndex, xmlEndIndex);
        } catch (Exception e) {
            return null;
        }
        String[] checkItems = getCheckItemStr();
        if (null != checkItems) {
            int index = 0;
            while (index != -1) {
                for (String checkItem : checkItems) {
                    int itemStartIndex = returnXml.indexOf("<" + checkItem + ">", index);
                    if (itemStartIndex == -1) {
                        index = -1;
                        break;
                    }
                    int itemEndIndex = returnXml.indexOf("</" + checkItem + ">", itemStartIndex);
                    String itemStr = returnXml.substring(itemStartIndex + ("<" + checkItem + ">").length(), itemEndIndex);
                    if ((itemStr.contains("<")) || (itemStr.contains(">"))) {
                        String itemStrNew = itemStr.replace("<", "&lt;").replace(">", "&gt;");
                        returnXml = returnXml.replace(itemStr, itemStrNew);
                    }
                    index = itemEndIndex;
                }
            }
        }
        parseXML(returnXml);

        return returnXml;
    }
}

