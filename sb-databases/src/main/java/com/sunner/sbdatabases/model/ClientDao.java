package com.sunner.sbdatabases.model;

import java.util.List;

public interface ClientDao {

    void creteClient(Client client);
    List<Client> findALl();
    Client findById(long id);
    List<Client> findByAgeRange(long lower, long upper);
    void updateClient(Client newClient);
    void deleteClient(long id);
}
