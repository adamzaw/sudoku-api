package com.gmail.adam.zawadka.sudoku.API.model;

import javax.persistence.*;

@Entity
@Table(name = "score")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int time;
    private int level;
    private String nick;

}
