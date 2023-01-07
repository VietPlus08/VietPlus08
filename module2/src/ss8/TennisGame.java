package ss8;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int firstPlayerScore, int secondPlayerScore) {
        String score = "";
        int tempScore = 0;
        if (firstPlayerScore == secondPlayerScore) {
            score = getScoreWhenSamePoint(firstPlayerScore);
        } else if (cantWinGame(firstPlayerScore) || cantWinGame(secondPlayerScore)) {
            score = getScoreWhenRoundHaveTheWinner(firstPlayerScore, secondPlayerScore);
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = firstPlayerScore;
                else {
                    score += "-";
                    tempScore = secondPlayerScore;
                }
                score = getScore(score, tempScore);
            }
        }
        return score;
    }

    private static String getScore(String score, int tempScore) {
        switch (tempScore) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }
        return score;
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
