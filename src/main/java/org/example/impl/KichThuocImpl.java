package org.example.impl;


import org.example.dao.KichThuocDAO;
import org.example.model.KichThuoc;
import org.example.service.KichThuocService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class KichThuocImpl extends UnicastRemoteObject implements KichThuocService , Serializable {

    private  KichThuocDAO kichThuocDAO;

    public KichThuocImpl() throws RemoteException {
        kichThuocDAO = new KichThuocDAO();
    }

    @Override
    public List<KichThuoc> getAllKichThuoc()throws RemoteException {
        return kichThuocDAO.getAllKichThuoc();
    }

    @Override
    public KichThuoc getKichThuoc(int sizeId)throws RemoteException {
        return kichThuocDAO.getKichThuoc(sizeId);
    }

    @Override
    public boolean addKichThuoc(KichThuoc kichThuoc)throws RemoteException{
        return kichThuocDAO.addKichThuoc(kichThuoc);
    }

    @Override
    public boolean updateKichThuoc(KichThuoc kichThuoc)throws RemoteException{
        return kichThuocDAO.updateKichThuoc(kichThuoc);
    }
    @Override
    public boolean deleteKichThuoc(KichThuoc kichThuoc)throws RemoteException{
        return kichThuocDAO.deleteKichThuoc(kichThuoc);
    }
}
