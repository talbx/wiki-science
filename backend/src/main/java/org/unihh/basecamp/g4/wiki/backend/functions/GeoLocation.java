package org.unihh.basecamp.g4.wiki.backend.functions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoLocation {

    String continent;
    String region;
    String subregion;
    String un_locode;
    String ioc;
    String name;

}