package org.unihh.basecamp.g4.wiki.backend.entity;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "LATEST_CONTRIBUTORS")
@Table(name = "LATEST_CONTRIBUTORS")
@AllArgsConstructor
@NoArgsConstructor
public class PremiumContributorsEntity {

    @Id
    @Column
    String username;

    @Nullable
    @Column
    String timestamp;

}
