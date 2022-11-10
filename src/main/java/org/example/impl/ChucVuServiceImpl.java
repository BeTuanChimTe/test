package org.example.impl;

import org.example.dao.ChucVuDAO;
import org.example.dao.KhachHangDAO;
import org.example.model.ChucVu;
import org.example.model.KhachHang;
import org.example.service.ChucVuService;
import org.example.service.KhachHangService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ChucVuServiceImpl extends UnicastRemoteObject implements ChucVuService, Serializable {
    private ChucVuDAO chucVuDAO;
    public ChucVuServiceImpl() throws RemoteException {
        chucVuDAO = new ChucVuDAO();
    }

    @Override
    public List<ChucVu> getAllChucVu() throws RemoteException {
        return chucVuDAO.getAllCChucVu();
    }

    @Override
    public boolean addChucVu(ChucVu chucVu) throws RemoteException {
        return chucVuDAO.addChucVu(chucVu);

    }

    @Override
    public boolean updateChucVu(ChucVu chucVu) throws RemoteException {
        return chucVuDAO.updateChucVu(chucVu);
    }

    @Override
    public boolean removeChucVu(ChucVu chucVu) throws RemoteException {
        return chucVuDAO.removeChucVu(chucVu);
    }
}
