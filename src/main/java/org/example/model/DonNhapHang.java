package org.example.model;

import jakarta.persistence.*;
//import javafx.collections.FXCollections;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
public class DonNhapHang implements Serializable {

    @Id
    @Column(columnDefinition = "varchar(10)")
    private String maDonNhapHang;

    @Column(nullable = false)
    private LocalDateTime ngayTao;

    @Column(nullable = false)
    private DonNhapHangStatus trangThai;

    @Column(nullable = false)
    private double tongTien;

    @Column(nullable = false)
    private double giamGia;

    @Column(nullable = false)
    private double phuThu;

    @Column(nullable = false)
    private double VAT;

    @Column(nullable = false)
    private double phiVanChuyen;

    @Column(nullable = false)
    private double tongThanhToan;

    @Column(nullable = false)
    private int tongSoLuong;

    @Column(nullable = false)
    private int soLuongConLai;

    @Column(nullable = false)
    private double daThanhToan;

    @Column(nullable = false)
    private double congNo;

    @Column(columnDefinition = "nvarchar(255)")
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "maNhanVienTaoDon", nullable = false)
    private NhanVien nhanVienTaoDon;

    @ManyToOne
    @JoinColumn(name = "maNhaCungCap", nullable = false)
    private NhaCungCap nhaCungCap;

    @OneToMany(mappedBy = "donNhapHang", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<ChiTietDonNhapHang> chiTietDonNhapHangs;


    public DonNhapHang() {

    }

    public DonNhapHang(String maDonNhapHang) {
        this.maDonNhapHang = maDonNhapHang;
        this.chiTietDonNhapHangs = new ArrayList<>();
//        FXCollections.observableArrayList();
    }

    public DonNhapHang(LocalDateTime ngayTao, DonNhapHangStatus trangThai,
                       NhanVien nhanVienTaoDon, NhaCungCap nhaCungCap, ChiTietDonNhapHang ...chiTietDonNhapHangs) {
        this(null, ngayTao, trangThai, nhanVienTaoDon, nhaCungCap, 0, 0, 0, 0, 0, null, chiTietDonNhapHangs);
    }

    public DonNhapHang(LocalDateTime ngayTao, DonNhapHangStatus trangThai, NhanVien nhanVienTaoDon, NhaCungCap nhaCungCap,
                       double giamGia, double phuThu, double VAT, double phiVanChuyen, double daThanhToan, String ghiChu,
                       ChiTietDonNhapHang ...chiTietDonNhapHangs) {
        this(null, ngayTao, trangThai, nhanVienTaoDon, nhaCungCap, giamGia, phuThu, VAT, phiVanChuyen, daThanhToan, ghiChu, chiTietDonNhapHangs);
    }

    public DonNhapHang(String maDonNhapHang, LocalDateTime ngayTao, DonNhapHangStatus trangThai,
                       NhanVien nhanVienTaoDon, NhaCungCap nhaCungCap, ChiTietDonNhapHang ...chiTietDonNhapHangs) {
        this(maDonNhapHang, ngayTao, trangThai, nhanVienTaoDon, nhaCungCap, 0, 0, 0, 0, 0, null, chiTietDonNhapHangs);
    }

    public DonNhapHang(String maDonNhapHang, LocalDateTime ngayTao, DonNhapHangStatus trangThai,
                       NhanVien nhanVienTaoDon, NhaCungCap nhaCungCap, List<ChiTietDonNhapHang> chiTietDonNhapHangs) {
        this(maDonNhapHang, ngayTao, trangThai, nhanVienTaoDon, nhaCungCap, 0, 0, 0, 0, 0, null, chiTietDonNhapHangs);
    }

    public DonNhapHang(String maDonNhapHang, LocalDateTime ngayTao, DonNhapHangStatus trangThai, NhanVien nhanVienTaoDon, NhaCungCap nhaCungCap,
                       double giamGia, double phuThu, double VAT, double phiVanChuyen, double daThanhToan, String ghiChu,
                       ChiTietDonNhapHang ...chiTietDonNhapHangs) {
        this.maDonNhapHang = maDonNhapHang;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.nhanVienTaoDon = nhanVienTaoDon;
        this.nhaCungCap = nhaCungCap;
        this.giamGia = giamGia;
        this.phuThu = phuThu;
        this.VAT = VAT;
        this.phiVanChuyen = phiVanChuyen;
        this.daThanhToan = daThanhToan;
        this.ghiChu = ghiChu;
        this.chiTietDonNhapHangs = new ArrayList<>(List.of(chiTietDonNhapHangs));
//                FXCollections.observableArrayList(chiTietDonNhapHangs);
    }

    public DonNhapHang(String maDonNhapHang, LocalDateTime ngayTao, DonNhapHangStatus trangThai, NhanVien nhanVienTaoDon, NhaCungCap nhaCungCap,
                       double giamGia, double phuThu, double VAT, double phiVanChuyen, double daThanhToan, String ghiChu,
                       List<ChiTietDonNhapHang> chiTietDonNhapHangs) {
        this.maDonNhapHang = maDonNhapHang;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.nhanVienTaoDon = nhanVienTaoDon;
        this.nhaCungCap = nhaCungCap;
        this.giamGia = giamGia;
        this.phuThu = phuThu;
        this.VAT = VAT;
        this.phiVanChuyen = phiVanChuyen;
        this.daThanhToan = daThanhToan;
        this.ghiChu = ghiChu;
        this.chiTietDonNhapHangs = new ArrayList<>(chiTietDonNhapHangs) ;
//                FXCollections.observableArrayList(chiTietDonNhapHangs);
    }

    public String getMaDonNhapHang() {
        return maDonNhapHang;
    }

    public void setMaDonNhapHang(String maDonNhapHang) {
        this.maDonNhapHang = maDonNhapHang;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public DonNhapHangStatus getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(DonNhapHangStatus trangThai) {
        this.trangThai = trangThai;
    }

    public NhanVien getNhanVienTaoDon() {
        return nhanVienTaoDon;
    }

    public void setNhanVienTaoDon(NhanVien nhanVienTaoDon) {
        this.nhanVienTaoDon = nhanVienTaoDon;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public double tinhTongThanhToan() {
        double tongThanhToan = (tongTien + phuThu - giamGia + phiVanChuyen) * (VAT / 100 + 1);
        this.tongThanhToan = tongThanhToan;
        return tongThanhToan;
    }

    public int tinhTongSoLuong() {
        int tongSoLuong = 0;
        for(ChiTietDonNhapHang chiTietDonNhapHang : chiTietDonNhapHangs) {
            tongSoLuong += chiTietDonNhapHang.getSoLuong();
        }
        this.tongSoLuong = tongSoLuong;
        return tongSoLuong;
    }

    public int tinhSoLuongConLai() {
        int soLuongConLai = 0;
        this.soLuongConLai = soLuongConLai;
        return soLuongConLai;
    }

    public double getTongThanhToan() {
        return tongThanhToan;
    }

    public int getTongSoLuong() {
        return tongSoLuong;
    }

    public int getSoLuongConLai() {
        return soLuongConLai;
    }

    public double getTongTien() {
        return tongTien;
    }

    public double tinhTongTien() {
        double tongTien = 0;
        for(ChiTietDonNhapHang chiTietDonNhapHang : chiTietDonNhapHangs) {
            tongTien += chiTietDonNhapHang.getSoLuong() * chiTietDonNhapHang.getGiaNhap();
        };
        this.tongTien = tongTien;
        return tongTien;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public double getPhuThu() {
        return phuThu;
    }

    public void setPhuThu(double phuThu) {
        this.phuThu = phuThu;
    }

    public double getVAT() {
        return VAT;
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }

    public double getPhiVanChuyen() {
        return phiVanChuyen;
    }

    public void setPhiVanChuyen(double phiVanChuyen) {
        this.phiVanChuyen = phiVanChuyen;
    }

    public double getCongNo() {
        return congNo;
    }

    public double tinhCongNo() {
        double congNo = tongThanhToan - daThanhToan;
        this.congNo = congNo;
        return congNo;
    }

    public double getDaThanhToan() {
        return daThanhToan;
    }

    public void setDaThanhToan(double daThanhToan) {
        this.daThanhToan = daThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public List<ChiTietDonNhapHang> getChiTietDonNhapHangs() {
        return chiTietDonNhapHangs;
    }

    public void setChiTietDonNhapHangs(List<ChiTietDonNhapHang> chiTietDonNhapHangs) {
        this.chiTietDonNhapHangs = chiTietDonNhapHangs;
        tinhTongThanhToan();
        tinhTongSoLuong();
        tinhSoLuongConLai();
    }

    public void setChiTietDonNhapHangs(ChiTietDonNhapHang ...chiTietDonNhapHangs) {
        this.chiTietDonNhapHangs = Arrays.asList(chiTietDonNhapHangs);
        tinhTongThanhToan();
        tinhTongSoLuong();
        tinhSoLuongConLai();
    }

    @Override
    public String toString() {
        return "DonNhapHang{" +
                "maDonNhapHang='" + maDonNhapHang + '\'' +
                ", ngayTao=" + ngayTao +
                ", trangThai=" + trangThai +
                ", tongTien=" + tongTien +
                ", giamGia=" + giamGia +
                ", phuThu=" + phuThu +
                ", VAT=" + VAT +
                ", phiVanChuyen=" + phiVanChuyen +
                ", tongThanhToan=" + tongThanhToan +
                ", tongSoLuong=" + tongSoLuong +
                ", soLuongConLai=" + soLuongConLai +
                ", daThanhToan=" + daThanhToan +
                ", congNo=" + congNo +
                ", ghiChu='" + ghiChu + '\'' +
                ", nhanVienTaoDon=" + nhanVienTaoDon +
                ", nhaCungCap=" + nhaCungCap +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonNhapHang that = (DonNhapHang) o;
        return Objects.equals(maDonNhapHang, that.maDonNhapHang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maDonNhapHang);
    }
}
