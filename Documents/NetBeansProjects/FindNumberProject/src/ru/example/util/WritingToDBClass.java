/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.example.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.example.entity.Result;

/**
 *
 * @author Philipp
 */
public class WritingToDBClass {

    private static Logger logger = LoggerFactory.getLogger(WritingToDBClass.class);

    public static void insertToDB(int numb) {
        Result result = SearchingClass.getFoundNumbers(numb);
        String sqlQuery = "INSERT INTO found_number (CODE, NUMBER, FILENAMES, ERROR) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionClass.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sqlQuery)) {
                ps.setString(1, result.getCode());
                ps.setInt(2, numb);
                ps.setString(3, getFileNames(result));
                ps.setString(4, result.getError());
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Something goes wrong");
        }
    }

    private static String getFileNames(Result result) {
        if (!result.getFileName().isEmpty() && result.getFileName() != null) {
            return result.getFileName().stream().collect(Collectors.joining(", "));
        } else {
            return "";
        }
    }

}
