package org.example.impl;

import org.example.dao.TinhTPDAO;
import org.example.model.TinhTP;
import org.example.service.TinhTPService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class TinhTPServiceImpl extends UnicastRemoteObject implements TinhTPService, Serializable {

    private TinhTPDAO tinhTPDAO;

    public TinhTPServiceImpl() throws RemoteException {
        tinhTPDAO = new TinhTPDAO();
    }

    @Override
    public boolean addTinhTP(TinhTP tinhTP) throws RemoteException {
        return tinhTPDAO.addTinhTP(tinhTP);
    }

    @Override
    public List<TinhTP> getAllTinhTP() throws RemoteException {
        return tinhTPDAO.getAllTinhTP();
    }

    @Override
    public TinhTP getTinhTPById(String id) throws RemoteException {
        return tinhTPDAO.getTinhTPById(id);
    }
}
