package org.unihh.basecamp.g4.wiki.jobs;

import org.immutables.value.Value;

import javax.annotation.Nullable;

@Value.Immutable
public interface Article {

    @Nullable
    String getTitle();


}
