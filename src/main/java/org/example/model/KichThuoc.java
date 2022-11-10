package org.example.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class KichThuoc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maKichThuoc;

    @Column(columnDefinition = "nvarchar(32)", nullable = false)
    private String tenKichThuoc;


    public KichThuoc() {

    }

    public KichThuoc(String tenKichThuoc) {
        this.tenKichThuoc = tenKichThuoc;
    }

    public KichThuoc(int maKichThuoc, String tenKichThuoc) {
        this.maKichThuoc = maKichThuoc;
        this.tenKichThuoc = tenKichThuoc;
    }

    public int getMaKichThuoc() {
        return maKichThuoc;
    }

    public void setMaKichThuoc(int maKichThuoc) {
        this.maKichThuoc = maKichThuoc;
    }

    public String getTenKichThuoc() {
        return tenKichThuoc;
    }

    public void setTenKichThuoc(String tenKichThuoc) {
        this.tenKichThuoc = tenKichThuoc;
    }

    @Override
    public String toString() {
        return tenKichThuoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KichThuoc kichThuoc = (KichThuoc) o;
        return maKichThuoc == kichThuoc.maKichThuoc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKichThuoc);
    }
}
