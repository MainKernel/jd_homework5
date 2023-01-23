package com.jdbc.jdhomework5.feature.pref;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Pref {
    private static final String CONFIGURATION_FILE = "./pref.json";
    public static final String DATABASE_CONNECTION_URL = "DBConnectionURL";

    public static final String DATABASE_INIT = "DBInit";

    private Map<String, Object> pref = new HashMap<>();

    public Pref() {
        this(CONFIGURATION_FILE);
    }

    public Pref(String filename) {
        try {
            String join = String.join("\n", Files.readAllLines(Path.of(filename)));
            pref = new Gson().fromJson(join,
                    TypeToken.getParameterized(Map.class, String.class, Object.class).getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getPref(String key) {
        return pref.get(key);
    }

    public String getString(String key) {
        return getPref(key).toString();
    }
}
