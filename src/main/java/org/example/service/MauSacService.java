package org.example.service;

//import com.example.fashionshop.model.MauSac;
//import javafx.collections.ObservableList;

import org.example.model.MauSac;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MauSacService extends Remote {

    public List<MauSac> getAllMauSac()throws RemoteException;;

    public MauSac getMauSac(int colorId)throws RemoteException;;

    public boolean addMauSac(MauSac mauSac)throws RemoteException;;

    public boolean updateMauSac(MauSac mauSac)throws RemoteException;;

    public boolean deleteMauSac(MauSac mauSac)throws RemoteException;;

}
