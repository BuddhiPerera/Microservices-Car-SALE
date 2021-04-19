package lk.sliit.PAF.funding.model;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class CrudUtil {

    public static <T> T execute(String sql, Object... params) throws Exception {
        Connection con = FundModel.connect();
        PreparedStatement pstm = con.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pstm.setObject((i + 1), params[i]);
        }
        if (sql.startsWith("SELECT")){
            return (T) pstm.executeQuery();
        }
        return (T)((Boolean) (pstm.executeUpdate() > 0));

    }
}
