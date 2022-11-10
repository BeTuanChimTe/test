package org.example.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(ChiTietDonNhapHangID.class)
public class ChiTietDonNhapHang implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "maDonNhapHang", columnDefinition = "varchar(10)")
    private DonNhapHang donNhapHang;

    @Id
    @ManyToOne
    @JoinColumn(name = "maSanPham", columnDefinition = "varchar(10)")
    private SanPham sanPham;

    @Column(nullable = false)
    private double giaNhap;

    @Column(nullable = false)
    private int soLuong;

    public ChiTietDonNhapHang() {

    }

    public ChiTietDonNhapHang(DonNhapHang donNhapHang, SanPham sanPham, int soLuong) {
        this.donNhapHang = donNhapHang;
        this.sanPham = sanPham;
        this.giaNhap = sanPham.getGiaNhap();
        this.soLuong = soLuong;
    }

    public DonNhapHang getDonNhapHang() {
        return donNhapHang;
    }

    public void setDonNhapHang(DonNhapHang donNhapHang) {
        this.donNhapHang = donNhapHang;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return (soLuong * giaNhap);
    }

    @Override
    public String toString() {
        return "ChiTietDonNhapHang{" +
                "donNhapHang=" + donNhapHang +
                ", sanPham=" + sanPham +
                ", giaNhap=" + giaNhap +
                ", soLuong=" + soLuong +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietDonNhapHang that = (ChiTietDonNhapHang) o;
        return Objects.equals(donNhapHang, that.donNhapHang) && Objects.equals(sanPham, that.sanPham);
    }

    @Override
    public int hashCode() {
        return Objects.hash(donNhapHang, sanPham);
    }
}
