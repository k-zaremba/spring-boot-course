package com.sunner.sbdatabases;

import com.sunner.sbdatabases.model.ClientDao;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private ClientDao clientDao;

    public Start(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public void action(){
        clientDao.findALl().forEach(System.out::println);
    }
}
