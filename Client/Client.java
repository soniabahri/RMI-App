package Client;

import Serveur.NoteInterface;
import Serveur.Serveur;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import static java.lang.System.*;

public class Client {

    String url="rmi://127.0.0.1/RMIClient";


    public void RMIClient() {


        if (getSecurityManager() == null) {
        setSecurityManager(new RMISecurityManager()); }}

        NoteInterface not;

    {
        try {
            not = (NoteInterface) Naming.lookup(url);
            System.out.println(not.getNote(100,"amoula XD"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Client s1 = new Client() ;
        s1.RMIClient();
    }


}
