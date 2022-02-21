package Serveur;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Serveur {
    NoteImp note = new NoteImp();
    String url="rmi://127.0.0.1/RMIClient";
    Registry regist;

    public void Serv() {

        try {
            regist = LocateRegistry.createRegistry(1099);
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new RMISecurityManager()); }


            Remote rmt = UnicastRemoteObject.exportObject(note,1099);
            try {
                Naming.rebind(url,rmt);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


        } catch (RemoteException e) {

            e.printStackTrace();
        }


    }
public static void main(String[] args) {
        Serveur s1 = new Serveur() ;
        s1.Serv();
}
}
