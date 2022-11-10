package org.example.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class SanPham implements Serializable {

    @Id
    @Column(columnDefinition = "varchar(10)")
    private String maSanPham;

    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    private String tenSanPham;

    @Column(nullable = false)
    private double giaNhap;

    @Column(nullable = false)
    private double giaBan;

    @Column(columnDefinition = "nvarchar(MAX)")
    private String moTa;

    @Column(columnDefinition = "text")
    private String hinhAnh;

    @Column(nullable = false)
    private int soLuong;

    @ManyToOne
    @JoinColumn(name = "maDanhMuc", columnDefinition = "varchar(10)", nullable = false)
    private DanhMuc danhMuc;

    @ManyToOne
    @JoinColumn(name = "maMau", nullable = false)
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "maKichThuoc", nullable = false)
    private KichThuoc kichThuoc;

    @ManyToOne
    @JoinColumn(name = "maThuongHieu", nullable = false)
    private ThuongHieu thuongHieu;


    public SanPham() {

    }

    public SanPham(String tenSanPham, double giaNhap, double giaBan, String moTa, String hinhAnh, int soLuong,
                   DanhMuc danhMuc, MauSac mauSac, KichThuoc kichThuoc, ThuongHieu thuongHieu) {
        this.tenSanPham = tenSanPham;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
        this.soLuong = soLuong;
        this.danhMuc = danhMuc;
        this.mauSac = mauSac;
        this.kichThuoc = kichThuoc;
        this.thuongHieu = thuongHieu;
    }

    public SanPham(String maSanPham, String tenSanPham, double giaNhap, double giaBan, String moTa, String hinhAnh, int soLuong,
                   DanhMuc danhMuc, MauSac mauSac, KichThuoc kichThuoc, ThuongHieu thuongHieu) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
        this.soLuong = soLuong;
        this.danhMuc = danhMuc;
        this.mauSac = mauSac;
        this.kichThuoc = kichThuoc;
        this.thuongHieu = thuongHieu;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public KichThuoc getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(KichThuoc kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public ThuongHieu getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(ThuongHieu thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    @Override
    public String toString() {
        return maSanPham + '\t' + tenSanPham;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SanPham sanPham = (SanPham) o;
        return Objects.equals(maSanPham, sanPham.maSanPham);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSanPham);
    }
}
