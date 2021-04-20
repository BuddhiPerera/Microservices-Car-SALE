package lk.sliit.PAF.productManage.model;
import lk.sliit.PAF.productManage.dto.ProDTO;

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
    public static Connection connect()
    {
        Connection con = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            //Provide the correct details: DBServer/DBName, username, password
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "1234");
        }
        catch (Exception e)
        {e.printStackTrace();}
        return con;
    }
    public int getLastID() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT id FROM products ORDER BY id DESC LIMIT 1");
        if(resultSet.next()){
            return resultSet.getInt(1);
        }
        else {
            return 0;
        }
    }

    public String insertItem(String name, String description, String price, String qty, String shipping, String image)
    {
        image = "s";
        String output = "";
        try

        {
            Connection con = connect();
            int id = getLastID();
            if (con == null)
            {return "Error while connecting to the database for inserting."; }
            // create a prepared statement
            String query = " insert into  products (`id`,`name`,`description`,`price`,`qty`,`shipping`,`image`)"
                    + " values (?, ?, ?, ?, ?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // binding values
            preparedStmt.setInt(1, id+1);
            preparedStmt.setString(2, name);
            preparedStmt.setString(3, description);
            preparedStmt.setDouble(4, Double.parseDouble(price));
            preparedStmt.setString(5, qty);
            preparedStmt.setString(6, shipping);
            preparedStmt.setString(7, image);
// execute the statement
            preparedStmt.execute();
            con.close();
            System.out.println("Inserted successfully");
        }
        catch (Exception e)
        {
            output = "Error while inserting the item.";
            System.err.println(e.getMessage());
        }
        return output;
    }


    public List<ProDTO> listAll() throws Exception {

        Connection con = connect();
        int id = getLastID();
        if (con == null)
        {return null; }
        List<ProDTO> patient = new ArrayList<>();
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
                patient.add(p);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return patient;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public String insertItem(String code, String name, String price, String desc)
    {
        String output = "";
        try
        {
            Connection con = connect();
            int id = getLastID();
            if (con == null)
            {return "Error while connecting to the database for inserting."; }
            // create a prepared statement
            String query = " insert into items (`itemID`,`itemCode`,`itemName`,`itemPrice`,`itemDesc`)"
                    + " values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // binding values
            preparedStmt.setInt(1, id+1);
            preparedStmt.setString(2, code);
            preparedStmt.setString(3, name);
            preparedStmt.setDouble(4, Double.parseDouble(price));
            preparedStmt.setString(5, desc);
// execute the statement
            preparedStmt.execute();
            con.close();
            output = "Inserted successfully";
        }
        catch (Exception e)
        {
            output = "Error while inserting the item.";
            System.err.println(e.getMessage());
        }
        return output;
    }
    public String readItems()
    {
        String output = "";
        try
        {
            Connection con = connect();
            if (con == null)
            {return "Error while connecting to the database for reading."; }
            // Prepare the html table to be displayed
            output = "<table border='1'><tr><th>Item Code</th><th>Item Name</th>" +
                    "<th>Item Price</th>" +
                    "<th>Item Description</th>" +
                    "<th>Update</th><th>Remove</th></tr>";

            String query = "select * from items";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // iterate through the rows in the result set
            while (rs.next())
            {
                String itemID = Integer.toString(rs.getInt("itemID"));
                String itemCode = rs.getString("itemCode");
                String itemName = rs.getString("itemName");
                String itemPrice = Double.toString(rs.getDouble("itemPrice"));
                String itemDesc = rs.getString("itemDesc");
                // Add into the html table
                output += "<tr><td>" + itemCode + "</td>";
                output += "<td>" + itemName + "</td>";
                output += "<td>" + itemPrice + "</td>";
                output += "<td>" + itemDesc + "</td>";
                // buttons
                output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
                        + "<td><form method='post' action='items.jsp'>"
                        + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
                        + "<input name='itemID' type='hidden' value='" + itemID
                        + "'>" + "</form></td></tr>";
            }
            con.close();
            // Complete the html table
            output += "</table>";
        }
        catch (Exception e)
        {
            output = "Error while reading the items.";
            System.err.println(e.getMessage());
        }
        return output;
    }
    public String updateItem(String ID, String code, String name, String price, String desc)
    {
        String output = "";
        try
        {
            Connection con = connect();
            if (con == null)
            {return "Error while connecting to the database for updating."; }
            // create a prepared statement
            String query = "UPDATE items SET itemCode=?,itemName=?,itemPrice=?,itemDesc=? WHERE itemID=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // binding values
            preparedStmt.setString(1, code);
            preparedStmt.setString(2, name);
            preparedStmt.setDouble(3, Double.parseDouble(price));
            preparedStmt.setString(4, desc);
            preparedStmt.setInt(5, Integer.parseInt(ID));
            // execute the statement
            preparedStmt.execute();
            con.close();
            output = "Updated successfully";
        }
        catch (Exception e)
        {
            output = "Error while updating the item.";
            System.err.println(e.getMessage());
        }
        return output;
    }
    public boolean deleteItem(int itemID)
    {
        String output = "";
        try
        {
            Connection con = connect();
            if (con == null)
            {return false; }
            // create a prepared statement
            String query = "delete from products where id=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // binding values
            preparedStmt.setInt(1, (itemID));
            // execute the statement
            preparedStmt.execute();
            con.close();
            output = "Deleted successfully";
        }
        catch (Exception e)
        {
            output = "Error while deleting the item.";
            System.err.println(e.getMessage());
        }
        return true;
    }


}

