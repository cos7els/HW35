package org.teachmeskills.jdbc.logic;

import org.teachmeskills.jdbc.data.Client;

import javax.servlet.http.HttpServletRequest;

public class ClientCreator {
    private static ClientCreator clientCreator;

    private ClientCreator() {
    }

    public static ClientCreator getInstance() {
        if (clientCreator == null) {
            clientCreator = new ClientCreator();
        }
        return clientCreator;
    }

    public Client createClient(HttpServletRequest request) {
        Client client = new Client();
        client.setFirstName(request.getParameter("firstname"));
        client.setLastName(request.getParameter("lastname"));
        client.setPhoneNumber(request.getParameter("phonenumber"));
        client.setEmail(request.getParameter("email"));
        client.setAddress(request.getParameter("address"));
        return client;
    }

}
