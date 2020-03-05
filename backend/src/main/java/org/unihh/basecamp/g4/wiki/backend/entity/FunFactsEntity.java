package org.unihh.basecamp.g4.wiki.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "FUN_FACTS")
@Table(name = "FUN_FACTS")
public class FunFactsEntity {

    @Id
    int id;

    @Column
    int amount;

    @Column
    String title;
}
