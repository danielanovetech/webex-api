package webex.ob.req.sessions.training;

import java.util.*;

/**
 * Created by bonjan on 2015/4/15.
 */
public class AttEnableOptions {
    
    public enum Options {
        ATTENDEELIST("attendeeList"), JAVACLIENT("javaClient"), NATIVECLIENT("nativeClient"), CHAT("chat"),
        POLL("poll"), AUDIOVIDEO("audioVideo"), FILESHARE("fileShare"), PRESENTATION("presentation"),
        APPLICATIONSHARE("applicationShare"), DESKTOPSHARE("desktopShare"), WEBTOUR("webTour"),
        TRAININGSESSIONRECORD("trainingSessionRecord"), ANNOTATION("annotation"), IMPORTDOCUMENT("importDocument"),
        SAVEDOCUMENT("saveDocument"), PRINTDOCUMENT("printDocument"), POINTER("pointer"), SWITCHPAGE("switchPage"),
        FULLSCREEN("fullScreen"), THUMBNAIL("thumbnail"), ZOOM("zoom"), COPYPAGE("copyPage"), RCAPPSHARE("rcAppShare"),
        RCDESKTOPSHARE("rcDesktopShare"), RCWEBTOUR("rcWebTour"),
        ATTENDEERECORDTRAININGSESSION("attendeeRecordTrainingSession"), VOIP("voip"),
        FAXINTOTRAININGSESSION("faxIntoTrainingSession"), AUTODELETEAFTERMEETINGEND("autoDeleteAfterMeetingEnd");

        private String key;

        Options(String key) {
            this.key = key;          
        }

        public String getKey() {
            return key;
        }
    }

    public AttEnableOptions(Options... enableOptionses) {
        optionMap = new HashMap<String, String>();
        List<Options> enableOptionsesArray = new ArrayList<Options>(Arrays.asList(enableOptionses));
        for (Options options: Options.values()) {
            if(!enableOptionsesArray.contains(options)) {
                optionMap.put(options.getKey(), String.valueOf(false));
            } else {
                optionMap.put(options.getKey(), String.valueOf(true));
            }
        }
    }

    private Map<String, String> optionMap;

    public Map<String, String> getOptionMap() {
        return optionMap;
    }

    public String getAttendeeList() {
        return optionMap.get(Options.ATTENDEELIST.getKey());
    }

    public String getJavaClient() {
        return optionMap.get(Options.JAVACLIENT.getKey());
    }

    public String getNativeClient() {
        return optionMap.get(Options.NATIVECLIENT.getKey());
    }

    public String getChat() {
        return optionMap.get(Options.CHAT.getKey());
    }

    public String getPoll() {
        return optionMap.get(Options.POLL.getKey());
    }

    public String getAudioVideo() {
        return optionMap.get(Options.AUDIOVIDEO.getKey());
    }

    public String getFileShare() {
        return optionMap.get(Options.FILESHARE.getKey());
    }

    public String getPresentation() {
        return optionMap.get(Options.PRESENTATION.getKey());
    }

    public String getApplicationShare() {
        return optionMap.get(Options.APPLICATIONSHARE.getKey());
    }

    public String getDesktopShare() {
        return optionMap.get(Options.DESKTOPSHARE.getKey());
    }

    public String getWebTour() {
        return optionMap.get(Options.WEBTOUR.getKey());
    }

    public String getTrainingSessionRecord() {
        return optionMap.get(Options.TRAININGSESSIONRECORD.getKey());
    }

    public String getAnnotation() {
        return optionMap.get(Options.ANNOTATION.getKey());
    }

    public String getImportDocument() {
        return optionMap.get(Options.IMPORTDOCUMENT.getKey());
    }

    public String getSaveDocument() {
        return optionMap.get(Options.SAVEDOCUMENT.getKey());
    }

    public String getPrintDocument() {
        return optionMap.get(Options.PRINTDOCUMENT.getKey());
    }

    public String getPointer() {
        return optionMap.get(Options.POINTER.getKey());
    }

    public String getSwitchPage() {
        return optionMap.get(Options.SWITCHPAGE.getKey());
    }

    public String getFullScreen() {
        return optionMap.get(Options.FULLSCREEN.getKey());
    }

    public String getThumbnail() {
        return optionMap.get(Options.THUMBNAIL.getKey());
    }

    public String getZoom() {
        return optionMap.get(Options.ZOOM.getKey());
    }

    public String getCopyPage() {
        return optionMap.get(Options.COPYPAGE.getKey());
    }

    public String getRcAppShare() {
        return optionMap.get(Options.RCAPPSHARE.getKey());
    }

    public String getRcDesktopShare() {
        return optionMap.get(Options.RCDESKTOPSHARE.getKey());
    }

    public String getRcWebTour() {
        return optionMap.get(Options.RCWEBTOUR.getKey());
    }

    public String getAttendeeRecordTrainingSession() {
        return optionMap.get(Options.ATTENDEERECORDTRAININGSESSION.getKey());
    }

    public String getVoip() {
        return optionMap.get(Options.VOIP.getKey());
    }

    public String getFaxIntoTrainingSession() {
        return optionMap.get(Options.FAXINTOTRAININGSESSION.getKey());
    }

    public String getAutoDeleteAfterMeetingEnd() {
        return optionMap.get(Options.AUTODELETEAFTERMEETINGEND.getKey());
    }

}
