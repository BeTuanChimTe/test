package org.example.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class NhaCungCap implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maNhaCungCap;

    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    private String tenNhaCungCap;

    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String sdt;

    @Column(columnDefinition = "varchar(64)", nullable = false)
    private String email;

    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    private String diaChi;

    public NhaCungCap() {

    }

    public NhaCungCap(String tenNhaCungCap, String sdt, String email, String diaChi) {
        this.tenNhaCungCap = tenNhaCungCap;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
    }

    public NhaCungCap(int maNhaCungCap, String tenNhaCungCap, String sdt, String email, String diaChi) {
        this.maNhaCungCap = maNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
    }

    public int getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(int maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return tenNhaCungCap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhaCungCap that = (NhaCungCap) o;
        return maNhaCungCap == that.maNhaCungCap;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNhaCungCap);
    }
}
