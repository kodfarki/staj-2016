import com.servlet.util.JDBCUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GUNEY on 4.08.2016.
 */
public class Test {
    public static void main(String[] args) {
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
