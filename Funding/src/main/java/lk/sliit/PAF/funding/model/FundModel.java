package lk.sliit.PAF.funding.model;
import lk.sliit.PAF.funding.dto.FundDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FundModel {

  //A common method to connect to the DB
        public static Connection connect()
        {
            Connection con = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");

                //Provide the correct details: DBServer/DBName, username, password
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "12345");
            }
            catch (Exception e)
            {e.printStackTrace();}
            return con;
        }
    public int getLastID() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT id FROM fund ORDER BY id DESC LIMIT 1");
        if(resultSet.next()){
            return resultSet.getInt(1);
        }
        else {
            return 0;
        }
    }
        public String insertFund(String fundid,String name, String email, String address, String number, String method,String amount)
        {
            String output = "";
            try
            {
                Connection con = connect();
                int id = getLastID();
                if (con == null)
                {return "Error while connecting to the database for inserting."; }
                // create a prepared statement
                String query = " insert into fund (`id`,`fundID`,`fundName`,`email`,`address`,`contactNumber`,`fundMethod`,`amount`)"
                    + " values (?, ?, ?, ?, ?,?,?,?)";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                // binding values
                preparedStmt.setInt(1, id+1);
                preparedStmt.setString(2, fundid);
                preparedStmt.setString(3, name);
                preparedStmt.setString(4, email);
                preparedStmt.setString(5, address);
                preparedStmt.setString(6, number);
                preparedStmt.setString(7, method);
                preparedStmt.setString(8, amount);


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

    public List<FundDTO> listAll() throws Exception {

        Connection con = connect();
        int id = getLastID();
        if (con == null)
        {return null; }
        List<FundDTO> funds = new ArrayList<>();
        String query = "Select * from fund";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                FundDTO p = new FundDTO();
                p.setId(rs.getInt(1));
                p.setFundID(rs.getString(2));
                p.setFundName(rs.getString(3));
                p.setEmail(rs.getString(4));
                p.setAddress(rs.getString(5));
                p.setContactNumber(rs.getString(6));
                p.setFundMethod(rs.getString(7));
                p.setAmount(rs.getString(8));
                funds.add(p);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return funds;
    }




    public String readFund()
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






            String query = "select * from fund";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // iterate through the rows in the result set
            while (rs.next())
            {
                Integer id = rs.getInt(getLastID());
                String fundID = Integer.toString(rs.getInt("fundID"));
                String fundName = rs.getString("fundName");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String contactNumber = rs.getString("contactNumber");
                String fundMethod = rs.getString("fundMethod");
                String amount = rs.getString("amount");

                // Add into the html table
                output += "<tr><td>" + fundID + "</td>";
                output += "<td>" + fundName + "</td>";
                output += "<td>" + email + "</td>";
                output += "<td>" + address + "</td>";
                output += "<td>" + contactNumber + "</td>";
                output += "<td>" + fundMethod + "</td>";
                output += "<td>" + amount + "</td>";

                // buttons
                output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
                    + "<td><form method='post' action='items.jsp'>"
                    + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
                    + "<input name='itemID' type='hidden' value='" + fundID
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
    public String updateFund(int ID, String fundID, String fundName, String email, String address, String contactNumber, String fundMethod,String amount)
    {
        String output = "";
        try
        {
            Connection con = connect();
            if (con == null)
            {return "Error while connecting to the database for updating."; }
            // create a prepared statement
            String query = "UPDATE fund SET fundID=?,fundName=?,email=?,address=?,contactNumber=?, fundMethod=?, amount=? WHERE id=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // binding values
            preparedStmt.setString(1, fundID);
            preparedStmt.setString(2, fundName);
            preparedStmt.setString(3,email );
            preparedStmt.setString(4, address);
            preparedStmt.setString(5, contactNumber);
            preparedStmt.setString(6, fundMethod);
            preparedStmt.setString(7, amount);
            preparedStmt.setInt(8, ID);

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
    public boolean deleteFund(String fundID)
    {
        String output = "";
        try
        {
            Connection con = connect();
            if (con == null)
            {return false; }
            // create a prepared statement
            String query = "delete from fund where id=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // binding values
            preparedStmt.setInt(1, Integer.parseInt(fundID));
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
