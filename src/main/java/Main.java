import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        ArrayList<Player> playerList = new ArrayList<>();

        game.register(new Player(1, "Иванов", 1));
        game.register(new Player(2, "Петров", 3));
        game.register(new Player(3, "Сидоров", 3));
        game.register(new Player(4, "Поляков", 2));

        if (game.findByName("Сидоров") != null) {
            System.out.println("Есть");
        } else {
            System.out.println("Нет");
        }
    }
}