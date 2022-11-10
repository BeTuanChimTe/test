package org.example.dao;

//import com.example.fashionshop.model.DanhMuc;
//import com.example.fashionshop.model.SanPham;
//import com.example.fashionshop.utils.DBUtils;
//import com.example.fashionshop.utils.HibernateUtlis;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import org.example.model.DanhMuc;
import org.example.model.SanPham;
import org.example.utlis.DBUtils;
import org.example.utlis.HibernateUtlis;
import org.example.utlis.IDUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {

    private static String className = SanPham.class.getName();

    public  List<SanPham> getAllSanPham() {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        List<SanPham> dsSanPham = null;
        try {
            transaction.begin();
            String selectQuery = "select sp from " + className + " sp";
            Query<SanPham> query = session.createQuery(selectQuery, SanPham.class);
            dsSanPham = new ArrayList(query.getResultList());
//                    FXCollections.observableArrayList(query.getResultList());
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return dsSanPham;
    }

    public  SanPham getSanPham(String maSanPham) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        SanPham sanPham = null;
        try {
            transaction.begin();
            String selectQuery = "select sp from " + className + " sp where sp.maSanPham='" + maSanPham + "'";
            Query<SanPham> query = session.createQuery(selectQuery, SanPham.class);
            sanPham = query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return sanPham;
    }

    public  boolean addSanPham(SanPham sanPham) {
        sanPham.setMaSanPham(IDUtils.createMaSanPham());
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public  boolean updateSanPham(SanPham sanPham) {

        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(sanPham);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public  boolean mergeSanPham(SanPham sanPham) {
        try {
            if (sanPham.getMaSanPham()== null || sanPham.getMaSanPham().isEmpty() == true)
                sanPham.setMaSanPham(IDUtils.createMaSanPham());
        }catch (Exception exception){
            exception.printStackTrace();
        }
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.merge(sanPham);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public  boolean removeSanPham(SanPham sanPham) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.delete(sanPham);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public  List<SanPham> getAllSanPhamFromDanhMuc(DanhMuc danhMuc, int top) {
        List<String> dsMaSanPham = new ArrayList<>();
        String selectQuery = "select top " + top + " sp.maSanPham from SanPham sp where sp.maDanhMuc='" + danhMuc.getMaDanhMuc() + "'";
        try {
            ResultSet rs = DBUtils.executeQuery(selectQuery);
            while(rs.next()) {
                dsMaSanPham.add(rs.getString(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        List<SanPham> dsSanPham = new ArrayList();
        dsMaSanPham.forEach(maSanPham -> { dsSanPham.add(getSanPham(maSanPham)); });

        return dsSanPham;
    }

    public  List<SanPham> getAllSanPhamFromDanhMuc(DanhMuc danhMuc) {
        List<String> dsMaSanPham = new ArrayList<>();
        String selectQuery = "select sp.maSanPham from SanPham sp where sp.maDanhMuc='" + danhMuc.getMaDanhMuc() + "'";
        try {
            ResultSet rs = DBUtils.executeQuery(selectQuery);
            while(rs.next()) {
                dsMaSanPham.add(rs.getString(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        List<SanPham> dsSanPham = new ArrayList();
        dsMaSanPham.forEach(maSanPham -> { dsSanPham.add(getSanPham(maSanPham)); });

        return dsSanPham;
    }
}
