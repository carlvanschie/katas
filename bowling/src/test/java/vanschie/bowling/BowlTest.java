package vanschie.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by carl on 16/06/17.
 */
public class BowlTest {

    private Bowl bowl;

    @Before
    public void setUp() {
        bowl = new Bowl();
    }

    @Test
    public void givenANewGame_whenATheFirstBowlHappens_thenTheScoreIsZero() {
        assertEquals(0, bowl.bowl(5));
    }

    @Test
    public void givenAGame_whenAllGutterBowls_thenTheScoreIsZero() {
        assertEquals(0, bowl.bowl(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    @Test
    public void givenAGame_whenTheFirstFrameIsRolled_thenTheScoreIsCorrect() {
        assertEquals(8, bowl.bowl(5, 3));
    }

    @Test
    public void givenAGameWithAFirstFrame_whenOnlyTheFirstBowlIsRolledInTheSecondFrame_thenTheScoreIsCorrect() {
        assertEquals(8, bowl.bowl(5, 3, 5));
    }

    @Test
    public void givenANewGame_whenTheFirstFrameIsASpare_thenTheScoreIsCorrect() {
        assertEquals(0, bowl.bowl(5, 5));
    }

    @Test
    public void givenAGameWithASpareInTheFirstFrame_whenThereIsAnotherBowl_thenTheScoreIsCorrect() {
        assertEquals(13, bowl.bowl(5, 5, 3));
    }

    @Test
    public void givenAGameWithASpareInTheFirstFrame_whenThereIsAnotherNormalFrame_thenTheScoreIsCorrect() {
        assertEquals(19, bowl.bowl(5, 5, 3, 3));
    }

    @Test
    public void givenAGame_whenThereIsAStrike_thenTheScoreIsCorrect() {
        assertEquals(0, bowl.bowl(10));
    }

    @Test
    public void givenAGameWithAStrike_whenASecondBowlOccurs_thenTheScoreIsCorrect() {
        assertEquals(0, bowl.bowl(10, 3));
    }

    @Test
    public void givenAGameWithAStrike_whenASecondFrameOccurs_thenTheScoreIsCorrect() {
        assertEquals(22, bowl.bowl(10, 3, 3));
    }

    @Test
    public void givenAGame_whenAllFramesAreSpares_thenTheScoreIsCorrect() {
        assertEquals(150, bowl.bowl(5,5, 5,5, 5,5, 5,5, 5,5, 5,5, 5,5, 5,5, 5,5, 5,5, 5));
    }

    @Test
    public void givenAGame_whenAllFramesAreStrikes_thenTheScoreIsCorrect() {
        assertEquals(300, bowl.bowl(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10));
    }

    @Test
    public void givenAGame_whenAGameIsCompleted_thenTheScoreIsCorrect() {
        assertEquals(125, bowl.bowl(1,9, 10, 4,1, 6,2, 3,6, 2,3, 10, 10, 5,5, 2,4));
    }
}
