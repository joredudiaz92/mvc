package com.mvc.example.models;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "items")
@Getter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
}
