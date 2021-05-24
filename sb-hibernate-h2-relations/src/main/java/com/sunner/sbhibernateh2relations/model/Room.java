package com.sunner.sbhibernateh2relations.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_number")
    private int roomNumber;

    @OneToOne
    private Professor professor;

    @ManyToMany(mappedBy = "roomSet")
    private Set<Cleaner> cleanerSet;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Room() {
    }

    public Set<Cleaner> getCleanerSet() {
        return cleanerSet;
    }

    public void setCleanerSet(Set<Cleaner> cleanerSet) {
        this.cleanerSet = cleanerSet;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
