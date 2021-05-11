package com.sunner.sbdatabases.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ClientDaoImpl implements ClientDao{

    JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void creteClient(Client client) {
        String sql = "INSERT INTO client VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql, client.getId(), client.getName(), client.getSurename(), client.getAge());
    }

    @Override
    public List<Client> findALl() {
        String sql = "SELECT * FROM client";
        List<Client> resultList = new ArrayList<>();
        List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(sql);
        queryForList.forEach(obj -> resultList.add(new Client(
                Long.parseLong(String.valueOf(obj.get("id"))),
                String.valueOf(obj.get("name")),
                String.valueOf(obj.get("surename")),
                Long.parseLong(String.valueOf(obj.get("age")))
        )));
        return resultList;
    }

    @Override
    public Client findById(long id) {
        String sql = "SELECT * FROM client WHERE client.id = ?";
        Client client = jdbcTemplate.queryForObject(sql, (rs, i) -> new Client(rs.getLong("id"),
                rs.getString("name"), rs.getString("surename"), rs.getLong("age")), id);
        return client;
    }

    @Override
    public List<Client> findByAgeRange(long lower, long upper) {
        String sql = "SELECT * FROM client WHERE client.age BETWEEN ? AND ?";
        List<Client> resultList = new ArrayList<>();
        List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(sql, lower, upper);
        queryForList.forEach(obj -> resultList.add(new Client(
                Long.parseLong(String.valueOf(obj.get("id"))),
                String.valueOf(obj.get("name")),
                String.valueOf(obj.get("surename")),
                Long.parseLong(String.valueOf(obj.get("age")))
        )));
        return resultList;
    }

    @Override
    public void updateClient(Client newClient) {
        String sql = "UPDATE client SET client.name = ?, client.surename = ?, client.age = ? WHERE client.id = ?";
        jdbcTemplate.update(sql, newClient.getName(), newClient.getSurename(), newClient.getAge(), newClient.getId());
    }

    @Override
    public void deleteClient(long id) {
        String sql = "DELETE FROM client WHERE client.id = ?";
        jdbcTemplate.update(sql, id);
    }
}
