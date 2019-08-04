package ru.example.main;

import javax.xml.ws.Endpoint;
import ru.example.server.FindNumberServiceImpl;

/**
 *
 * @author Philipp
 */
public class FindNumberProject {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
//        WritingToDBClass.insertToDB(98795);
        Endpoint.publish("http://localhost:8080/wss/number", new FindNumberServiceImpl());
    }

}
