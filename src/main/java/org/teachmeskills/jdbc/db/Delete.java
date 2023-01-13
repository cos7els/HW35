package org.teachmeskills.jdbc.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    private static Delete delete;
    private final Connect connect = Connect.getInstance();

    private Delete() {
    }

    public static Delete getInstance() {
        if (delete == null) {
            delete = new Delete();
        }
        return delete;
    }

    public void delete(int id) {
        try (PreparedStatement preparedStatement = connect.getConnection().
                prepareStatement("DELETE FROM hw.clients WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete() {
        try (PreparedStatement preparedStatement = connect.getConnection().
                prepareStatement("TRUNCATE TABLE hw.clients")) {
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
