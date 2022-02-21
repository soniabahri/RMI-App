package Serveur;

import java.rmi.RemoteException;

public class NoteImp implements NoteInterface{
    @Override
    public double getNote(int note, String matiere) throws RemoteException {
        return 10+(Math.random() *10 );
    }
}
