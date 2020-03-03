package org.unihh.basecamp.g4.wiki.backend.persistence;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Redirects")
@Table(name = "Redirects")
public class RedirectsEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column
    private int amount;

}
