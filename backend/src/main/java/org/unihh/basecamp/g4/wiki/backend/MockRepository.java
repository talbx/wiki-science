package org.unihh.basecamp.g4.wiki.backend;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MockRepository {

    List<Category> findTop50OrOrderByAmount() {

        return Arrays.asList(
                Category.of("Fussball", 121),
                Category.of("Prominente in Deutschland", 89),
                Category.of("Essen", 50),
                Category.of("Kriege", 21),
                Category.of("US-Präsidenten", 20),
                Category.of("Zahnarzt", 1));
    }

}
