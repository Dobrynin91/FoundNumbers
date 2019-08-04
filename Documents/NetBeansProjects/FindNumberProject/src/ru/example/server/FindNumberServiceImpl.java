/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.example.server;

import javax.jws.WebService;
import ru.example.entity.Result;
import ru.example.util.SearchingClass;
import ru.example.util.WritingToDBClass;


/**
 *
 * @author Philipp
 */

@WebService(endpointInterface = "ru.example.server.FindNumberService",
        serviceName = "ExampleSoap")
public class FindNumberServiceImpl implements FindNumberService {

    @Override
    public Result getResultToString(int number) {
        return SearchingClass.getFoundNumbers(number);
    }

    @Override
    public void writeIntoDB(int number) {
        WritingToDBClass.insertToDB(number);
    }

}
