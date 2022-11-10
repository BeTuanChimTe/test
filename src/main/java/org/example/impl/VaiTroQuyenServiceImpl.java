package org.example.impl;

import org.example.dao.VaiTroQuyenDAO;
import org.example.model.VaiTroQuyen;
import org.example.service.VaiTroQuyenService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class VaiTroQuyenServiceImpl extends UnicastRemoteObject implements VaiTroQuyenService, Serializable {
    private VaiTroQuyenDAO vaiTroQuyenDAO;
    public VaiTroQuyenServiceImpl() throws RemoteException {
        vaiTroQuyenDAO = new VaiTroQuyenDAO();
    }

    @Override
    public List<VaiTroQuyen> getAllVaiTroQuyen() throws RemoteException {
        return vaiTroQuyenDAO.getAllVaiTroQuyen();
    }

    @Override
    public VaiTroQuyen getVaiTroQuyen(String maVaiTroQuyen) throws RemoteException {
        return vaiTroQuyenDAO.getVaiTroQuyen(maVaiTroQuyen);
    }

    @Override
    public boolean addVaiTroQuyen(VaiTroQuyen vaiTroQuyen) throws RemoteException {
        return vaiTroQuyenDAO.addVaiTroQuyen(vaiTroQuyen);
    }

    @Override
    public boolean updateVaiTroQuyen(VaiTroQuyen vaiTroQuyen) throws RemoteException {
        return vaiTroQuyenDAO.updateVaiTroQuyen(vaiTroQuyen);
    }

    @Override
    public boolean removeVaiTroQuyen(VaiTroQuyen vaiTroQuyen) throws RemoteException {
        return vaiTroQuyenDAO.removeVaiTroQuyen(vaiTroQuyen);
    }

    @Override
    public boolean mergeVaiTroQuyen(VaiTroQuyen vaiTroQuyen) throws RemoteException {
        return vaiTroQuyenDAO.mergeVaiTroQuyen(vaiTroQuyen);
    }
}
