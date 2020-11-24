package net.seleucus.wsp.db;

import net.seleucus.wsp.client.WSConnection;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static net.seleucus.wsp.db.WSDatabase.DB_PATH;
import static org.junit.jupiter.api.Assertions.*;

class WSUsersTest {

    @Test
    void getUsersFullNameTest() {
        final String DB_PATH = "webspa-db";
      /*  Class.forName("org.hsqldb.jdbcDriver");
        final Connection wsConnection = DriverManager.getConnection("jdbc:hsqldb:" + DB_PATH);;


        WSUsers wsUsers = new WSUsers(wsConnection);
        wsUsers.getUsersFullNameTest(11);*/

    }
}