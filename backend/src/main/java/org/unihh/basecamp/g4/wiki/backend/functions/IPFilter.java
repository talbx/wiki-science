package org.unihh.basecamp.g4.wiki.backend.functions;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Takes a string and checks if it
 * has the format of an IPV4 or IPV6
 * address. This is needed to make sure
 * that the geolocation api can succeed
 */
@Component
public class IPFilter implements Predicate<String> {

    public static final String IPV4_REGEX = "\\A(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\z";
    public static final String IPV6_HEX4DECCOMPRESSED_REGEX = "\\A((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?) ::((?:[0-9A-Fa-f]{1,4}:)*)(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\z";
    public static final String IPV6_6HEX4DEC_REGEX = "\\A((?:[0-9A-Fa-f]{1,4}:){6,6})(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\z";
    public static final String IPV6_HEXCOMPRESSED_REGEX = "\\A((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)\\z";
    public static final String IPV6_REGEX = "\\A(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}\\z";

    @Override
    public boolean test(final String ip) {
        final Pattern pattern1 = Pattern.compile(IPV4_REGEX);
        final Pattern pattern2 = Pattern.compile(IPV6_REGEX);
        final Pattern pattern3 = Pattern.compile(IPV6_HEXCOMPRESSED_REGEX);
        final Pattern pattern4 = Pattern.compile(IPV6_6HEX4DEC_REGEX);
        final Pattern pattern5 = Pattern.compile(IPV6_HEX4DECCOMPRESSED_REGEX);

        final Matcher matcher1 = pattern1.matcher(ip);
        final Matcher matcher2 = pattern2.matcher(ip);
        final Matcher matcher3 = pattern3.matcher(ip);
        final Matcher matcher4 = pattern4.matcher(ip);
        final Matcher matcher5 = pattern5.matcher(ip);

        return Stream.of(matcher1, matcher2, matcher3, matcher4, matcher5)
                .anyMatch(Matcher::matches);
    }
}
