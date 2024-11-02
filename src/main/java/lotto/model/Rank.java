package lotto.model;

public enum Rank {
    NONE(0,false,0),
    FIFTH(3,false,5_000),
    FOURTH(4,false,50_000),
    THIRD(5,false,1_500_000),
    SECOND(5,true,30_000_000),
    FIRST(6,false,2_000_000_000);

    private final int matchCount;
    private final boolean requiresBonus;
    private final int prize;

    Rank(int matchCount, boolean requiresBonus, int prize) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isRequiresBonus() {
        return requiresBonus;
    }

    public static Rank getRank(int matchCount, boolean bonusMatch) {
        for (Rank rank : Rank.values()) {
            if(rank.matchCount == matchCount && rank.requiresBonus == bonusMatch) {
                return rank;
            }
        }
        return NONE;
    }
}