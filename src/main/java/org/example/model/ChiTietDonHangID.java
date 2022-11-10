package org.example.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ChiTietDonHangID implements Serializable {

    private String donHang;
    private String sanPham;

    public ChiTietDonHangID() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietDonHangID that = (ChiTietDonHangID) o;
        return Objects.equals(donHang, that.donHang) && Objects.equals(sanPham, that.sanPham);
    }

    @Override
    public int hashCode() {
        return Objects.hash(donHang, sanPham);
    }
}
