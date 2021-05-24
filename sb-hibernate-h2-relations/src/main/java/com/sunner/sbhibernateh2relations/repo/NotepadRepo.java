package com.sunner.sbhibernateh2relations.repo;

import com.sunner.sbhibernateh2relations.model.Notepad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotepadRepo extends JpaRepository<Notepad, Long> {
}
