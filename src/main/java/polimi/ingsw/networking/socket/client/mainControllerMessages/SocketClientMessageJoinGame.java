package polimi.ingsw.networking.socket.client.mainControllerMessages;

import polimi.ingsw.listener.GameListener;
import polimi.ingsw.networking.rmi.remoteInterfaces.GameControllerInterface;
import polimi.ingsw.networking.rmi.remoteInterfaces.MainControllerInterface;
import polimi.ingsw.networking.socket.client.SocketClientGenericMessage;

import java.rmi.RemoteException;

/**
 * SocketClientMessageJoinGame class.
 * Extends SocketClientGenericMessage and is used to send a message to the server
 * indicating the request to join a specific game by its ID.
 */
public class SocketClientMessageJoinGame extends SocketClientGenericMessage {

    int idGame;

    /**
     * Constructor of the class.
     * @param nick the player's nickname
     * @param idGame the ID of the game to join
     */
    public SocketClientMessageJoinGame(String nick, int idGame) {
        this.idGame = idGame;
        this.nick = nick;
        this.isMessageForMainController = true;
    }

    /**
     * Method to execute the corresponding action for the message.
     * @param lis the game listener
     * @param mainController the main controller of the application
     * @return the game controller interface
     * @throws RemoteException if there is an error in remote communication
     */
    @Override
    public GameControllerInterface execute(GameListener lis, MainControllerInterface mainController) throws RemoteException {
        return mainController.joinGame(lis, nick, idGame);
    }

    /**
     * Method to execute the corresponding action for the message.
     * @param mainController the game controller interface
     * @throws RemoteException if there is an error in remote communication
     */
    @Override
    public void execute(GameControllerInterface mainController) throws RemoteException {

    }
}
