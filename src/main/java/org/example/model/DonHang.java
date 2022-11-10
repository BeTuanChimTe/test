package org.example.model;

import jakarta.persistence.*;

//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class DonHang implements Serializable, Cloneable {

    @Id
    @Column(columnDefinition = "varchar(10)")
    private String maDonHang;

    @Column(nullable = false)
    private LocalDateTime ngayTaoDonHang;

    @Column(nullable = false)
    private double tongThanhTien;

    @Column(columnDefinition = "nvarchar(255)")
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "maNhanVien", columnDefinition = "varchar(8)", nullable = false)
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "maKhachHang", nullable = false)
    private KhachHang khachHang;

    @OneToMany(mappedBy = "donHang", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<ChiTietDonHang> chiTietDonHangs;
    
    public DonHang() {

    }

    public DonHang(String maDonHang) {
        this.maDonHang = maDonHang;
        chiTietDonHangs =new ArrayList<>();
//        FXCollections.observableArrayList();
    }

    public DonHang(String maDonHang, LocalDateTime ngayTaoDonHang, String ghiChu, NhanVien nhanVien, KhachHang khachHang) {
        this.maDonHang = maDonHang;
        this.ngayTaoDonHang = ngayTaoDonHang;
        this.ghiChu = ghiChu;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        chiTietDonHangs = new ArrayList<>();
//                FXCollections.observableArrayList();
    }

    public DonHang(String maDonHang, LocalDateTime ngayTaoDonHang, String ghiChu, NhanVien nhanVien, KhachHang khachHang, List<ChiTietDonHang> chiTietDonHangs) {
        this.maDonHang = maDonHang;
        this.ngayTaoDonHang = ngayTaoDonHang;
        this.ghiChu = ghiChu;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.chiTietDonHangs = new ArrayList<>(chiTietDonHangs);
//                FXCollections.observableArrayList(chiTietDonHangs);
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public LocalDateTime getNgayTaoDonHang() {
        return ngayTaoDonHang;
    }

    public void setNgayTaoDonHang(LocalDateTime ngayTaoDonHang) {
        this.ngayTaoDonHang = ngayTaoDonHang;
    }

    public double getTongThanhTien() {
        return tongThanhTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public List<ChiTietDonHang> getChiTietDonHangs() {
        return chiTietDonHangs;
    }

    public void setChiTietDonHangs(List<ChiTietDonHang> chiTietDonHangs) {
        this.chiTietDonHangs = chiTietDonHangs;
    }

    public double tinhTongThanhTien() {
        tongThanhTien = 0;
        for (ChiTietDonHang orderDetail : chiTietDonHangs) {
            tongThanhTien += orderDetail.getThanhTien();
        }
        return tongThanhTien;
    }

    public int getSize() {
        return this.chiTietDonHangs.size();
    }

    @Override
    public String toString() {
        return "DonHang{" +
                "maDonHang='" + maDonHang + '\'' +
                ", ngayTaoDonHang=" + ngayTaoDonHang +
                ", tongThanhTien=" + tongThanhTien +
                ", ghiChu='" + ghiChu + '\'' +
                ", nhanVien=" + nhanVien +
                ", khachHang=" + khachHang +
                ", chiTietDonHangs=" + chiTietDonHangs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonHang donHang = (DonHang) o;
        return Objects.equals(maDonHang, donHang.maDonHang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maDonHang);
    }

//    @Override
//    public DonHang clone() throws CloneNotSupportedException {
//        DonHang o = new DonHang();
//        o = (DonHang) super.clone();
//        ArrayList<ChiTietDonHang> orderDetailArrayList = new ArrayList<>();
//        for (ChiTietDonHang orderDetail : chiTietDonHangs) {
//            orderDetailArrayList.add(orderDetail);
//        };
////        List<ChiTietDonHang> orderDetails = FXCollections.observableArrayList((ArrayList<ChiTietDonHang>)orderDetailArrayList.clone());
//        o.setChiTietDonHangs(orderDetails);
//        return o;
//    }
}
