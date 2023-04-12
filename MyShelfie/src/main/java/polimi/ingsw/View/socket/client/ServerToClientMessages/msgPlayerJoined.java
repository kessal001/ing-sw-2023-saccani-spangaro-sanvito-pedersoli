package polimi.ingsw.View.socket.client.ServerToClientMessages;

import polimi.ingsw.Listener.GameListener;
import polimi.ingsw.Model.GameModelView.GameModelImmutable;

import java.rmi.RemoteException;

public class msgPlayerJoined extends SocketServerGenericMessage{
    private GameModelImmutable gamemodel;

    public msgPlayerJoined(GameModelImmutable gamemodel) {
        this.gamemodel = gamemodel;
    }

    @Override
    public void execute(GameListener lis) throws RemoteException {
        lis.playerJoined(gamemodel);
    }
}