package com.servlet.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by hamitsarac on 4.08.2016.
 */
public class Test {
    PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement("SELECT * FROM SLCM_CAMPAIGN");


    public Test() throws SQLException {
    }
}
