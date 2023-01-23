package com.jdbc.jdhomework5.feature.database;

import com.jdbc.jdhomework5.feature.pref.Pref;

public class DBInitService {

    public void initDB() {
        Storage st = Storage.getInstance();
        SQLService sqlService = new SQLService();
        String sql = sqlService.readSQLFromFile(new Pref().getString(Pref.DATABASE_INIT));
        st.executeUpdate(sql);
    }
}
