package lk.sliit.PAF.payment.model;


import lk.sliit.PAF.payment.dto.ProDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {
    private static ProductModel instance;

    public static ProductModel getInstance() {
        if (instance == null) {
            instance = new ProductModel();
        }
        return instance;
    }

    //A common method to connect to the DB
    public static Connection connect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //Provide the correct details: DBServer/DBName, username, password
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public int getLastID() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT id FROM products ORDER BY id DESC LIMIT 1");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            return 0;
        }
    }


    public List<ProDTO> listAll() throws Exception {

        Connection con = connect();
        int id = getLastID();
        if (con == null) {
            return null;
        }
        List<ProDTO> product = new ArrayList<>();
        String query = "Select * from products";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ProDTO p = new ProDTO();
                p.setId(rs.getString(1));
                p.setName(rs.getString(2));
                p.setDescription(rs.getString(3));
                p.setPrice(rs.getString(4));
                p.setQty(rs.getString(5));
                p.setShipping(rs.getString(6));
                p.setImage(rs.getString(7));
                product.add(p);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return product;
    }

    public ProDTO findOne(String id) throws Exception {
        Connection con = connect();
        String sql = "select * from products where id =" + id;
        ProDTO a = new ProDTO();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                a.setId(rs.getString(1));
                a.setName(rs.getString(2));
                a.setDescription(rs.getString(3));
                a.setPrice(rs.getString(4));
                a.setQty(rs.getString(5));
                a.setShipping(rs.getString(6));
                a.setImage(rs.getString(7));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return a;
    }


}
