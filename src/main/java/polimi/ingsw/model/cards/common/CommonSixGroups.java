package polimi.ingsw.model.cards.common;

import polimi.ingsw.model.DefaultValue;
import polimi.ingsw.model.enumeration.CardCommonType;
import polimi.ingsw.model.enumeration.TileType;
import polimi.ingsw.model.Shelf;
import polimi.ingsw.model.Tile;

public class CommonSixGroups extends CommonMethods {
    /**
     * Constructor
     *
     * @param type
     */
    public CommonSixGroups(CardCommonType type) {
        super(type);
    }

    /**
     * Check if the player's shelf met the six groups goal
     *
     * @return true if the goal is satisfied, false else
     */
    @Override
    public boolean verify(Shelf toCheck) {
        Shelf temp = CommonMethods.getCopy(toCheck);
        int sum = 0;
        if (temp.getOccupiedSpace() < 12)
            return false;
        while (sum < 6 && !temp.isEmpty()) {
            for (int r = 0; r < DefaultValue.NumOfRowsShelf; r++) {
                for (int c = 0; c < DefaultValue.NumOfColumnsShelf; c++) {
                    if (!temp.getSingleTile(r, c).isSameType(TileType.NOT_USED)) {
                        if (r != DefaultValue.NumOfRowsShelf - 1) {
                            if (temp.getSingleTile(r, c).isSameType(temp.getSingleTile(r + 1, c).getType())) {
                                temp.setSingleTile(new Tile(TileType.NOT_USED), r, c);
                                temp.setSingleTile(new Tile(TileType.NOT_USED), r + 1, c);
                                sum++;
                            }
                        }
                        if (c != DefaultValue.NumOfColumnsShelf - 1) {
                            //need to check if the tile is different from a non-used one, in case the
                            // row check passes and sets the tile to not used before
                            if (temp.getSingleTile(r, c).isSameType(temp.getSingleTile(r, c + 1).getType()) && !temp.getSingleTile(r, c).isSameType(TileType.NOT_USED)) {
                                temp.setSingleTile(new Tile(TileType.NOT_USED), r, c);
                                temp.setSingleTile(new Tile(TileType.NOT_USED), r, c + 1);
                                sum++;
                            }
                        }
                        temp.setSingleTile(new Tile(TileType.NOT_USED), r, c);
                    }
                }
            }
        }
        return sum >= 6;
    }
}
