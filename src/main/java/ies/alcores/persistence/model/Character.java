package ies.alcores.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "characters")
public class Character {

    @Id
    private String id;

    private int championId;
    private String name;
    private String title;
    @Field("role")
    private List<String> roles;
    private String thumbnailUrl;
}
