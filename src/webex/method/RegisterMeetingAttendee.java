package webex.method;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import webex.HttpUtil;
import webex.ob.RegisterInfo;
import webex.ob.Registrant;
import webex.WebExUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bonjan on 2015/4/2.
 */
public class RegisterMeetingAttendee {

    /**
     * @param registerInfos
     * @return null if receive unexpected exception
     */
    public static List<Registrant> sendRegistration(List<RegisterInfo> registerInfos) {
        Document registerDocument = (Document) WebExUtil.getBaseDocument().cloneNode(true);

        Element bodyContent = registerDocument.createElement("bodyContent");
        bodyContent.setAttribute("xsi:type",
                "java:com.webex.service.binding.attendee.RegisterMeetingAttendee");
        registerDocument.getElementsByTagName("body").item(0).appendChild(bodyContent);

        for(RegisterInfo registerInfo : registerInfos) {
            /**
             * Parent is <bodyContent></bodyContent>
             */
            Element attendees = registerDocument.createElement("attendees");
            bodyContent.appendChild(attendees);

            /**
             * Parent is <attendees></attendees>
             */
            Element person = registerDocument.createElement("person");
            Element joinStatus = registerDocument.createElement("joinStatus");
            Element role = registerDocument.createElement("role");
            Element emailInvitations = registerDocument.createElement("emailInvitations");
            Element sessionKey = registerDocument.createElement("sessionKey");
            //set content
            joinStatus.setTextContent(registerInfo.getJoinStatus());
            role.setTextContent(registerInfo.getRole());
            emailInvitations.setTextContent(registerInfo.getEmailInvitation());
            sessionKey.setTextContent(registerInfo.getSessionKey());
            //add child
            attendees.appendChild(person);
            attendees.appendChild(joinStatus);
            attendees.appendChild(role);
            attendees.appendChild(emailInvitations);
            attendees.appendChild(sessionKey);
            //for recurring sessions
            if (registerInfo.getSessionNum() != null) {
                Element sessionNum = registerDocument.createElement("sessionNum");
                sessionNum.setTextContent(registerInfo.getSessionNum());
                attendees.appendChild(sessionNum);
            }

            /**
             * Parent is <person></person>
             */
            Element name = registerDocument.createElement("name");
            Element email = registerDocument.createElement("email");
            Element type = registerDocument.createElement("type");
            //set content
            name.setTextContent(registerInfo.getName());
            email.setTextContent(registerInfo.getEmail());
            type.setTextContent(registerInfo.getType());
            //add child
            person.appendChild(name);
            person.appendChild(email);
            person.appendChild(type);
        }

        return parseFromResponse(HttpUtil.sendXmlRequest(WebExUtil.xmlToString(registerDocument)));
    }

    /**
     * @param respXml
     * @return null if receive unexpected exception
     */
    public static List<Registrant> parseFromResponse(String respXml) {
        Document doc = WebExUtil.stringToXml(respXml);

        assert doc != null;
        Element result = (Element)doc.getElementsByTagName("serv:result").item(0);
        NodeList nodes = doc.getElementsByTagName("att:register");
        if("SUCCESS".equals(result.getTextContent())) {
            List<Registrant> registrants = new ArrayList<Registrant>();
            for (int i = 0; i < nodes.getLength(); i++) {
                Registrant registrant = new Registrant();
                registrant.setAttendeeID(((Element) nodes.item(i))
                        .getElementsByTagName("att:attendeeID").item(0).getTextContent());
                registrant.setRegisterID(((Element) nodes.item(i))
                        .getElementsByTagName("att:registerID").item(0).getTextContent());
                registrants.add(registrant);
            }

            return registrants;
        }
        return null;
    }

}
