package webex.method;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import webex.ob.Attendee;
import webex.HttpUtil;
import webex.WebExUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by bonjan on 2015/4/1.
 */
public class LstMeetingAttendee {

    /**
     * @param meetingKey
     * @return null if receive unexpected exception
     */
    public static List<Attendee> getAttendees(String meetingKey) {
        Document attendeeDocument = (Document) WebExUtil.getBaseDocument().cloneNode(true);

        /**
         * Parent is <body></body>
         */
        Element bodyContent = attendeeDocument.createElement("bodyContent");
        bodyContent.setAttribute("xsi:type", "java:com.webex.service.binding.attendee.LstMeetingAttendee");
        attendeeDocument.getElementsByTagName("body").item(0).appendChild(bodyContent);

        /**
         * Parent is <bodyContent></bodyContent>
         */
        Element mKey = attendeeDocument.createElement("meetingKey");
        mKey.setTextContent(meetingKey);
        bodyContent.appendChild(mKey);

        return parseFromResponse(HttpUtil.sendXmlRequest(WebExUtil.xmlToString(attendeeDocument)));
    }

    /**
     * @param respXml
     * @return null if receive unexpected exception
     */
    public static List<Attendee> parseFromResponse(String respXml) {
        Document doc = WebExUtil.stringToXml(respXml);

        assert doc != null;
        Element result = (Element)doc.getElementsByTagName("serv:result").item(0);
        NodeList nodes = doc.getElementsByTagName("att:attendee");
        if("SUCCESS".equals(result.getTextContent())) {
            List<Attendee> attendees = new ArrayList<Attendee>();
            for (int i = 0; i < nodes.getLength(); i++) {
                Attendee attendee = new Attendee();
                attendee.setName(((Element) nodes.item(i))
                        .getElementsByTagName("com:name").item(0).getTextContent());
                attendee.setEmail(((Element) nodes.item(i))
                        .getElementsByTagName("com:email").item(0).getTextContent());
                attendee.setType(((Element) nodes.item(i))
                        .getElementsByTagName("com:type").item(0).getTextContent());
                attendee.setJoinStatus(((Element) nodes.item(i))
                        .getElementsByTagName("att:joinStatus").item(0).getTextContent());
                attendee.setRegisterID(((Element) nodes.item(i))
                        .getElementsByTagName("att:registerID").item(0).getTextContent());
                attendee.setRole(((Element) nodes.item(i))
                        .getElementsByTagName("att:role").item(0).getTextContent());
                attendees.add(attendee);
            }

            return attendees;
        } else if("FAILURE".equals(result.getTextContent())) {

            Element exceptionID = (Element)doc.getElementsByTagName("serv:exceptionID").item(0);
            if("000015".equals(exceptionID.getTextContent())) {
                return Collections.emptyList();
            }
        }
        return null;
    }

}
