package org.example.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VaiTroNhomQuyenID implements Serializable {

    private int vaiTro;
    private String nhomQuyen;

    public VaiTroNhomQuyenID() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        VaiTroNhomQuyenID that = (VaiTroNhomQuyenID) o;
        return vaiTro == that.vaiTro && Objects.equals(nhomQuyen, that.nhomQuyen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vaiTro, nhomQuyen);
    }
}
