package polimi.ingsw.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import polimi.ingsw.Model.Cards.Common.CardCommon;
import polimi.ingsw.Model.Cards.Common.CommonCardFactory;
import polimi.ingsw.Model.Enumeration.CardCommonType;
import polimi.ingsw.Model.Enumeration.TileType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommonGroupsTest {

    List<CardCommon> model = new ArrayList<>();

    @BeforeEach
    void setUp() {
        CommonCardFactory c = new CommonCardFactory();
        for (CardCommonType t : CardCommonType.values())
            model.add(c.getCommonCard(t));
    }

    @Test
    @DisplayName("Test Group cards")
    public void testGroup() {
        int count;
        Shelf test = new Shelf();
        //case 1
        //first common card
        /*
        C B C B X
        C B C B X
        X X X X X
        C B C B X
        C B C B X
        X X X X X
         */
        count = 0;
        for (int i = 0; i < DefaultValue.NumOfRowsShelf; i++) {
            for (int j = 0; j < DefaultValue.NumOfColumnsShelf; j++) {
                if (count < 2) {
                    if (j == 0 && i < 2) {
                        test.setSingleTile(new Tile(TileType.CAT), i, j);
                    } else if(j == 0 && i > 3){
                        test.setSingleTile(new Tile(TileType.CAT), i, j);
                    }else{
                        test.setSingleTile(new Tile(TileType.randomTileCATeBOOK()), i, j);
                    }
                    count++;
                } else if (count < 4) {
                    if (j == 1 && i < 2) {
                        test.setSingleTile(new Tile(TileType.BOOK), i, j);
                    } else if(j == 1 && i > 3){
                        test.setSingleTile(new Tile(TileType.BOOK), i, j);

                    }else{
                        test.setSingleTile(new Tile(TileType.randomTileCATeBOOK()), i, j);
                    }
                    count++;
                } else if (count < 6) {
                    if (j == 2 && i < 2) {
                        test.setSingleTile(new Tile(TileType.CAT), i, j);
                    } else if(j == 2 && i > 3){
                        test.setSingleTile(new Tile(TileType.CAT), i, j);
                    }else {
                        test.setSingleTile(new Tile(TileType.randomTileCATeBOOK()), i, j);
                    }
                    count++;
                } else {
                    test.setSingleTile(new Tile(TileType.randomTileCATeBOOK()), i, j);
                }
            }
        }

        //check this algorithm
        assertTrue(model.get(0).verify(test));

        //four groups of four tiles of the same type (will be testing two columns in this test case)
        //third common card
        /*
        C B C B X
        C B C B X
        C B C B X
        C B C B X
        X X X X X
        X X X X X
         */
        count = 0;
        for (int i = 0; i < DefaultValue.NumOfRowsShelf; i++) {
            for (int j = 0; j < DefaultValue.NumOfColumnsShelf; j++) {
                if (count < 4) {
                    if (j == 0) {
                        test.setSingleTile(new Tile(TileType.CAT), i, j);
                    } else {
                        test.setSingleTile(new Tile(TileType.randomTileCATeBOOK()), i, j);
                    }
                    count++;
                } else if (count < 8) {
                    if (j == 1) {
                        test.setSingleTile(new Tile(TileType.BOOK), i, j);
                    } else {
                        test.setSingleTile(new Tile(TileType.randomTileCATeBOOK()), i, j);
                    }
                    count++;
                } else if (count < 12) {
                    if (j == 2) {
                        test.setSingleTile(new Tile(TileType.CAT), i, j);
                    } else {
                        test.setSingleTile(new Tile(TileType.randomTileCATeBOOK()), i, j);
                    }
                    count++;
                } else if (count < 16) {
                    if (j == 3) {
                        test.setSingleTile(new Tile(TileType.BOOK), i, j);
                    } else {
                        test.setSingleTile(new Tile(TileType.randomTileCATeBOOK()), i, j);
                    }
                    count++;
                } else {
                    test.setSingleTile(new Tile(TileType.randomTileCATeBOOK()), i, j);
                }
            }
        }
        assertTrue(model.get(2).verify(test));
        //two separated groups of 2x2 tiles with the same type
        //fourth common card
        /*
        C C X X X
        C C X X X
        X X X X X
        X X X C C
        X X X C C
         */
        for (int i = 0; i < DefaultValue.NumOfRowsShelf; i++) {
            for (int j = 0; j < DefaultValue.NumOfColumnsShelf; j++) {
                if ((i == 0 && j == 0) || (i == 1 && j == 0) || (i == 0 && j == 1) || (i == 1 && j == 1)) {
                    test.setSingleTile(new Tile(TileType.CAT), i, j);
                } else if ((i == 3 && j == 3) || (i == 4 && j == 3) || (i == 3 && j == 4) || (i == 4 && j == 4)) {
                    test.setSingleTile(new Tile(TileType.CAT), i, j);
                } else {
                    test.setSingleTile(new Tile(TileType.randomTileCAT()), i, j);
                }
            }
        }
        assertTrue(model.get(3).verify(test));
        //8 random occurrences of the same tile type
        //sixth common card
        /*
        C C C C C
        C C C X X
        X X X X X
        X X X X X
        X X X X X
        X X X X X
         */
        count = 0;
        for (int i = 0; i < DefaultValue.NumOfRowsShelf; i++) {
            for (int j = 0; j < DefaultValue.NumOfColumnsShelf; j++) {
                if (count < 8)
                    test.setSingleTile(new Tile(TileType.CAT), i, j);
                else
                    test.setSingleTile(new Tile(TileType.randomTileCAT()), i, j);
                count++;
            }
        }
        assertTrue(model.get(5).verify(test));
    }
}