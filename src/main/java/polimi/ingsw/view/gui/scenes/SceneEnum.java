package polimi.ingsw.view.gui.scenes;

/**
 * SceneEnum class. It is used to store the paths of the FXML files of the scenes.
 */
public enum SceneEnum {
    PUBLISHER("/Publisher.fxml"),
    MENU("/Menu.fxml"),
    NICKNAME("/Nickname.fxml"),
    NICKNAME_POPUP("/NicknamePopup.fxml"),
    LOBBY("/Lobby.fxml"),
    PLAYER_LOBBY_CARD0("/PlayerLobbyCard0.fxml"),
    PLAYER_LOBBY_CARD1("/PlayerLobbyCard1.fxml"),
    PLAYER_LOBBY_CARD2("/PlayerLobbyCard2.fxml"),
    PLAYER_LOBBY_CARD3("/PlayerLobbyCard3.fxml"),
    JOIN_SPECIFIC("/JoinSpecific.fxml"),
    INGAME("/InGame.fxml"),
    GAME_ENDED("/GameEnded.fxml"),
    GENERIC_ERROR("/GenericError.fxml");

    private final String value;


    SceneEnum(final String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
