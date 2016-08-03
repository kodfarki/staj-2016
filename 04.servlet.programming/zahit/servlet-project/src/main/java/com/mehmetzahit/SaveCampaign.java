package com.mehmetzahit;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.mehmetzahit.JDBCUtil.*;

/**
 * Created by GUNEY on 2.08.2016.
 */
public class SaveCampaign extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        String query = "INSERT INTO SLCM_CAMPAIGN VALUES (SEQUENCE1.nextval,'1',to_date('10.10.2016','dd.MM.yyyy'),'',7,5,5,?,'what is this',to_date('10.10.2016','dd.MM.yyyy'),to_date('10.10.2016','dd.MM.yyyy'),5)";

        try {

            PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement(query);
            preparedStatement.setString(1, name);
            int i = preparedStatement.executeUpdate();
            if (i > 0) out.println("Kayıt Ekleme Başarılı");
            else
                out.println("Kayıt Ekleme Başarısız");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error");
        }

    }
}
