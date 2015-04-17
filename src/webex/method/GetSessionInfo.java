package webex.method;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import webex.DocumentUtil;
import webex.HttpUtil;
import webex.ob.resp.SessionInfo;
import webex.WebExUtil;

/**
 * Created by bonjan on 2015/4/7.
 */
public class GetSessionInfo implements WebExMethodBase {

    private String sessionKey;

    private SessionInfo sessionInfo;

    public GetSessionInfo(String sessionKey) {
        this.sessionKey = sessionKey;
        sessionInfo = new SessionInfo();
        parseFromResponse(sendRequest());
    }

    @Override
    public String sendRequest() {
        Document gsiDocument = (Document) WebExUtil.getBaseDocument().cloneNode(true);

        /**
         * Parent is <body></body>
         */
        Element bodyContent = gsiDocument.createElement("bodyContent");
        bodyContent.setAttribute("xsi:type", "java:com.webex.service.binding.ep.GetSessionInfo");
        gsiDocument.getElementsByTagName("body").item(0).appendChild(bodyContent);

        /**
         * Parent is <bodyContent></bodyContent>
         */
        DocumentUtil.appendChildWithContent(gsiDocument, "bodyContent", "sessionKey", sessionKey);

        return HttpUtil.sendXmlRequest(WebExUtil.xmlToString(gsiDocument));
    }

    @Override
    public SessionInfo getResponse() {
        return sessionInfo;
    }

    @Override
    public void parseFromResponse(String respXml) {
        Document doc = WebExUtil.stringToXml(respXml);

        assert doc != null;
        Element result = (Element)doc.getElementsByTagName("serv:result").item(0);
        if("SUCCESS".equals(result.getTextContent())) {
            sessionInfo.setConfName(doc.getElementsByTagName("ep:confName").item(0).getTextContent());
            sessionInfo.setStatus(doc.getElementsByTagName("ep:status").item(0).getTextContent());
            sessionInfo.setIsRecurring(doc.getElementsByTagName("ep:isRecurring").item(0).getTextContent());
            sessionInfo.setStartDate(doc.getElementsByTagName("ep:startDate").item(0).getTextContent());
            sessionInfo.setTimeZone(doc.getElementsByTagName("ep:timeZone").item(0).getTextContent());
            sessionInfo.setHostFirstName(doc.getElementsByTagName("ep:firstName").item(0).getTextContent());
            sessionInfo.setHostLastName(doc.getElementsByTagName("ep:lastName").item(0).getTextContent());
            sessionInfo.setHostEmail(doc.getElementsByTagName("ep:email").item(0).getTextContent());
            sessionInfo.setHostID(doc.getElementsByTagName("ep:webExId").item(0).getTextContent());
        } else {
            sessionInfo = null;
        }
    }

}
