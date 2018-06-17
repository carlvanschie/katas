package vanschie.bowling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carl on 16/06/17.
 */
public class Bowl {
    private static final Integer TEN_PINS = 10;

    private final List<Frame> frames = new ArrayList();
    private Integer firstBowlScore = -1;

    public int bowl(Integer... bowls) {

        for(Integer bowl : bowls) {
            Frame previousFrame = getFrameForPreviousRoll();
            handlePreviousSpares(bowl, previousFrame);
            handlePreviousStrikes(bowl, previousFrame);

            if (isFirstBowl()) {
                if(bowl == TEN_PINS) {
                    frames.add(new Frame(bowl));
                } else {
                    firstBowlScore = bowl;
                }
            } else {
                frames.add(new Frame(firstBowlScore, bowl));
                setToFirstBowl();
            }

        }
        return calculateScore();
    }

    private void setFirstBowlScore(Integer score) {
        firstBowlScore = score;
    }

    private void setToFirstBowl() {
        setFirstBowlScore(-1);
    }

    private void handlePreviousSpares(Integer thisBowl, Frame previousFrame) {
        if(isFirstBowl()) {
            if(previousFrame != null && previousFrame.isSpare()) {
                previousFrame.setThirdBowl(thisBowl);
            }
        }
    }

    private void handlePreviousStrikes(Integer thisBowl, Frame previousFrame) {
        if(isFirstBowl()) {
            if(previousFrame != null && previousFrame.isStrike()) {
                previousFrame.setSecondBowl(thisBowl);

                Frame previousPreviousFrame = getPreviousPreviousFrame(); //getFrameForPreviousRoll(); //
                if(previousPreviousFrame != null && previousPreviousFrame.isStrike()) {
                    previousPreviousFrame.setThirdBowl(thisBowl);
                }
            }

        } else {
            if(previousFrame != null && previousFrame.isStrike()) {
                previousFrame.setThirdBowl(thisBowl);
            }
        }
    }

    private Integer calculateScore() {
        Integer score = 0;
        for(Frame frame : frames) {
            score += frame.getScore();
        }
        return score;
    }

    private Frame getFrameForPreviousRoll() {
        if(frames.size() < 1) {
            return null;
        }
        return frames.get(frames.size() - 1);
    }

    private Frame getPreviousPreviousFrame() {
        if(frames.size() < 2) {
            return null;
        }
        return frames.get(frames.size() - 2);
    }

    public boolean isFirstBowl() {
        return firstBowlScore == -1;
    }

    private class Frame {
        private final Integer bowlOne;
        private Integer bowlTwo;
        private Integer bowlThree;

        public Frame(Integer bowlOne) {
            this.bowlOne = bowlOne;
        }

        public Frame(Integer bowlOne, Integer bowlTwo) {
            this.bowlOne = bowlOne;
            this.bowlTwo = bowlTwo;
        }

        public void setSecondBowl(int score) {
            bowlTwo = score;
        }

        public void setThirdBowl(int score) {
            bowlThree = score;
        }

        public int getScore() {

            if(isSpare() && bowlThree == null) {
                return 0;
            }
            if(isStrike() && (bowlTwo == null || bowlThree == null)) {
                return 0;
            }
            return (bowlOne == null ? 0 : bowlOne) +
                    (bowlTwo  == null ? 0 : bowlTwo) +
                    (bowlThree == null ? 0 : bowlThree);
        }

        public boolean isSpare() {
            if(bowlTwo == null) return false;
            return (bowlOne + bowlTwo) == TEN_PINS;
        }

        public boolean isStrike() {
            return bowlOne == TEN_PINS;
        }
    }
}
