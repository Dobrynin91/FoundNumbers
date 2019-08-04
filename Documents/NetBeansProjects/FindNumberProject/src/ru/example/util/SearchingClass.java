/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.example.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.example.entity.EnCode;
import ru.example.entity.Result;

/**
 *
 * @author Philipp
 */
public class SearchingClass {

    private static Logger logger = LoggerFactory.getLogger(SearchingClass.class);

//    private static final String pathDir = System.getProperty("java.io.tmpdir");
    private static final String pathDir = "C:\\Temp";

    /**
     *return the Result instance
     * @return
     */
    public static Result getFoundNumbers(int numb) {
        List<String> list = new ArrayList();
        Result result = new Result();
        try {
            for (File file : getFilesArray(pathDir)) {
                BufferedReader b = new BufferedReader(new FileReader(file));
                String readLine;
                while ((readLine = b.readLine()) != null) {
                    if (readLine.contains(String.valueOf(numb))) {
                        list.add(file.getName());
                    }
                }
            }
            result.setFileName(list.stream().distinct().collect(Collectors.toList()));
            if (!result.getFileName().isEmpty() && result.getFileName() != null) {
                result.setCode(EnCode.OK.getDescription());
            } else {
                result.setCode(EnCode.NOT_FOUND.getCode());
            }
            result.setError("There are not errors");
            return result;
        } catch (IOException ex) {
            ex.printStackTrace();
            logger.error("Something goes wrong");
            result.setCode(EnCode.ERROR.getCode());
            result.setError("Something goes wrong");
            return result;
        }
    }

    /**
     *
     * return the array File[] which was found in temporary directory
     * @return File[]
     * 
     */
    private static File[] getFilesArray(String pathDir) {
        return new File(pathDir).listFiles((dir, name) -> name.endsWith(".txt"));
    }
}
