package by.academy.it.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private boolean useTestDataSource;

    public DataSource(boolean useTestDataSource) throws ClassNotFoundException {
        this.useTestDataSource = useTestDataSource;
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                useTestDataSource ?
                        "jdbc:mysql://localhost:3306/parking_test" :
                        "jdbc:mysql://localhost:3306/parking"
                ,
                "root",
                "root");
    }

}
