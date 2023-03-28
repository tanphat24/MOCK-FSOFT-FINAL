package com.example.taywebapplication.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Set;

@Entity(name="unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer unitId;
    @Column(name="unit_name")
    private String unitName;
    @OneToMany(mappedBy = "unit")
    private Set<DetailIngredient> detailIngredients;

    public Unit() {
    }

    public Unit(Integer unitId, String unitName, Set<DetailIngredient> detailIngredients) {
        this.unitId = unitId;
        this.unitName = unitName;
        this.detailIngredients = detailIngredients;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Set<DetailIngredient> getDetailIngredients() {
        return detailIngredients;
    }

    public void setDetailIngredients(Set<DetailIngredient> detailIngredients) {
        this.detailIngredients = detailIngredients;
    }
}
