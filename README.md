# SqliteConnection
Connect easily to any sqlite database.
This library doesn't support sqlite3 encryption.

## Usage
Connect fast.

```java
var sqliteConnection = new SqliteConnection("file.db");

if (sqliteConnection.connect()) {
    System.out.println(sqliteConnection.getConnection());
    System.out.println(sqliteConnection.getPath());
} else {
    System.out.println("Connection failed");
}
```
