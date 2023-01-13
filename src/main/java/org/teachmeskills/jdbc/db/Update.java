package org.teachmeskills.jdbc.db;

import org.teachmeskills.jdbc.data.Client;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    private static final Update update = new Update();
    private final Connect connect = Connect.getInstance();
    private final Select select = Select.getInstance();

    public static Update getInstance() {
        return update;
    }

    private Update() {
    }

    public void update(int id, Client client) {
        try (PreparedStatement preparedStatement = connect.getConnection().
                prepareStatement("UPDATE hw.clients SET first_name = ?, last_name = ?, phone_number = ?, " +
                        "email = ?, address = ? WHERE id = ?")) {
            Client oldClient = select.select(id).get(0);
            preparedStatement.setString(1, client.getFirstName().equals("") ? oldClient.getFirstName() : client.getFirstName());
            preparedStatement.setString(2, client.getLastName().equals("") ? oldClient.getLastName() : client.getLastName());
            preparedStatement.setString(3, client.getPhoneNumber().equals("") ? oldClient.getPhoneNumber() : client.getPhoneNumber());
            preparedStatement.setString(4, client.getEmail().equals("") ? oldClient.getEmail() : client.getEmail());
            preparedStatement.setString(5, client.getAddress().equals("") ? oldClient.getAddress() : client.getAddress());
            preparedStatement.setInt(6, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
