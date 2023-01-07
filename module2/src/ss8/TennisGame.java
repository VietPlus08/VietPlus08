package ss8;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int firstPlayerScore, int secondPlayerScore) {
        int tempScore = 0;
        if (firstPlayerScore == secondPlayerScore) {
            return getScoreWhenSamePoint(firstPlayerScore);
        }
        if (cantWinGame(firstPlayerScore) || cantWinGame(secondPlayerScore)) {
            return getScoreWhenRoundHaveTheWinner(firstPlayerScore, secondPlayerScore);
        }
        return getScore(firstPlayerScore) + "-" + getScore(secondPlayerScore);
    }

    private static String getScore(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "";
    }

    private static String getScoreWhenRoundHaveTheWinner(int firstPlayerScore, int secondPlayerScore) {
        String score;
        int minusResult = firstPlayerScore - secondPlayerScore;
        if (minusResult == 1) score = "Advantage player 1";
        else if (minusResult == -1) score = "Advantage player 2";
        else if (minusResult >= 2) score = "Win for player 1";
        else score = "Win for player 2";
        return score;
    }

    private static boolean cantWinGame(int score) {
        return score >= 4;
    }

    private static String getScoreWhenSamePoint(int firstPlayerScore) {
        String score;
        switch (firstPlayerScore) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }
}
