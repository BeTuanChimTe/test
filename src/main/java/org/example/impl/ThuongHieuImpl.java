package org.example.impl;


import org.example.dao.ThuongHieuDAO;
import org.example.model.ThuongHieu;
import org.example.service.ThuongHieuService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ThuongHieuImpl extends UnicastRemoteObject implements ThuongHieuService, Serializable {

    private  ThuongHieuDAO thuongHieuDAO;

    public ThuongHieuImpl() throws RemoteException {
        thuongHieuDAO = new ThuongHieuDAO();
    }

    @Override
    public List<ThuongHieu> getAllThuongHieu()throws RemoteException  {
        return thuongHieuDAO.getAllThuongHieu();
    }

    @Override
    public ThuongHieu getThuongHieu(int brandId)throws RemoteException  {
        return thuongHieuDAO.getThuongHieu(brandId);
    }

    @Override
    public boolean addThuongHieu(ThuongHieu thuongHieu)throws RemoteException {
        return thuongHieuDAO.addThuongHieu(thuongHieu);
    }

    @Override
    public boolean updateThuongHieu(ThuongHieu thuongHieu)throws RemoteException {
        return thuongHieuDAO.updateThuongHieu(thuongHieu);
    }
    @Override
    public boolean deleteThuongHieu(ThuongHieu thuongHieu)throws RemoteException {
        return thuongHieuDAO.deleteThuongHieu(thuongHieu);
    }
}
