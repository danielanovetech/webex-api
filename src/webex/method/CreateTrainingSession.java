package webex.method;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import webex.DocumentUtil;
import webex.HttpUtil;
import webex.WebExUtil;
import webex.ob.req.sessions.training.TrainingSession;
import webex.ob.req.sessions.training.AttEnableOptions.*;
import webex.ob.resp.AdditionalInfo;

/**
 * Created by bonjan on 2015/4/14.
 */
public class CreateTrainingSession implements WebExMethodBase {

    private TrainingSession trainingSession;

    private AdditionalInfo additionalInfo;

    public CreateTrainingSession(TrainingSession trainingSession) {
        this.trainingSession = trainingSession;
        additionalInfo = new AdditionalInfo();
        parseFromResponse(sendRequest());
    }

    @Override
    public String sendRequest() {
        Document ctsDocument = (Document) WebExUtil.getBaseDocument().cloneNode(true);

        /**
         * Parent is <body></body>
         */
        Element bodyContent = ctsDocument.createElement("bodyContent");
        bodyContent.setAttribute("xsi:type", "java:com.webex.service.binding.training.CreateTrainingSession");
        ctsDocument.getElementsByTagName("body").item(0).appendChild(bodyContent);

        /**
         * Parent is <bodyContent></bodyContent>
         */
        DocumentUtil.appendChild(ctsDocument, "bodyContent", "accessControl");
        DocumentUtil.appendChild(ctsDocument, "bodyContent", "attendeeOptions");
        DocumentUtil.appendChild(ctsDocument, "bodyContent", "enableOptions");
        DocumentUtil.appendChild(ctsDocument, "bodyContent", "metaData");
        DocumentUtil.appendChild(ctsDocument, "bodyContent", "repeat");
        DocumentUtil.appendChild(ctsDocument, "bodyContent", "schedule");
        DocumentUtil.appendChild(ctsDocument, "bodyContent", "telephony");

        /**
         * Parent is <accessControl></accessControl>
         */
        DocumentUtil.appendChildWithContent(ctsDocument, "accessControl", "listing",
                trainingSession.getAttAccessControl().getListing());
        DocumentUtil.appendChildWithContent(ctsDocument, "accessControl", "sessionPassword",
                trainingSession.getAttAccessControl().getSessionPassword());

        /**
         * Parent is <attendeeOptions></attendeeOptions>
         */
        DocumentUtil.appendChildWithContent(ctsDocument, "attendeeOptions", "request",
                trainingSession.getAttAttendeeOptions().getRequest());
        DocumentUtil.appendChildWithContent(ctsDocument, "attendeeOptions", "registration",
                trainingSession.getAttAttendeeOptions().getRegistration());
        DocumentUtil.appendChildWithContent(ctsDocument, "attendeeOptions", "auto",
                trainingSession.getAttAttendeeOptions().getAuto());
        DocumentUtil.appendChildWithContent(ctsDocument, "attendeeOptions", "registrationPWD",
                trainingSession.getAttAttendeeOptions().getRegistrationPWD());
        DocumentUtil.appendChildWithContent(ctsDocument, "attendeeOptions", "maxRegistrations",
                trainingSession.getAttAttendeeOptions().getMaxRegistrations());
        DocumentUtil.appendChildWithContent(ctsDocument, "attendeeOptions", "registrationCloseDate",
                trainingSession.getAttAttendeeOptions().getRegistrationCloseDate());
        DocumentUtil.appendChildWithContent(ctsDocument, "attendeeOptions", "emailInvitations",
                trainingSession.getAttAttendeeOptions().getEmailInvitations());

        /**
         * Parent is <enableOptions></enableOptions>
         */
        for (Options options: Options.values()) {
            DocumentUtil.appendChildWithContent(ctsDocument, "enableOptions", options.getKey(),
                    trainingSession.getAttEnableOptions().getOptionMap().get(options.getKey()));
        }

        /**
         * Parent is <metaData></metaData>
         */
        DocumentUtil.appendChildWithContent(ctsDocument, "metaData", "confName",
                trainingSession.getAttMetaData().getConfName());
        DocumentUtil.appendChildWithContent(ctsDocument, "metaData", "agenda",
                trainingSession.getAttMetaData().getAgenda());
        DocumentUtil.appendChildWithContent(ctsDocument, "metaData", "description",
                trainingSession.getAttMetaData().getDescription());

        /**
         * Parent is <repeat></repeat>
         */
        DocumentUtil.appendChildWithContent(ctsDocument, "repeat", "repeatType",
                trainingSession.getAttRepeat().getRepeatType());

        /**
         * Parent is <schedule></schedule>
         */
        DocumentUtil.appendChildWithContent(ctsDocument, "schedule", "startDate",
                trainingSession.getAttSchedule().getStartDate());
        DocumentUtil.appendChildWithContent(ctsDocument, "schedule", "duration",
                trainingSession.getAttSchedule().getDuration());
        DocumentUtil.appendChildWithContent(ctsDocument, "schedule", "timeZoneID",
                trainingSession.getAttSchedule().getTimeZoneID());
        DocumentUtil.appendChildWithContent(ctsDocument, "schedule", "openTime",
                trainingSession.getAttSchedule().getOpenTime());

        /**
         * Parent is <telephony></telephony>
         */
        DocumentUtil.appendChildWithContent(ctsDocument, "telephony", "telephonySupport",
                trainingSession.getAttTelephony().getTelephonySupport());

        return HttpUtil.sendXmlRequest(WebExUtil.xmlToString(ctsDocument));
    }

    @Override
    public Object getResponse() {
        return additionalInfo;
    }

    @Override
    public void parseFromResponse(String respXml) {
        Document doc = WebExUtil.stringToXml(respXml);

        assert doc != null;
        Element result = (Element)doc.getElementsByTagName("serv:result").item(0);
        if("SUCCESS".equals(result.getTextContent())) {
            additionalInfo.setSessionKey(doc.getElementsByTagName("train:sessionkey").item(0).getTextContent());
            additionalInfo.setGuestToken(doc.getElementsByTagName("train:guestToken").item(0).getTextContent());
        } else {
            additionalInfo = null;
        }
    }
}
