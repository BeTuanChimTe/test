package org.example.impl;


import org.example.dao.MauSacDAO;
import org.example.model.MauSac;
import org.example.service.MauSacService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class MauSacImpl extends UnicastRemoteObject implements MauSacService, Serializable {
    private MauSacDAO mauSacDAO;

    public MauSacImpl() throws RemoteException {
        mauSacDAO= new MauSacDAO();
    }

    @Override
    public List<MauSac> getAllMauSac()throws RemoteException {
        return mauSacDAO.getAllMauSac();
    }

    @Override
    public MauSac getMauSac(int colorId)throws RemoteException {
        return mauSacDAO.getMauSac(colorId);
    }

    @Override
    public boolean addMauSac(MauSac mauSac)throws RemoteException {
        return mauSacDAO.addMauSac(mauSac);
    }

    @Override
    public boolean updateMauSac(MauSac mauSac)throws RemoteException {
        return mauSacDAO.updateMauSac(mauSac);
    }

    @Override
    public boolean deleteMauSac(MauSac mauSac)throws RemoteException {
        return mauSacDAO.deleteMauSac(mauSac);
    }
}
