package lk.sliit.PAF.productManage.model;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class CrudUtil {

    public static <T> T execute(String sql, Object... params) throws Exception {
        Connection con = ProductModel.connect();
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
