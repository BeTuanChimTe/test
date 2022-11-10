package org.example.dao;

//import com.example.fashionshop.model.NhomQuyen;
//import com.example.fashionshop.utils.HibernateUtlis;
import org.example.model.NhomQuyen;
import org.example.model.NhomQuyen;
import org.example.model.NhomQuyen;
import org.example.utlis.HibernateUtlis;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class NhomQuyenDAO {

    private static String className = NhomQuyen.class.getName();

    public  List<NhomQuyen> getAllPermissionGroup() {
//        String selectQuery = "SELECT * FROM PERMISSION_GROUPS";
//        List<com.example.fashionshop.model.NhomQuyen> nhomQuyens = new ArrayList<>();
//        try {
//            ResultSet rs = DBUtils.executeQuery(selectQuery);
//            while(rs.next())
//                nhomQuyens.add(mapper(rs));
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return nhomQuyens;

        List<NhomQuyen> dsNhomQuyen = null;
        String sql = "select nq from " + className + " nq";
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Query<NhomQuyen> query = session.createQuery(sql, NhomQuyen.class);
        dsNhomQuyen = query.getResultList();
        transaction.commit();
        return dsNhomQuyen;
    }
    public boolean updateNhomQuyen(NhomQuyen nhomQuyen) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(nhomQuyen);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }
    public boolean addNhomQuyen(NhomQuyen nhomQuyen) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(nhomQuyen);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
            return false;
        }

    }
    public  NhomQuyen getPermissionGroupById(int permissionGroupId) {
//        String selectQuery = "SELECT * FROM PERMISSION_GROUPS WHERE permission_group_id=" + permissionGroupId;
//        try {
//            ResultSet rs = DBUtils.executeQuery(selectQuery);
//            if(rs.next())
//                return mapper(rs);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return null;

        NhomQuyen nhomQuyen = null;
        String sql = "select nq form " + className + " nq where nq.maNhomQuyen=" + permissionGroupId;
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Query<NhomQuyen> query = session.createQuery(sql, NhomQuyen.class);
        nhomQuyen = query.getSingleResult();
        transaction.commit();
        return nhomQuyen;
    }

}
