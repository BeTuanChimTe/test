package org.example.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(VaiTroQuyenID.class)
public class VaiTroQuyen implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "maNhomQuyen", columnDefinition = "varchar(32)")
    @JoinColumn(name = "maVaiTro")
    private VaiTroNhomQuyen nhomQuyen;

    @Id
    @ManyToOne
    @JoinColumn(name = "maQuyen", columnDefinition = "varchar(32)")
    private Quyen quyen;

    @Column(nullable = false)
    private boolean trangThai;


    public VaiTroQuyen() {

    }

    public VaiTroQuyen(VaiTroNhomQuyen nhomQuyen, Quyen quyen) {
        this.nhomQuyen = nhomQuyen;
        this.quyen = quyen;
    }

    public VaiTroQuyen(VaiTroNhomQuyen nhomQuyen, Quyen quyen, boolean trangThai) {
        this.nhomQuyen = nhomQuyen;
        this.quyen = quyen;
        this.trangThai = trangThai;
    }

    public VaiTroNhomQuyen getNhomQuyen() {
        return nhomQuyen;
    }

    public void setNhomQuyen(VaiTroNhomQuyen nhomQuyen) {
        this.nhomQuyen = nhomQuyen;
    }

    public Quyen getQuyen() {
        return quyen;
    }

    public void setQuyen(Quyen quyen) {
        this.quyen = quyen;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "VaiTroQuyen{" +
                "nhomQuyen=" + nhomQuyen +
                ", quyen=" + quyen +
                ", trangThai=" + trangThai +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VaiTroQuyen that = (VaiTroQuyen) o;
        return Objects.equals(nhomQuyen, that.nhomQuyen) && Objects.equals(quyen, that.quyen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nhomQuyen, quyen);
    }
}
