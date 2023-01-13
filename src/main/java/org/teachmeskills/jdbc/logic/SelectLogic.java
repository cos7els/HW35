package org.teachmeskills.jdbc.logic;

import org.teachmeskills.jdbc.data.Client;
import org.teachmeskills.jdbc.db.Select;

import java.util.List;

public class SelectLogic {
    private static SelectLogic selectLogic;
    private final Select select = Select.getInstance();

    private SelectLogic() {}

    public static SelectLogic getInstance() {
        if (selectLogic == null) {
            selectLogic = new SelectLogic();
        }
        return selectLogic;
    }

    public String select(int id) {
        List<Client> clients = select.select(id);
        return getHtml(clients);
    }

    public String select() {
        List<Client> clients = select.select();
        return getHtml(clients);
    }

    private String getHtml(List<Client> clients) {
        StringBuilder clientsHtml = new StringBuilder();
        for (Client c : clients) {
            clientsHtml.append("<p>").append(c).append("</p>");
        }
        return clientsHtml.toString();
    }

}
