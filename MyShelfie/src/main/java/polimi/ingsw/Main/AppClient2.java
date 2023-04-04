package polimi.ingsw.Main;

import polimi.ingsw.Model.Enumeration.Direction;
import polimi.ingsw.Model.Enumeration.GameStatus;
import polimi.ingsw.View.RMI.RMIClient;

import java.rmi.RemoteException;

public class AppClient2 {
    public static void main( String[] args ) throws RemoteException {
        RMIClient client2 = new RMIClient();

        client2.connect();

        client2.joinFirstAvailable("ugo");

        client2.setAsReady();

        while(client2.getLastModelReceived()==null){

        }

        if(client2.isMyTurn()) {
            client2.grabTileFromPlayground(1, 3, Direction.RIGHT, 2);
            client2.positionTileOnShelf(0,client2.getLastModelReceived().getHandOfCurrentPlaying().get(0).getType());
            client2.positionTileOnShelf(0,client2.getLastModelReceived().getHandOfCurrentPlaying().get(0).getType());
        }
    }
}
