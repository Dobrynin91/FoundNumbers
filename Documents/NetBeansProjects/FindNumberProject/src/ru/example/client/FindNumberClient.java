/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.example.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import ru.example.server.FindNumberService;

/**
 *
 * @author Philipp
 */
public class FindNumberClient {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/wss/number");
            
            QName qName = new QName("http://server.example.ru/", "ExampleSoap");
            Service service = Service.create(url, qName);
            FindNumberService findNumber = service.getPort(FindNumberService.class);
            findNumber.getResultToString(9999);
            findNumber.writeIntoDB(9999);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }

}
