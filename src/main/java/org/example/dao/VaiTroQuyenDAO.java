package org.example.dao;

//import com.example.fashionshop.model.DanhMuc;
//import com.example.fashionshop.model.VaiTroQuyen;
//import com.example.fashionshop.utils.DBUtils;
//import com.example.fashionshop.utils.HibernateUtlis;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import org.example.model.DanhMuc;
import org.example.model.VaiTroQuyen;
import org.example.utlis.DBUtils;
import org.example.utlis.HibernateUtlis;
import org.example.utlis.IDUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VaiTroQuyenDAO {

    private static String className = VaiTroQuyen.class.getName();

    public  List<VaiTroQuyen> getAllVaiTroQuyen() {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        List<VaiTroQuyen> dsVaiTroQuyen = null;
        try {
            transaction.begin();
            String selectQuery = "select sp from " + className + " sp";
            Query<VaiTroQuyen> query = session.createQuery(selectQuery, VaiTroQuyen.class);
            dsVaiTroQuyen = new ArrayList(query.getResultList());
//                    FXCollections.observableArrayList(query.getResultList());
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return dsVaiTroQuyen;
    }

    public  VaiTroQuyen getVaiTroQuyen(String maVaiTroQuyen) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        VaiTroQuyen vaiTroQuyen = null;
        try {
            transaction.begin();
            String selectQuery = "select sp from " + className + " sp where sp.maVaiTroQuyen='" + maVaiTroQuyen + "'";
            Query<VaiTroQuyen> query = session.createQuery(selectQuery, VaiTroQuyen.class);
            vaiTroQuyen = query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return vaiTroQuyen;
    }

    public  boolean addVaiTroQuyen(VaiTroQuyen vaiTroQuyen) {
//        vaiTroQuyen.setNhomQuyen(IDUtils.createMaVaiTroQuyen()).;
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(vaiTroQuyen);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public  boolean updateVaiTroQuyen(VaiTroQuyen vaiTroQuyen) {

        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(vaiTroQuyen);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public  boolean mergeVaiTroQuyen(VaiTroQuyen vaiTroQuyen) {
//        if (vaiTroQuyen.getMaVaiTroQuyen()== null || vaiTroQuyen.getMaVaiTroQuyen().isEmpty() == true)
//            vaiTroQuyen.setMaVaiTroQuyen(IDUtils.createMaVaiTroQuyen());
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.merge(vaiTroQuyen);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public  boolean removeVaiTroQuyen(VaiTroQuyen vaiTroQuyen) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.delete(vaiTroQuyen);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public  List<VaiTroQuyen> getAllVaiTroQuyenFromDanhMuc(DanhMuc danhMuc, int top) {
        List<String> dsMaVaiTroQuyen = new ArrayList<>();
        String selectQuery = "select top " + top + " sp.maVaiTroQuyen from VaiTroQuyen sp where sp.maDanhMuc='" + danhMuc.getMaDanhMuc() + "'";
        try {
            ResultSet rs = DBUtils.executeQuery(selectQuery);
            while(rs.next()) {
                dsMaVaiTroQuyen.add(rs.getString(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        List<VaiTroQuyen> dsVaiTroQuyen = new ArrayList();
        dsMaVaiTroQuyen.forEach(maVaiTroQuyen -> { dsVaiTroQuyen.add(getVaiTroQuyen(maVaiTroQuyen)); });

        return dsVaiTroQuyen;
    }

    public  List<VaiTroQuyen> getAllVaiTroQuyenFromDanhMuc(DanhMuc danhMuc) {
        List<String> dsMaVaiTroQuyen = new ArrayList<>();
        String selectQuery = "select sp.maVaiTroQuyen from VaiTroQuyen sp where sp.maDanhMuc='" + danhMuc.getMaDanhMuc() + "'";
        try {
            ResultSet rs = DBUtils.executeQuery(selectQuery);
            while(rs.next()) {
                dsMaVaiTroQuyen.add(rs.getString(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        List<VaiTroQuyen> dsVaiTroQuyen = new ArrayList();
        dsMaVaiTroQuyen.forEach(maVaiTroQuyen -> { dsVaiTroQuyen.add(getVaiTroQuyen(maVaiTroQuyen)); });

        return dsVaiTroQuyen;
    }
}
