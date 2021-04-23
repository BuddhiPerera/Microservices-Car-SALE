package lk.sliit.PAF.user.model;

import lk.sliit.PAF.user.dto.AdminDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AdminModel {
    private static AdminModel adminModelInstance;

    public static AdminModel getInstance(){
        if(adminModelInstance == null){
            adminModelInstance = new AdminModel();
        }
        return adminModelInstance;
    }

    public static Connection connect(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "1234");
        }catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public List<AdminDTO> findAllResearchers() throws SQLException {
        Connection connection = connect();
        if(connection == null){
            return null;
        }
        List<AdminDTO> adminDTOS = new ArrayList<>();
        String query = "SELECT * FROM researchers";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            AdminDTO adminDTO = new AdminDTO();
            adminDTO.setId(resultSet.getInt(1));
            adminDTO.setfName(resultSet.getString(2));
            adminDTO.setlName(resultSet.getString(3));
            adminDTO.setEmail(resultSet.getString(4));
            adminDTO.setContactNo(resultSet.getString(5));
            adminDTO.setAddress(resultSet.getString(6));
            adminDTO.setZipCode(resultSet.getString(7));
            adminDTO.setRate(resultSet.getString(8));
            adminDTO.setPassword(resultSet.getString(9));

            adminDTOS.add(adminDTO);
        }
        return  adminDTOS;
    }

    public boolean deleteResearcher(int id) throws SQLException {
        Connection connection = connect();
        if(connection == null){
            return false;
        }
        String query = "DELETE FROM researchers WHERE `id` = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
        connection.close();
        return true;
    }
}
