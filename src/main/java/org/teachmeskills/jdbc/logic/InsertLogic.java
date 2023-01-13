package org.teachmeskills.jdbc.logic;

import org.teachmeskills.jdbc.data.Client;
import org.teachmeskills.jdbc.db.Insert;

import javax.servlet.http.HttpServletRequest;

public class InsertLogic {
    private static InsertLogic insertLogic;
    private final Insert insert = Insert.getInstance();
    private final ClientCreator clientCreator = ClientCreator.getInstance();

    private InsertLogic() {}

    public static InsertLogic getInstance() {
        if (insertLogic == null) {
            insertLogic = new InsertLogic();
        }
        return insertLogic;
    }

    public void insert(HttpServletRequest request) {
        Client client = clientCreator.createClient(request);
        insert.insert(client);
    }
}
