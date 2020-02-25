package org.unihh.basecamp.g4.wiki;

import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.util.Objects;

@Value.Immutable
public interface Contributor {

    @Nullable
    String getUsername();

    @Nullable
    String getIP();

    @Nullable
    String getTimestamp();

    default String getAccount() {
        if (Objects.nonNull(getUsername())) {
            return getUsername();
        }
        if (Objects.nonNull(getIP())) {
            return getIP();
        }
        return "no-user";
    }
}
