package org.example.impl;


import org.example.dao.NhaCungCapDAO;
import org.example.model.NhaCungCap;
import org.example.service.NhaCungCapService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class NhaCungCapImpl extends UnicastRemoteObject implements NhaCungCapService, Serializable {

    private NhaCungCapDAO nhaCungCapDAO;

    public NhaCungCapImpl() throws RemoteException {
        nhaCungCapDAO = new NhaCungCapDAO();
    }

    @Override
    public List<NhaCungCap> getAllNhaCungCap()throws RemoteException  {
        return nhaCungCapDAO.getAllNhaCungCap();
    }

    @Override
    public boolean addNhaCungCap(NhaCungCap nhaCungCap)throws RemoteException  {
        return nhaCungCapDAO.addNhaCungCap(nhaCungCap);
    }

    @Override
    public boolean updateNhaCungCap(NhaCungCap nhaCungCap)throws RemoteException  {
        return nhaCungCapDAO.updateNhaCungCap(nhaCungCap);
    }

    @Override
    public boolean deleteNhaCungCap(NhaCungCap nhaCungCap)throws RemoteException  {
        return nhaCungCapDAO.deleteNhaCungCap(nhaCungCap);
    }
}
