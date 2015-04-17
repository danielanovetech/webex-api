package webex;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by bonjan on 2015/4/16.
 */
public class DocumentUtil {

    public static void appendChild(Document document, String parentName, String childName) {
        Element childElement = document.createElement(childName);
        document.getElementsByTagName(parentName).item(0).appendChild(childElement);
    }

    public static void appendChildWithContent(Document document, String parentName, String childName, String content) {
        if (content == null) {
            Element childElement = document.createElement(childName);
            childElement.setTextContent(content);
            document.getElementsByTagName(parentName).item(0).appendChild(childElement);
        }
    }
}
