package service;

/**
 * Treasure Enum
 * Each enum contains a score and overrides of the getScore and revealTreasure methods.
 */
public enum Treasure {
    BRONZE {
        public int score = 10;
        @Override
        public int getScore() {
            return score;
        }
        @Override
        public void revealTreasure() {
            System.out.println("Yipe, you just got a bronze bar!");
        }
    },
    SILVER {
        public int score = 20;
        @Override
        public int getScore() {
            return score;
        }
        @Override
        public void revealTreasure() {
            System.out.println("Yipe, you just got a silver bar!");
        }
    },
    GOLD{
        private int score = 30;
        @Override
        public int getScore() {
            return score;
        }
        @Override
        public void revealTreasure() {
            System.out.println("Yipe, you just got a gold bar!");
        }
    },
    DIAMOND{
        public int score = 50;
        @Override
        public int getScore() {
            return score;
        }
        @Override
        public void revealTreasure() {
            System.out.println("Yipe, you just got a diamond!");
        }
    },
    ONE_RING{
        private int score = 100;
        @Override
        public int getScore() {
            return score;
        }
        @Override
        public void revealTreasure() {
            System.out.println("Yipe, you just got the one ring!");
        }
    };

    public abstract void revealTreasure();

    public abstract int getScore();
}
