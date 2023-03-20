package com.github.normallib.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class SQLUtil {
    private final Connection conn;

    public SQLUtil(String url, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, user, password);
    }

    public <T> Stream<T> query(String sql, Function<ResultSet, T> mapper) throws SQLException {
        List<T> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(mapper.apply(rs));
            }
        }
        return list.stream();
    }

    public void execute(String sql, Consumer<PreparedStatement> preparer) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            preparer.accept(stmt);
            stmt.executeUpdate();
        }
    }

    public void close() throws SQLException {
        conn.close();
    }

}
