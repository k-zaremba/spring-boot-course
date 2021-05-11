package com.sunner.sbdatabases.controller;

import com.sunner.sbdatabases.model.AgeHolder;
import com.sunner.sbdatabases.model.Client;
import com.sunner.sbdatabases.model.ClientDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clients")
public class ClientController {

    ClientDao clientDao;
    Logger logger;

    @Autowired
    public ClientController(ClientDao clientDao) {
        this.clientDao = clientDao;
        this.logger = LoggerFactory.getLogger(ClientController.class);
    }

    @GetMapping("/view")
    public String getAll(Model model){
        model.addAttribute("dbConnector", clientDao);
        model.addAttribute("ageHolder", new AgeHolder());
        return "viewClients";
    }

    @GetMapping("/form/add")
    public String getAdditionForm(Model model){
        model.addAttribute("newClient", new Client());
        return "formAddClient";
    }

    @GetMapping("/form/delete")
    public String getDeletionForm(Model model){
        model.addAttribute("newClient", new Client());
        return "formDeleteClient";
    }

    @PostMapping("/add")
    public String addClient(@ModelAttribute Client newClient){
        clientDao.creteClient(newClient);
        logger.info("Added client to database. Client id: " + newClient.getId());
        return "redirect:/clients/form/add";
    }

    @PostMapping("/delete")
    public String deleteClient(@ModelAttribute Client newClient){
        clientDao.deleteClient(newClient.getId());
        logger.info("Removed client from database. Client id: " + newClient.getId());
        return "redirect:/clients/form/delete";
    }

    @PostMapping("/view/byAge")
    public String getByAgeRange(Model model, @ModelAttribute AgeHolder ageHolder){
        model.addAttribute("dbConnector", clientDao);
        model.addAttribute("ageHolder", new AgeHolder());
        model.addAttribute("lower", ageHolder.getLower());
        model.addAttribute("upper", ageHolder.getUpper());
        return "viewClientsByAge";
    }

}
