package org.example.impl;


import org.example.dao.NuocSanXuatDAO;
import org.example.model.NuocSanXuat;
import org.example.service.NuocSanXuatService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class NuocSanXuatImpl extends UnicastRemoteObject implements NuocSanXuatService, Serializable {

    private NuocSanXuatDAO nuocSanXuatDAO;

    public NuocSanXuatImpl() throws RemoteException {
        nuocSanXuatDAO= new NuocSanXuatDAO();
    }

    @Override
    public List<NuocSanXuat> getAllNuocSanXuat()throws RemoteException {
        return nuocSanXuatDAO.getAllNuocSanXuat();
    }

    @Override
    public NuocSanXuat getNuocSanXuat(int brandId)throws RemoteException {
        return nuocSanXuatDAO.getNuocSanXuat(brandId);
    }

    @Override
    public boolean addNuocSanXuat(NuocSanXuat nuocSanXuat)throws RemoteException{
        return nuocSanXuatDAO.addNuocSanXuat(nuocSanXuat);
    }

    @Override
    public boolean updateNuocSanXuat(NuocSanXuat nuocSanXuat)throws RemoteException{
        return nuocSanXuatDAO.updateNuocSanXuat(nuocSanXuat);
    }
    @Override
    public boolean deleteNuocSanXuat(NuocSanXuat nuocSanXuat)throws RemoteException{
        return nuocSanXuatDAO.deleteNuocSanXuat(nuocSanXuat);
    }
}
