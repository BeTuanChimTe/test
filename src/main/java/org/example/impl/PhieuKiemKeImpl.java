package org.example.impl;


import org.example.dao.PhieuKiemKeDAO;
import org.example.model.PhieuKiemKe;
import org.example.service.PhieuKiemKeService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class PhieuKiemKeImpl extends UnicastRemoteObject implements PhieuKiemKeService , Serializable {
    private  PhieuKiemKeDAO phieuKiemKeDAO;

    public PhieuKiemKeImpl() throws RemoteException {
        phieuKiemKeDAO = new PhieuKiemKeDAO();
    }

    @Override
    public List<PhieuKiemKe> getAllPhieuKiemKe()throws RemoteException {
        return phieuKiemKeDAO.getAllPhieuKiemKe();
    }

    @Override
    public boolean addPhieuKiemKe(PhieuKiemKe phieuKiemKe)throws RemoteException {
        return phieuKiemKeDAO.addPhieuKiemKe(phieuKiemKe);
    }

    @Override
    public boolean updatePhieuKiemKe(PhieuKiemKe phieuKiemKe)throws RemoteException {
        return phieuKiemKeDAO.updatePhieuKiemKe(phieuKiemKe);
    }

    @Override
    public boolean deletePhieuKiemKe(PhieuKiemKe phieuKiemKe)throws RemoteException {
        return phieuKiemKeDAO.deletePhieuKiemKe(phieuKiemKe);
    }
}
