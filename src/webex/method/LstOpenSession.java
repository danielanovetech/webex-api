package webex.method;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import webex.HttpUtil;
import webex.ob.OpenSession;
import webex.WebExUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by bonjan on 2015/4/8.
 */
public class LstOpenSession {

    /**
     * @return null if receive unexpected exception
     */
    public static List<OpenSession> getTrainingSessions() {
        Document sessionsDocument = (Document) WebExUtil.getBaseDocument().cloneNode(true);

        /**
         * Parent is <body></body>
         */
        Element bodyContent = sessionsDocument.createElement("bodyContent");
        bodyContent.setAttribute("xsi:type", "java:com.webex.service.binding.ep.LstOpenSession");
        sessionsDocument.getElementsByTagName("body").item(0).appendChild(bodyContent);

        /**
         * Parent is <bodyContent></bodyContent>
         */
        Element serviceType = sessionsDocument.createElement("serviceType");
        serviceType.setTextContent("TrainingCenter");
        bodyContent.appendChild(serviceType);

        return parseFromResponse(HttpUtil.sendXmlRequest(WebExUtil.xmlToString(sessionsDocument)));
    }

    /**
     * @param respXml
     * @return null if receive unexpected exception
     */
    public static List<OpenSession> parseFromResponse(String respXml) {
        Document doc = WebExUtil.stringToXml(respXml);

        assert doc != null;
        Element result = (Element)doc.getElementsByTagName("serv:result").item(0);
        NodeList nodes = doc.getElementsByTagName("ep:sessions");
        if("SUCCESS".equals(result.getTextContent())) {
            List<OpenSession> openSessions = new ArrayList<OpenSession>();
            for (int i = 0; i < nodes.getLength(); i++) {
                OpenSession openSession = new OpenSession();
                openSession.setSessionKey(((Element) nodes.item(i))
                        .getElementsByTagName("ep:sessionKey").item(0).getTextContent());
                openSession.setSessionName(((Element) nodes.item(i))
                        .getElementsByTagName("ep:sessionName").item(0).getTextContent());
                openSession.setHostID(((Element) nodes.item(i))
                        .getElementsByTagName("ep:hostWebExID").item(0).getTextContent());
                openSession.setStartTime(((Element) nodes.item(i))
                        .getElementsByTagName("ep:startTime").item(0).getTextContent());
                openSession.setTimeZoneID(((Element) nodes.item(i))
                        .getElementsByTagName("ep:timeZoneID").item(0).getTextContent());
                openSession.setListStatus(((Element) nodes.item(i))
                        .getElementsByTagName("ep:listStatus").item(0).getTextContent());
                openSessions.add(openSession);
            }

            return openSessions;
        } else if("FAILURE".equals(result.getTextContent())) {

            Element exceptionID = (Element)doc.getElementsByTagName("serv:exceptionID").item(0);
            if("000015".equals(exceptionID.getTextContent())) {
                return Collections.emptyList();
            }
        }
        return null;
    }
}
