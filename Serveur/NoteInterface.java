package Serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NoteInterface extends Remote {
    public double getNote(int note , String matiere) throws RemoteException;
}
