package polimi.ingsw.View.networking.socket.client.GameControllerMessages;

import polimi.ingsw.Listener.GameListener;
import polimi.ingsw.View.networking.RMI.remoteInterfaces.GameControllerInterface;
import polimi.ingsw.View.networking.RMI.remoteInterfaces.MainControllerInterface;
import polimi.ingsw.View.networking.socket.client.SocketClientGenericMessage;

import java.rmi.RemoteException;

public class SocketClientMessageSetReady extends SocketClientGenericMessage {

    public SocketClientMessageSetReady(String nick) {
        this.nick = nick;
        this.isMessageForMainController = false;
    }

    @Override
    public GameControllerInterface execute(GameListener lis, MainControllerInterface mainController) throws RemoteException {
        return null;
    }

    @Override
    public void execute(GameControllerInterface gameController) throws RemoteException {
        gameController.playerIsReadyToStart(this.nick);
    }
}