package org.teachmeskills.jdbc.logic;

import org.teachmeskills.jdbc.data.Client;
import org.teachmeskills.jdbc.db.Update;

import javax.servlet.http.HttpServletRequest;

public class UpdateLogic {
    private static UpdateLogic updateLogic;
    private final Update update = Update.getInstance();
    private final ClientCreator clientCreator = ClientCreator.getInstance();

    private UpdateLogic() {}

    public static UpdateLogic getInstance() {
        if (updateLogic == null) {
            updateLogic = new UpdateLogic();
        }
        return updateLogic;
    }

    public void update(HttpServletRequest request) {
        Client client = clientCreator.createClient(request);
        int id = Integer.parseInt(request.getParameter("updateid"));
        update.update(id, client);
    }
}
