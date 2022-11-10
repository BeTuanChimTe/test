package org.example.impl;

import org.example.dao.VaiTroNhomQuyenDAO;
import org.example.model.VaiTroNhomQuyen;
import org.example.service.VaiTroNhomQuyenService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class VaiTroNhomQuyenServiceImpl extends UnicastRemoteObject implements VaiTroNhomQuyenService , Serializable {
    private VaiTroNhomQuyenDAO vaiTroNhomQuyenDAO;

    public VaiTroNhomQuyenServiceImpl() throws RemoteException {
        vaiTroNhomQuyenDAO = new VaiTroNhomQuyenDAO();
    }

    @Override
    public List<VaiTroNhomQuyen> getAllVaiTroNhomQuyen() throws RemoteException {
        return vaiTroNhomQuyenDAO.getAllRoles();
    }

    @Override
    public boolean addVaiTroNhomQuyen(VaiTroNhomQuyen vaiTro) throws RemoteException {
        return vaiTroNhomQuyenDAO.addVaiTroNhomQuyen(vaiTro);
    }

    @Override
    public boolean mergeVaiTroNhomQuyen(VaiTroNhomQuyen vaiTroNhomQuyen) throws RemoteException {
        return vaiTroNhomQuyenDAO.mergeVaiTroNhomQuyen(vaiTroNhomQuyen);
    }
}
