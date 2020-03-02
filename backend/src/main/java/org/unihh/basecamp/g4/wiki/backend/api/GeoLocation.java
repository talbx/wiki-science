package org.unihh.basecamp.g4.wiki.backend.api;

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


/**
 * {
 *     "continent": "North America",
 *     "address_format": "{{recipient}}\n{{street}}\n{{city}} {{region_short}} {{postalcode}}\n{{country}}",
 *     "alpha2": "US",
 *     "alpha3": "USA",
 *     "country_code": "1",
 *     "international_prefix": "011",
 *     "ioc": "USA",
 *     "gec": "US",
 *     "name": "United States of America",
 *     "national_destination_code_lengths": [3],
 *     "national_number_lengths": [10],
 *     "national_prefix": "1",
 *     "number": "840",
 *     "region": "Americas",
 *     "subregion": "Northern America",
 *     "world_region": "AMER",
 *     "un_locode": "US",
 *     "nationality": "American",
 *     "postal_code": true,
 *     "unofficial_names": ["United States", "Vereinigte Staaten von Amerika", "États-Unis", "Estados Unidos", "アメリカ合衆国", "Verenigde Staten"],
 *     "languages_official": ["en"],
 *     "languages_spoken": ["en"],
 *     "geo": {
 *         "latitude": 37.09024,
 *         "latitude_dec": "39.44325637817383",
 *         "longitude": -95.712891,
 *         "longitude_dec": "-98.95733642578125",
 *         "max_latitude": 71.5388001,
 *         "max_longitude": -66.885417,
 *         "min_latitude": 18.7763,
 *         "min_longitude": 170.5957,
 *         "bounds": {
 *             "northeast": {
 *                 "lat": 71.5388001,
 *                 "lng": -66.885417
 *             },
 *             "southwest": {
 *                 "lat": 18.7763,
 *                 "lng": 170.5957
 *             }
 *         }
 *     },
 *     "currency_code": "USD",
 *     "start_of_week": "sunday"
 * }
 */