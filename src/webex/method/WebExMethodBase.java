package webex.method;

/**
 * Created by bonjan on 2015/4/15.
 */
public interface WebExMethodBase {

    /**
     * send request to webex xml service
     * @return xml response string
     */
    String sendRequest();

    /**
     * @return null if receive unexpected exception
     */
    Object getResponse();

    /**
     * parse response string to object
     */
    void parseFromResponse(String respXml);
}
