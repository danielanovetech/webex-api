package webex.ob;

import java.util.TimeZone;

/**
 * Created by bonjan on 2015/4/16.
 */
public enum TimeZoneId {
    ENIWETOK("0", "GMT-1200"), SAMOA("1", "GMT-1100"), HONOLULU("2", "GMT-1000"), ANCHORAGE("3", "GMT-0900"),
    SAN_JOSE("4", "GMT-0800"), ARIZONA("5", "GMT-0700"), DENVER("6", "GMT-0700"), CHICAGO("7", "GMT-0600"),
    MEXICO_CITY("8", "GMT-0600"), REGINA("9", "GMT-0600"), BOGOTA("10", "GMT-0500"), NEW_YORK("11", "GMT-0500"),
    INDIANA("12", "GMT-0500"), HALIFAX("13", "GMT-0400"), CARACAS("14", "GMT-0400"), NEWFOUNDLAND("15", "GMT-0330"),
    BRASILIA("16", "GMT-0300"), BUENOS_AIRES("17", "GMT-0300"), MID_ATLANTIC("18", "GMT-0200"), AZORES("19", "GMT-0100"),
    CASABLANCA("20", "GMT0000"), LONDON("21", "GMT0000"), AMSTERDAM("22", "GMT+0100"), PARIS("23", "GMT+0100"),
    PRAGUE("24", "GMT+0100"), BERLIN("25", "GMT+0100"), ATHENS("26", "GMT+0200"), BUCHAREST("27", "GMT+0200"),
    CAIRO("28", "GMT+0200"), PRETORIA("29", "GMT+0200"), HELSINKI("30", "GMT+0200"), TEL_AVIV("31", "GMT+0200"),
    BAGHDAD("32", "GMT+0300"), MOSCOW("33", "GMT+0300"), NAIROBI("34", "GMT+0300"), TEHRAN("35", "GMT+0300"),
    ABU_DHABI("36", "GMT+0400"), BAKU("37", "GMT+0400"), KABUL("38", "GMT+0400"), EKATERINBURG("39", "GMT+0500"),
    ISLAMABAD("40", "GMT+0500"), BOMBAY("41", "GMT+0530"), COLOMBO("42", "GMT+0600"), ALMATY("43", "+GMT0600"),
    BANGKOK("44", "GMT+0700"), BEIJING("45", "GMT+0800"), PERTH("46", "GMT+0800"), SINGAPORE("47", "GMT+0800"),
    HONG_KONG("48", "GMT+0800"), TOKYO("49", "GMT+0900"), SEOUL("50", "GMT+0900"), YAKUTSK("51", "GMT+0930"),
    ADELAIDE("52", "GMT+0930"), DARWIN("53", "GMT+0930"), BRISBANE("54", "GMT+1000"), SYDNEY("55", "GMT+1000"),
    GUAM("56", "GMT+1000"), HOBART("57", "GMT+1000"), VLADIVOSTOK("58", "GMT+1000"), SOLOMON_IS("59", "GMT+1100"),
    WELLINGTON("60", "GMT+1200"), FIJI("61", "GMT+1200");

    private String id;

    private String timeZone;

    TimeZoneId(String id, String timeZone) {
        this.id = id;
        this.timeZone = timeZone;
    }

    public String getId() {
        return id;
    }

    public TimeZone getTimeZone() {
        return TimeZone.getTimeZone(timeZone);
    }
}
