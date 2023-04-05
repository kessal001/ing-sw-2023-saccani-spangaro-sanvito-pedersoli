package polimi.ingsw.Model;

import java.io.Serializable;
import java.util.Queue;

public class DefaultValue implements Serializable {
    public final static int MaxNumOfPlayer = 4;
    public final static int minNumOfPlayer = 2;

    public final static int defButtonXSize = 200;
    public final static int defButtonYSize = 50;
    public final static int NumOfCommonCards = 2;

    public final static int startingButtons = 4;

    public final static int NumOfColumnsShelf = 5;
    public final static int NumOfRowsShelf = 6;

    public final static int NumOfTileTypes = 6;
    public final static int NumOfTilesPerType = 22;
    public final static int PlaygroundSize = 9;
    public final static int[] pointsValue = {2, 4, 6, 8};

    public final static int Default_port_RMI = 4321;
    public final static int Default_port_Socket = 4320;
    public final static String Default_servername_RMI = "MyShelfie";

    public final static String Remote_ip = "127.0.0.1";

}
