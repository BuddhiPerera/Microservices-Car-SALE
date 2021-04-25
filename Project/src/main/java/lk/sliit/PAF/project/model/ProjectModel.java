package lk.sliit.PAF.project.model;
import lk.sliit.PAF.project.dto.ProjectDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectModel {

  //A common method to connect to the DB
        public static Connection connect()
        {
            Connection con = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");

                //Provide the correct details: DBServer/DBName, username, password
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "dulshan");
            }
            catch (Exception e)
            {e.printStackTrace();}
            return con;
        }
    public int getLastID() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT projectID FROM project ORDER BY projectID DESC LIMIT 1");
        if(resultSet.next()){
            return resultSet.getInt(1);
        }
        else {
            return 0;
        }
    }
        public String insertProject(String pubName, String proName, String Email, String proStatus, String proLink, String proUpDate, String proSubDate, String proDesc)
        {
            String output = "";
            try
            {
                Connection con = connect();
                int id = getLastID();
                if (con == null)
                {return "Error while connecting to the database for inserting."; }
                // create a prepared statement
                String query = " insert into project (`projectID`,`publisherName`,`projectName`,`email`,`status`,`link`,`updatedDate`,`submittedDate`,`Description`)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                // binding values
                preparedStmt.setInt(1, id+1);
                preparedStmt.setString(2, pubName);
                preparedStmt.setString(3, proName);
                preparedStmt.setString(4, Email);
                preparedStmt.setString(5, proStatus);
                preparedStmt.setString(6, proLink);
                preparedStmt.setString(7, proUpDate);
                preparedStmt.setString(8, proSubDate);
                preparedStmt.setString(9, proDesc);
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




    public List<ProjectDTO> listAll() throws Exception {

        Connection con = connect();

        if (con == null)
        {return null; }
        List<ProjectDTO> projects = new ArrayList<>();
        String query = "Select * from project";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                ProjectDTO p = new ProjectDTO();
                p.setProjectID(rs.getInt(1));
                p.setPublisherName(rs.getString(2));
                p.setProjectName(rs.getString(3));
                p.setEmail(rs.getString(4));
                p.setStatus(rs.getString(5));
                p.setLink(rs.getString(6));
                p.setUpdatedDate(rs.getString(7));
                p.setSubmittedDate(rs.getString(8));
                p.setdescription(rs.getString(9));

                projects.add(p);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return projects;
    }








    public String readProject()
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
    public String updateProject(int projectID, String publisherName, String projectName, String email,
                                String status, String link, String updatedDate, String submittedDate, String description)
    {
        String output = "";
        try
        {
            Connection con = connect();
            if (con == null)
            {return "Error while connecting to the database for updating."; }
            // create a prepared statement
            String query = "UPDATE project SET `publisherName`=?,projectName=?,`email`=?,`status`=?, `link`=?, " +
                    "updatedDate=?, `submittedDate`=?, `Description`=? WHERE projectID=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // binding values
            preparedStmt.setString(1, publisherName);
            preparedStmt.setString(2, projectName);
            preparedStmt.setString(3, email);
            preparedStmt.setString(4, status);
            preparedStmt.setString(5, link);
            preparedStmt.setString(6, updatedDate);
            preparedStmt.setString(7, submittedDate);
            preparedStmt.setString(8, description);
            preparedStmt.setInt(9, (projectID));
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
    public boolean deleteProject(String projectID)
    {
        String output = "";
        try
        {
            Connection con = connect();
            if (con == null)
            {return false; }
            // create a prepared statement
            String query = "delete from project where projectID=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // binding values
            preparedStmt.setInt(1, Integer.parseInt(projectID));
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
