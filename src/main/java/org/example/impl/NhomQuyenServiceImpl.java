package org.example.impl;

import org.example.dao.NhomQuyenDAO;
import org.example.model.NhomQuyen;
import org.example.service.NhomQuyenService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Set;

public class NhomQuyenServiceImpl extends UnicastRemoteObject implements NhomQuyenService, Serializable {
    private NhomQuyenDAO nhomQuyenDAO;

    public NhomQuyenServiceImpl() throws RemoteException {
        nhomQuyenDAO = new NhomQuyenDAO();
    }

    @Override
    public List<NhomQuyen> getAllNhomQuyen() throws RemoteException {
        return nhomQuyenDAO.getAllPermissionGroup();
    }

    @Override
    public NhomQuyen getNhomQuyen(int brandId) throws RemoteException {
        return nhomQuyenDAO.getPermissionGroupById(brandId);
    }

    @Override
    public boolean addNhomQuyen(NhomQuyen nhomQuyen) throws RemoteException {
        return nhomQuyenDAO.addNhomQuyen(nhomQuyen);
    }

    @Override
    public boolean updateNhomQuyen(NhomQuyen nhomQuyen) throws RemoteException {
        return nhomQuyenDAO.updateNhomQuyen(nhomQuyen);
    }

    @Override
    public boolean deleteNhomQuyen(NhomQuyen nhomQuyen) throws RemoteException {
        return false;
    }
}
