package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class NhomQuyen implements Serializable {

    @Id
    @Column(columnDefinition = "varchar(32)")
    private String maNhomQuyen;

    @Column(columnDefinition = "nvarchar(32)", nullable = false)
    private String tenNhomQuyen;

    @OneToMany(mappedBy = "nhomQuyen")
    private List<Quyen> dsQuyen;

    public NhomQuyen() {

    }

    public NhomQuyen(String maNhomQuyen) {
        this.maNhomQuyen = maNhomQuyen;
    }

    public NhomQuyen(String maNhomQuyen, String tenNhomQuyen) {
        this.maNhomQuyen = maNhomQuyen;
        this.tenNhomQuyen = tenNhomQuyen;
    }

    public NhomQuyen(String maNhomQuyen, String tenNhomQuyen, List<Quyen> dsQuyen) {
        this.maNhomQuyen = maNhomQuyen;
        this.tenNhomQuyen = tenNhomQuyen;
        this.dsQuyen = dsQuyen;
    }

    public String getMaNhomQuyen() {
        return maNhomQuyen;
    }

    public void setMaNhomQuyen(String maNhomQuyen) {
        this.maNhomQuyen = maNhomQuyen;
    }

    public String getTenNhomQuyen() {
        return tenNhomQuyen;
    }

    public void setTenNhomQuyen(String tenNhomQuyen) {
        this.tenNhomQuyen = tenNhomQuyen;
    }

    public List<Quyen> getDsQuyen() {
        return dsQuyen;
    }

    public void setDsQuyen(List<Quyen> dsQuyen) {
        this.dsQuyen = dsQuyen;
    }

    @Override
    public String toString() {
        return tenNhomQuyen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhomQuyen nhomQuyen = (NhomQuyen) o;
        return Objects.equals(maNhomQuyen, nhomQuyen.maNhomQuyen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNhomQuyen);
    }
}
