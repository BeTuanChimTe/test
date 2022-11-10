package org.example.impl;

import org.example.dao.QuyenDAO;
import org.example.model.Quyen;
import org.example.model.SanPham;
import org.example.service.QuyenService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class QuyenServiceImpl extends UnicastRemoteObject implements QuyenService, Serializable {
    private QuyenDAO quyenDAO;

    public QuyenServiceImpl() throws RemoteException {
        quyenDAO = new QuyenDAO();
    }

    @Override
    public List<Quyen> getAllQuyen() throws RemoteException {
        return quyenDAO.getAllQuyen();
    }

//    @Override
//    public Quyen getQuyen(int brandId) throws RemoteException {
//        return quyenDAO.getQuyen(brandId);
//    }

    @Override
    public boolean addQuyen(Quyen quyen) throws RemoteException {
        return quyenDAO.addQuyen(quyen);
    }

    @Override
    public boolean updateQuyen(Quyen quyen) throws RemoteException {
        return quyenDAO.updateQuyen(quyen);
    }

    @Override
    public boolean deleteQuyen(Quyen quyen) throws RemoteException {
        return quyenDAO.removeQuyen(quyen);
    }

    @Override
    public boolean mergeQuyen(Quyen quyen) throws RemoteException {
        return quyenDAO.mergeQuyen(quyen);
    }
}
