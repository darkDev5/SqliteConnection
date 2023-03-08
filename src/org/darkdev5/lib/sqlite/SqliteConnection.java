package org.darkdev5.lib.sqlite;

import lombok.Getter;
import lombok.Setter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author darkDev5
 * @version 1.0
 * @since 17
 */
public @Getter class SqliteConnection {
    private Connection connection;
    private @Setter String path;

    public SqliteConnection(String path) {
        this.path = path;
    }

    /**
     * Connects to the sqlite database and initialize the connection.
     * @param showException If exception occurred enable this to print it's stack trace.
     * @return Returns true if connection was successful and false if it failed.
     */
    public boolean connect(boolean showException) {
        try {
            if (!Files.exists(Path.of(path))) {
                return false;
            }

            connection = DriverManager.getConnection("jdbc:sqlite:" + path);
            return true;
        } catch (Exception ex) {
            if (showException) {
                ex.printStackTrace();
            }

            return false;
        }
    }
}
