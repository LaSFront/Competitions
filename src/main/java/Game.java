import java.util.ArrayList;

public class Game {

    private ArrayList<Player> playerList = new ArrayList<>();
    Player player = new Player();

    public void register(Player player) {
        if (!playerList.contains(player)) {
            playerList.add(player);
        }
    }

    public Player findByName(String name) {
        for (Player player : playerList) {
            if (name == player.getName()) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " is not registered!");

        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName2 + " is not registered!");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}

