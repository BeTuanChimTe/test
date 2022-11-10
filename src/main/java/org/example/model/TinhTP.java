package org.example.model;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class TinhTP implements Serializable {

    @Id
    @Column(columnDefinition = "nvarchar(32)")
    @SerializedName(value = "code")

    private String id;

    @Column(columnDefinition = "nvarchar(32)")
    private String name;

    @Column(columnDefinition = "nvarchar(32)")
    private String slug;

    @Column(columnDefinition = "nvarchar(32)")
    private String type;

    @SerializedName(value = "name_with_type")
    @Column(columnDefinition = "nvarchar(32)")
    private String nameWithType;

    @SerializedName(value = "quan-huyen")
    @OneToMany(mappedBy = "tinhTP", fetch = FetchType.LAZY)
    private List<QuanHuyen> dsQuanHuyen = new ArrayList<>();

    public TinhTP(String id) {
        this.id = id;
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        TinhTP tinhTP = (TinhTP) o;
//        return  id == tinhTP.getId();
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
    @Override
    public String toString() {
        return nameWithType;
    }

    public TinhTP(String id, String name, String slug, String type, String nameWithType, List<QuanHuyen> dsQuanHuyen) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.type = type;
        this.nameWithType = nameWithType;
        this.dsQuanHuyen = dsQuanHuyen;
    }

    public TinhTP() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameWithType() {
        return nameWithType;
    }

    public void setNameWithType(String nameWithType) {
        this.nameWithType = nameWithType;
    }

    public List<QuanHuyen> getDsQuanHuyen() {
        return dsQuanHuyen;
    }

    public void setDsQuanHuyen(List<QuanHuyen> dsQuanHuyen) {
        this.dsQuanHuyen = dsQuanHuyen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TinhTP tinhTP = (TinhTP) o;
        return Objects.equals(id, tinhTP.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
