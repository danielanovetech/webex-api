package webex.method;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import webex.HttpUtil;
import webex.ob.SessionInfo;
import webex.WebExUtil;

/**
 * Created by bonjan on 2015/4/7.
 */
public class GetSessionInfo {

    /**
     * @param sessionKey
     * @return null if receive unexpected exception
     */
    public static SessionInfo getInfo(String sessionKey) {
        Document sessionInfoDocument = (Document) WebExUtil.getBaseDocument().cloneNode(true);

        /**
         * Parent is <body></body>
         */
        Element bodyContent = sessionInfoDocument.createElement("bodyContent");
        bodyContent.setAttribute("xsi:type", "java:com.webex.service.binding.ep.GetSessionInfo");
        sessionInfoDocument.getElementsByTagName("body").item(0).appendChild(bodyContent);

        /**
         * Parent is <bodyContent></bodyContent>
         */
        Element sKey = sessionInfoDocument.createElement("sessionKey");
        sKey.setTextContent(sessionKey);
        bodyContent.appendChild(sKey);

        return parseFromResponse(HttpUtil.sendXmlRequest(WebExUtil.xmlToString(sessionInfoDocument)));
    }

    /**
     * @param respXml
     * @return null if receive unexpected exception
     */
    public static SessionInfo parseFromResponse(String respXml) {
        Document doc = WebExUtil.stringToXml(respXml);

        assert doc != null;
        Element result = (Element)doc.getElementsByTagName("serv:result").item(0);
        if("SUCCESS".equals(result.getTextContent())) {
            SessionInfo sessionInfo = new SessionInfo();
            sessionInfo.setConfName(doc.getElementsByTagName("ep:confName").item(0)
                    .getTextContent());
            sessionInfo.setStatus(doc.getElementsByTagName("ep:status").item(0)
                    .getTextContent());
            sessionInfo.setIsRecurring(doc.getElementsByTagName("ep:isRecurring").item(0)
                    .getTextContent());
            sessionInfo.setStartDate(doc.getElementsByTagName("ep:startDate").item(0)
                    .getTextContent());
            sessionInfo.setTimeZone(doc.getElementsByTagName("ep:timeZone").item(0)
                    .getTextContent());
            sessionInfo.setHostFirstName(doc.getElementsByTagName("ep:firstName").item(0)
                    .getTextContent());
            sessionInfo.setHostLastName(doc.getElementsByTagName("ep:lastName").item(0)
                    .getTextContent());
            sessionInfo.setHostEmail(doc.getElementsByTagName("ep:email").item(0)
                    .getTextContent());
            sessionInfo.setHostID(doc.getElementsByTagName("ep:webExId").item(0)
                    .getTextContent());
            return sessionInfo;
        }
        return null;
    }

}
