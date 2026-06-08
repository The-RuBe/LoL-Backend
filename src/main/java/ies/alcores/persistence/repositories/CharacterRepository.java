package ies.alcores.persistence.repositories;

import ies.alcores.persistence.model.Character;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CharacterRepository extends MongoRepository<Character, String> {
    @Query("{ \"role.1\": { $exists: true } }")
    List<Character> findCharacterWithTwoRoles();
}