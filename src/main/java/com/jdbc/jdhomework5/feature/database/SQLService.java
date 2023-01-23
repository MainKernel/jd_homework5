package com.jdbc.jdhomework5.feature.database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SQLService {

    public String readSQLFromFile(String path) {
        try {
            return String.join("\n", Files.readAllLines(Path.of(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
