package webex;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import webex.ob.TimeZoneId;
import webex.ob.req.sessions.training.*;
import webex.ob.req.sessions.training.AttAccessControl.*;
import webex.ob.req.sessions.training.AttEnableOptions.*;
import webex.ob.req.sessions.training.AttRepeat.*;
import webex.ob.req.sessions.training.AttTelephony.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by bonjan on 2015/4/1.
 */
public class WebExUtil {

    private static DocumentBuilderFactory documentBuilderFactory;

    private static DocumentBuilder documentBuilder;

    private static Document baseDocument;

    private static String userID;

    private static String userPassword;

    private static String sID;

    private static String pID;

    private static Logger logger = Logger.getLogger(WebExUtil.class.getName());

    public static void main(String[] args) {
        WebExUtil.initialize(
                "bobo12345",
                "bobo12345",
                "690319",
                "g0webx!",
                "https://apidemoeu.webex.com/WBXService/XMLService"
        );
//        Attendees registerInfo = new Attendees(
//                "bbbaaa",
//                "bbbaaa@gmail.com",
//                Type.VISITOR,
//                Role.ATTENDEE,
//                JoinStatus.REGISTER,
//                EmailInvitation.TRUE,
//                "622242668",
//                null);
//        List<Attendees> registerInfos = new ArrayList<Attendees>();
//        registerInfos.add(registerInfo);
//        WebExAPI.registerMeetingAttendee(registerInfos).getResponse();
//        WebExAPI.lstOpenSession().getResponse();
//        WebExAPI.lstMeetingAttendee("622242668").getResponse();
//        WebExAPI.getSessionInfo("622242668").getResponse();
//        new CreateTrainingSession().sendRequest();

//        AttSchedule attSchedule = new AttSchedule(5, 5, new Timestamp(new GregorianCalendar(2015,5,1).getTime().getTime()), TimeZoneId.HONG_KONG);
//        AttEnableOptions attEnableOptions = new AttEnableOptions(Options.VOIP, Options.ANNOTATION);
//        AttAttendeeOptions attAttendeeOptions =
//                new AttAttendeeOptions(true, true, true, "1111", 10,
//                        new Timestamp(new GregorianCalendar(2015,5,1).getTime().getTime()), false, TimeZoneId.HONG_KONG);
//        AttAccessControl attAccessControl = new AttAccessControl(Listing.PUBLIC, "1111");
//        AttRepeat attRepeat = new AttRepeat(RepeatType.SINGLE);
//        AttMetaData attMetaData = new AttMetaData("agenda", "test1122", "description");
//        AttTelephony attTelephony = new AttTelephony(TelephonySupport.NONE);
//
//        TrainingSession trainingSession = new TrainingSession(
//                attAccessControl, attAttendeeOptions, attEnableOptions,
//                attMetaData, attRepeat, attSchedule, attTelephony);
//        WebExAPI.createTrainingSession(trainingSession).getResponse();

//        WebExAPI.createTrainingSession(new TrainingSession(new AttMetaData("agenda","confname2300","desc")));
    }

    public static void initialize(String webExID, String password, String siteID,
                                  String partnerID, String xmlServerURL) {
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.log(Level.SEVERE, "Initial DocumentBuilder fail");
            e.printStackTrace();
        }
        assert documentBuilder != null;
        baseDocument = documentBuilder.newDocument();

        userID = webExID;
        userPassword = password;
        sID = siteID;
        pID = partnerID;

        HttpUtil.setXmlServerURL(xmlServerURL);

        prepareBaseDocument();

    }

    private static void prepareBaseDocument() {
        /**
         * Root XML tag <serv:message></serv:message>
         */
        Element root = baseDocument.createElement("serv:message");
        root.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        root.setAttribute("xmlns:serv", "http://www.webex.com/schemas/2002/06/service");
        root.setAttribute("xsi:schemaLocation", "http://www.webex.com/schemas/2002/06/service");
        baseDocument.appendChild(root);

        /**
         * Parent is <serv:message></serv:message>
         */
        Element header = baseDocument.createElement("header");
        Element body = baseDocument.createElement("body");
        root.appendChild(header);
        root.appendChild(body);

        /**
         * Parent is <header></header>
         */
        Element securityContext = baseDocument.createElement("securityContext");
        header.appendChild(securityContext);

        /**
         * Parent is <securityContext></securityContext>
         */
        Element webExID = baseDocument.createElement("webExID");
        Element password = baseDocument.createElement("password");
        Element siteID = baseDocument.createElement("siteID");
        Element partnerID = baseDocument.createElement("partnerID");
        //set content
        webExID.setTextContent(userID);
        password.setTextContent(userPassword);
        siteID.setTextContent(sID);
        partnerID.setTextContent(pID);
        //add child
        securityContext.appendChild(webExID);
        securityContext.appendChild(password);
        securityContext.appendChild(siteID);
        securityContext.appendChild(partnerID);
    }

    public static Document getBaseDocument() {
        return baseDocument;
    }

    public static String xmlToString(Document doc) {
        try {
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            return sw.toString();
        } catch (Exception ex) {
            throw new RuntimeException("Error converting to String", ex);
        }
    }

    public static Document stringToXml(String xmlString) {
        Document doc = null;
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xmlString.replaceAll("&(?!amp;)", "&amp;")));

        try {
            doc = documentBuilder.parse(is);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

}
