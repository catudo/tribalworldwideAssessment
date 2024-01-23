package com.example.testassesment.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RandomObject {
    /**
     *  "created_at": "2020-01-05 13:42:25.352697",
     *   "icon_url": "https://assets.chucknorris.host/img/avatar/chuck-norris.png",
     *   "id": "NhalBjqFS6COQsskeoWhOQ",
     *   "updated_at": "2020-01-05 13:42:25.352697",
     *   "url": "https://api.chucknorris.io/jokes/NhalBjqFS6COQsskeoWhOQ",
     *   "value": "Chuck Norris can create a rock so heavy that he couldn't lift it, and then lift it."
     * }
     */
    @JsonProperty("created_at")
    public String createdAt;
    @JsonProperty("icon_url")
    public String iconUrl;
    public String id;
    @JsonProperty("updated_at")
    public String updatedAt;

    public String url;
    public String value;

    public ArrayList<String> categories;



}
