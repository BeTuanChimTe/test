package org.example.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ChiTietPhieuNhapHangID implements Serializable {

    private String phieuNhapHang;
    private String sanPham;

    public ChiTietPhieuNhapHangID() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietPhieuNhapHangID that = (ChiTietPhieuNhapHangID) o;
        return Objects.equals(phieuNhapHang, that.phieuNhapHang) && Objects.equals(sanPham, that.sanPham);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phieuNhapHang, sanPham);
    }
}
