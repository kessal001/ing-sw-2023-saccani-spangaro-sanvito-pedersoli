package polimi.ingsw.model.cards.common;

import polimi.ingsw.model.DefaultValue;
import polimi.ingsw.model.enumeration.CardCommonType;
import polimi.ingsw.model.enumeration.TileType;
import polimi.ingsw.model.Shelf;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static polimi.ingsw.networking.PrintAsync.printAsync;


public class CommonVerticalCard extends CommonCard {
    private static int param;

    /**
     * Constructor
     *
     * @param type
     * @param param
     */
    public CommonVerticalCard(CardCommonType type, int param) {
        super(type);
        CommonVerticalCard.param = param;
    }

    /**
     * Check if the player's shelf met the vertical goals
     *
     * @return true if the goal is satisfied, false else
     */
    @Override
    public boolean verify(Shelf toCheck) {
        param = super.getCommonType().compareTo(CardCommonType.CommonVertical0) > 0 ? 1 : 0;
        int sum = 0;
        switch (param) {
            case (0) -> {       //3 columns each consisting of 6 tiles of at most 3 different types
                if (toCheck.getOccupiedSpace() < 18)
                    return false;
                for (int j = 0; j < DefaultValue.NumOfColumnsShelf; j++) {
                    int ok = checkLines(toCheck, j);
                    if (ok <= 3)
                        sum++;
                    if (sum == 3) {
                        return true;
                    }
                }
                return false;
            }
            case (1) -> {       //2 columns each of 6 different types of tiles
                if (toCheck.getOccupiedSpace() < 12)
                    return false;
                for (int j = 0; j < DefaultValue.NumOfColumnsShelf; j++) {
                    int ok = checkLines(toCheck, j);
                    if (ok == 6)
                        sum++;
                    if (sum == 2) {
                        return true;
                    }
                }
                return false;
            }
            default -> {
                printAsync("Default error");
                return false;
            }
        }
    }

    /**
     * Checks the lines in the card
     *
     * @param toCheck
     * @param j
     * @return
     */
    private int checkLines(Shelf toCheck, int j) {
        Map<TileType, Integer> colCheck = new HashMap<>();
        int ok = 0;
        int count = 0;
        for (int i = 0; i < DefaultValue.NumOfRowsShelf; i++) {
            if (!toCheck.getSingleTile(i, j).isSameType(TileType.NOT_USED))
                colCheck.putIfAbsent(toCheck.getSingleTile(i, j).getType(), 1);
            else
                count++;
        }
        for (TileType t : TileType.values()) {
            ok = ok + Optional.
                    ofNullable(colCheck.get(t)).
                    orElse(0);
        }
        if (count > 0)
            ok = 4;
        return ok;
    }

}
