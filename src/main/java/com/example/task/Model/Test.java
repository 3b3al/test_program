package com.example.task.Model;

import java.util.Map;
import java.util.HashMap;
import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Table(name="test")
@Entity(name ="Test")
@SQLDelete(sql = "UPDATE test SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class Test {

    // public Test( String name,@JsonProperty Map<String, String> manager, Boolean isdeleted) {
    //     this.name = name;
    //     Manager = manager;
    //     this.isdeleted = isdeleted;
    // }

    @Id
    @GeneratedValue(generator = "uuid")
    @UuidGenerator
    private UUID id;
    private String name;
    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private Map<String, String> Manager = new HashMap<>();
    @Column(name = "is_deleted", nullable = false)
    private Boolean isdeleted = false;
    

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Map<String, String> getManager() {
        return Manager;
    }
    public void setManager(Map<String, String> manager) {
        this.Manager = manager;
    }
    public Boolean getIsdeleted() {
        return isdeleted;
    }
    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public void addManager(String key ,String value)
    {
        Manager.put(key, value);
    }

    //     @Override
    // public String toString() {
    //     return new StringJoiner (", ", Test.class.getSimpleName() + "[", "]").add(String.format("id=%s", id)).add(String.format("Manager='%s'", Manager)).toString();
    // }

}
