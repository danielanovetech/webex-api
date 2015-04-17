package webex.method;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import webex.DocumentUtil;
import webex.HttpUtil;
import webex.ob.req.Attendees;
import webex.ob.resp.Register;
import webex.WebExUtil;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bonjan on 2015/4/2.
 */
public class RegisterMeetingAttendee implements WebExMethodBase {

    private List<Attendees> attendees;

    private List<Register> registers;

    public RegisterMeetingAttendee(List<Attendees> attendees) {
        this.attendees = attendees;
        this.registers = new ArrayList<Register>();
        parseFromResponse(sendRequest());
    }

    @Override
    public String sendRequest() {
        Document rmtDocument = (Document) WebExUtil.getBaseDocument().cloneNode(true);

        Element bodyContent = rmtDocument.createElement("bodyContent");
        bodyContent.setAttribute("xsi:type",
                "java:com.webex.service.binding.attendee.RegisterMeetingAttendee");
        rmtDocument.getElementsByTagName("body").item(0).appendChild(bodyContent);

        for(Attendees registerInfo : attendees) {
            /**
             * Parent is <bodyContent></bodyContent>
             */
            DocumentUtil.appendChild(rmtDocument, "bodyContent", "attendees");

            /**
             * Parent is <attendees></attendees>
             */
            DocumentUtil.appendChild(rmtDocument, "attendees", "person");
            DocumentUtil.appendChildWithContent(rmtDocument, "attendees", "joinStatus", registerInfo.getJoinStatus());
            DocumentUtil.appendChildWithContent(rmtDocument, "attendees", "role", registerInfo.getRole());
            DocumentUtil.appendChildWithContent(rmtDocument, "attendees", "emailInvitations", registerInfo.getEmailInvitation());
            DocumentUtil.appendChildWithContent(rmtDocument, "attendees", "sessionKey", registerInfo.getSessionKey());
            //for recurring sessions
            if (registerInfo.getSessionNum() != null) {
                DocumentUtil.appendChildWithContent(rmtDocument, "attendees", "sessionNum", registerInfo.getSessionNum());
            }

            /**
             * Parent is <person></person>
             */
            DocumentUtil.appendChildWithContent(rmtDocument, "person", "name",registerInfo.getName());
            DocumentUtil.appendChildWithContent(rmtDocument, "person", "email",registerInfo.getEmail());
            DocumentUtil.appendChildWithContent(rmtDocument, "person", "type", registerInfo.getType());
        }
        return HttpUtil.sendXmlRequest(WebExUtil.xmlToString(rmtDocument));
    }

    @Override
    public List<Register> getResponse() {
        return registers;
    }

    @Override
    public void parseFromResponse(String respXml) {
        Document doc = WebExUtil.stringToXml(respXml);

        assert doc != null;
        Element result = (Element)doc.getElementsByTagName("serv:result").item(0);
        NodeList nodes = doc.getElementsByTagName("att:register");
        if("SUCCESS".equals(result.getTextContent())) {
            for (int i = 0; i < nodes.getLength(); i++) {
                Register register = new Register();
                register.setAttendeeID(((Element) nodes.item(i))
                        .getElementsByTagName("att:attendeeID").item(0).getTextContent());
                register.setRegisterID(((Element) nodes.item(i))
                        .getElementsByTagName("att:registerID").item(0).getTextContent());
                registers.add(register);
            }
        } else {
            registers = null;
        }
    }

}
