package org.unihh.basecamp.g4.wiki.backend;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MockRepository {

    List<CategoryEntity> findTop50OrOrderByAmount() {

        return Arrays.asList(
                new CategoryEntity("Fussball", 121),
                new CategoryEntity("Prominente in Deutschland", 89),
                new CategoryEntity("Essen", 50),
                new CategoryEntity("Kriege", 21),
                new CategoryEntity("US-Präsidenten", 20),
                new CategoryEntity("Zahnarzt", 1));
    }
}
