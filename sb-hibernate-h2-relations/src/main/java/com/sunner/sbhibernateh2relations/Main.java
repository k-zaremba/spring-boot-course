package com.sunner.sbhibernateh2relations;

import com.sunner.sbhibernateh2relations.model.Backpack;
import com.sunner.sbhibernateh2relations.model.Notepad;
import com.sunner.sbhibernateh2relations.repo.BackpackRepo;
import com.sunner.sbhibernateh2relations.repo.NotepadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

// Instances can be added through repo
//@Service
public class Main {

    @Autowired
    public Main(BackpackRepo backpackRepo, NotepadRepo notepadRepo) {
        Backpack b1 = new Backpack("Nike");
        Backpack b2 = new Backpack("Adidas");

        Notepad n1 = new Notepad("Bio");
        Notepad n2 = new Notepad("History");

        backpackRepo.save(b1);
        backpackRepo.save(b2);


        n1.setBackpack(backpackRepo.getOne(1L));
        n2.setBackpack(b2);

        notepadRepo.save(n1);
        notepadRepo.save(n2);

    }
}
