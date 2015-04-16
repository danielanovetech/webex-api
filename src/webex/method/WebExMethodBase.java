package webex.method;

/**
 * Created by bonjan on 2015/4/15.
 */
public interface WebExMethodBase {

    /**
     * Prepare xml request and send to webex xml service
     * @return xml response string
     */
    String sendRequest();

    /**
     * Get response object
     * @return null if receive unexpected exception
     */
    Object getResponse();

    /**
     * Parse response string to object
     */
    void parseFromResponse(String respXml);
}
