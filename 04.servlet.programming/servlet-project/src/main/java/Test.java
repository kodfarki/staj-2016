import com.servlet.util.JDBCUtil;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by GUNEY on 4.08.2016.
 */
public class Test {
    public static void main(String[] args) throws IOException {


        try {


            PreparedStatement ps = JDBCUtil.getConnection().prepareStatement("SELECT * FROM SLCM_CAMPAIGN");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("CAMPAIGN_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


}
