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

public class CommonHorizontalTest {
    List<CardCommon> model = new ArrayList<>();

    @BeforeEach
    void setUp() {
        CommonCardFactory c = new CommonCardFactory();
        for (CardCommonType t : CardCommonType.values())
            model.add(c.getCommonCard(t));
    }

    @Test
    @DisplayName("Test Horizontal")
    public void testHorizontal(){
        /*
    C C C C C
    B B B B B
    T T T T T
    C C C C C
    X X X X X
    X X X X X
     */
        Shelf test = new Shelf();
        for(int i = 0; i<DefaultValue.NumOfRowsShelf; i++){
            for(int j = 0; j<DefaultValue.NumOfColumnsShelf; j++){
                if(i==0||i==3){
                    test.setSingleTile(new Tile(TileType.CAT), i, j);
                }else if(i==1){
                    test.setSingleTile(new Tile(TileType.BOOK), i, j);
                }else if(i==2){
                    test.setSingleTile(new Tile(TileType.TROPHY), i, j);
                }else{
                    test.setSingleTile(new Tile(TileType.randomTile()), i, j);
                }
            }
        }
        assertTrue(model.get(7).verify(test));

        /*
        C B F T A
        X X X X X
        C B F T A
        X X X X X
        X X X X X
        X X X X X
         */
        for(int i = 0; i<DefaultValue.NumOfRowsShelf; i++){
            for(int j = 0; j<DefaultValue.NumOfColumnsShelf; j++){
                if(i==0||i==2){
                    switch (j) {
                        case (0) -> test.setSingleTile(new Tile(TileType.CAT), i, j);
                        case (1) -> test.setSingleTile(new Tile(TileType.BOOK), i, j);
                        case (2) -> test.setSingleTile(new Tile(TileType.FRAME), i, j);
                        case (3) -> test.setSingleTile(new Tile(TileType.TROPHY), i, j);
                        case (4) -> test.setSingleTile(new Tile(TileType.ACTIVITY), i, j);
                        default -> {
                        }
                    }
                }else{
                    test.setSingleTile(new Tile(TileType.randomTile()), i, j);
                }
            }
        }
        assertTrue(model.get(9).verify(test));
    }

}