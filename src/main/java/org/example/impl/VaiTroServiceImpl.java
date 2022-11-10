package org.example.impl;

import org.example.dao.VaiTroDAO;
import org.example.model.VaiTro;
import org.example.service.VaiTroService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class VaiTroServiceImpl extends UnicastRemoteObject implements VaiTroService, Serializable {
    private VaiTroDAO vaiTroDAO;
    public VaiTroServiceImpl() throws RemoteException {
        vaiTroDAO = new VaiTroDAO();
    }

    @Override
    public List<VaiTro> getAllVaiTro() throws RemoteException {
        return vaiTroDAO.getAllRoles();
    }

    @Override
    public boolean addVaiTro(VaiTro vaiTro) throws RemoteException {
        return vaiTroDAO.addVaiTro(vaiTro);

    }
//
//    @Override
//    public boolean updateVaiTro(VaiTro vaiTro) throws RemoteException {
//        return vaiTroDAO.updateVaiTro(vaiTro);
//    }
//
//    @Override
//    public boolean removeVaiTro(VaiTro vaiTro) throws RemoteException {
//        return vaiTroDAO.removeVaiTro(vaiTro);
//    }
}
