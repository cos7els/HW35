package org.teachmeskills.jdbc.db;

import org.teachmeskills.jdbc.data.Client;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    private static Insert insert;
    private final Connect connect = Connect.getInstance();

    private Insert() {}

    public static Insert getInstance() {
        if (insert == null) {
            insert = new Insert();
        }
        return insert;
    }

    public void insert(Client client) {
        try (PreparedStatement preparedStatement = connect.getConnection().
                prepareStatement("INSERT INTO hw.clients (first_name, last_name, phone_number, email, address) " +
                        "VALUES (?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getPhoneNumber());
            preparedStatement.setString(4, client.getEmail());
            preparedStatement.setString(5, client.getAddress());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
