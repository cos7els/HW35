package org.teachmeskills.jdbc.db;

import org.teachmeskills.jdbc.data.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Select {
    private static Select select;
    private final Connect connect = Connect.getInstance();

    private Select() {
    }

    public static Select getInstance() {
        if (select == null) {
            select = new Select();
        }
        return select;
    }

    public List<Client> select(int id) {
        List<Client> clients;
        try (PreparedStatement preparedStatement = connect.getConnection().
                prepareStatement("SELECT * FROM hw.clients WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            clients = getList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

    public List<Client> select() {
        List<Client> clients;
        try (PreparedStatement preparedStatement = connect.getConnection().
                prepareStatement("SELECT * FROM hw.clients")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            clients = getList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

    private List<Client> getList(ResultSet resultSet) {
        List<Client> clients = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt(1));
                client.setFirstName(resultSet.getString(2));
                client.setLastName(resultSet.getString(3));
                client.setPhoneNumber(resultSet.getString(4));
                client.setEmail(resultSet.getString(5));
                client.setAddress(resultSet.getString(6));
                clients.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }
}
