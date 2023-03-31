package polimi.ingsw.Main;

import polimi.ingsw.View.RMI.RMIClient;
import polimi.ingsw.View.RMI.RMIServer;

import java.rmi.RemoteException;

public class App {
    public static void main( String[] args ) throws RemoteException {

        RMIServer server = RMIServer.bind();

        RMIClient client = new RMIClient();
        RMIClient client2 = new RMIClient();

        client.connect();
        client2.connect();


        client.createGame("pino");
        client2.joinFirstAvailable("ugo");

        client.setAsReady();

        client2.setAsReady();
    }
}
