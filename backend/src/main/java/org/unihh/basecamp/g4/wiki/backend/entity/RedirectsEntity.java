package org.unihh.basecamp.g4.wiki.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "Redirects")
@Table(name = "Redirects")
@AllArgsConstructor
@NoArgsConstructor
public class RedirectsEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column
    private int amount;

}
