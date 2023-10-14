package com.example.mobilelele.model.enitity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "brands")
//Подобряваме performance-а на app-а, разрешаваме N+1 проблем
@NamedEntityGraph(
        name = "brandWithModels",                       //описание
        attributeNodes = @NamedAttributeNode("models")  //child релация
)
public class BrandEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "brand",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<ModelEntity> models = new ArrayList<>();

    public BrandEntity() {
    }

    public List<ModelEntity> getModels() {
        return models;
    }

    public void setModels(List<ModelEntity> models) {
        this.models = models;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "BrandEntity{" +
                "name='" + name + '\'' +
                ", models=" + models +
                '}';
    }


}
