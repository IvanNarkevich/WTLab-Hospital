package main.bsuirlab.service;

import main.bsuirlab.exception.DataBaseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseManager{

    private static DataBaseManager instance = null;
    private Connection connection;

    private boolean isReady;

    private final String url = "jdbc:mysql://localhost/?useTimezone=true&serverTimezone=UTC";
    private String user = "root";
    private String password = "1234";
    private final String DataBaseInitialFilePath = "E:\\Ваня\\Универ\\3 курс\\ВТ\\Lab2\\src\\main\\resources\\DataBase.sql";

    private DataBaseManager() {
    }

    public static DataBaseManager getInstance() {
        if (instance == null) {
            instance = new DataBaseManager();
        }
        return instance;
    }

    public Connection getConnection() throws DataBaseException {
        if (isReady) {
            return connection;
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
                initDataBase();
                isReady = true;
                return connection;
            } catch (ClassNotFoundException | SQLException e) {
                isReady = false;
                throw new DataBaseException(e.getMessage());
            }
        }
    }

    private void initDataBase() throws DataBaseException {

        try {
            Statement statement = connection.createStatement();

            FileReader reader = new FileReader(DataBaseInitialFilePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String sqlCommand;
            StringBuilder buffer = new StringBuilder();
            while ((sqlCommand = bufferedReader.readLine()) != null) {
                buffer.append(sqlCommand);
                if (sqlCommand.contains(";")) {
                    statement.execute(buffer.toString());
                    buffer = new StringBuilder();
                }
            }
        } catch (SQLException | IOException e) {
            throw new DataBaseException(e.getMessage());
        }
    }
}
