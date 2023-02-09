package ru.job4j.tracker;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Table(name = "items")
@Data
public class Item implements Comparable<Item> {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private LocalDateTime created = LocalDateTime.now();

    private String description;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(int id, String name, LocalDateTime created, String description) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.description = description;
    }



    @Override
    public int compareTo(Item another) {
        return Integer.compare(id, another.id);
    }
}