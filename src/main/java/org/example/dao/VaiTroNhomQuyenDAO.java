package org.example.dao;


import org.example.model.VaiTroNhomQuyen;
import org.example.model.VaiTroNhomQuyen;
import org.example.utlis.HibernateUtlis;
import org.example.utlis.IDUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class VaiTroNhomQuyenDAO {

    private static String className = VaiTroNhomQuyen.class.getName();

    public  List<VaiTroNhomQuyen> getAllRoles() {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        List<VaiTroNhomQuyen> dsVaiTroNhomQuyen = null;
        try {
            transaction.begin();
            String selectQuery = "select vt from " + className + " vt";
            Query<VaiTroNhomQuyen> query = session.createQuery(selectQuery, VaiTroNhomQuyen.class);
            dsVaiTroNhomQuyen = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return dsVaiTroNhomQuyen;
    }
    public  boolean addVaiTroNhomQuyen(VaiTroNhomQuyen vaiTro){
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(vaiTro);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public  VaiTroNhomQuyen getRoleById(int roleId) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        VaiTroNhomQuyen vaiTro = null;
        try {
            transaction.begin();
            String selectQuery = "select vt from " + className + " vt where vt.maVaiTroNhomQuyen=" + roleId;
            Query<VaiTroNhomQuyen> query = session.createQuery(selectQuery, VaiTroNhomQuyen.class);
            vaiTro = query.getSingleResult();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return vaiTro;
    }
    public  boolean mergeVaiTroNhomQuyen(VaiTroNhomQuyen vaiTroNhomQuyen) {
//        if (vaiTroNhomQuyen.getMaVaiTroNhomQuyen()== null || vaiTroNhomQuyen.getMaVaiTroNhomQuyen().isEmpty() == true)
//            vaiTroNhomQuyen.setMaVaiTroNhomQuyen(IDUtils.createMaVaiTroNhomQuyen());
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.merge(vaiTroNhomQuyen);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
