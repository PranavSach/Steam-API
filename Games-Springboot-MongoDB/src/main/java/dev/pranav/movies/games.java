package dev.pranav.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "games")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class games {
    @Id
    private ObjectId id;
    private Integer appId;
    private String name;
    private Integer playtime_forever;
    private String img_icon_url;
    private String img_logo_url;
    @DocumentReference
    private List<Reviews> reviewIds;
}
