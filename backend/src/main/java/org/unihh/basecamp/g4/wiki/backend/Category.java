package org.unihh.basecamp.g4.wiki.backend;

import org.immutables.value.Value;

@Value.Immutable
public interface Category {

    String getName();

    int getAmount();

    static ImmutableCategory.Builder builder() {
        return ImmutableCategory.builder();
    }

    static ImmutableCategory of(String name, int amount){
        return ImmutableCategory.builder().name(name).amount(amount).build();
    }
}
