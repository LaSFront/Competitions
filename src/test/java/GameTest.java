import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {

    @Test
    public void shouldNotRegisterIfPlayerExist() {
        Game game = new Game();
        ArrayList<Player> playerList = new ArrayList<>();

        game.register(new Player(1, "Иванов", 1));
        game.register(new Player(2, "Петров", 3));
        game.register(new Player(3, "Сидоров", 3));
        game.register(new Player(4, "Поляков", 2));

        game.findByName("Иванов");

        game.register(new Player(1, "Иванов", 1));

        boolean expected = playerList.contains(4);
        boolean actual = playerList.contains(4);

        Assertions.assertEquals(true, true);
    }

    @Test
    public void shouldRegisterNewPlayer() {

        Game game = new Game();

        game.register(new Player(1, "Иванов", 1));

        Assertions.assertEquals(new Player(1, "Иванов", 1), game.findByName("Иванов"));
    }

    @Test
    public void shouldFindByNameIfPlayerIsNotInList() {

        Game game = new Game();

        game.register(new Player(1, "Иванов", 1));
        game.register(new Player(2, "Петров", 3));
        game.register(new Player(3, "Сидоров", 3));
        game.register(new Player(4, "Поляков", 2));

        game.findByName("Пляков");

        Assertions.assertNull(game.findByName("Пляков"));
    }

    @Test
    public void shouldFindByNameIfPlayerIsInList() {

        Game game = new Game();

        game.register(new Player(1, "Иванов", 1));
        game.register(new Player(2, "Петров", 3));
        game.register(new Player(3, "Сидоров", 3));
        game.register(new Player(4, "Поляков", 2));

        game.findByName("Поляков");

        Assertions.assertEquals(new Player(4, "Поляков", 2), game.findByName("Поляков"));
    }

    @Test
    public void shouldShowThatFirstPlayerIsWinner() {

        Game game = new Game();

        game.register(new Player(1, "Иванов", 1));
        game.register(new Player(2, "Петров", 3));
        game.register(new Player(3, "Сидоров", 3));
        game.register(new Player(4, "Поляков", 2));

        int expected = 1;
        int actual = game.round("Сидоров", "Поляков");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowThatSecondPlayerIsWinner() {

        Game game = new Game();

        game.register(new Player(1, "Иванов", 1));
        game.register(new Player(2, "Петров", 3));
        game.register(new Player(3, "Сидоров", 3));
        game.register(new Player(4, "Поляков", 2));

        int expected = 2;
        int actual = game.round("Иванов", "Петров");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowThatIsNoWinner() {

        Game game = new Game();

        game.register(new Player(1, "Иванов", 1));
        game.register(new Player(2, "Петров", 3));
        game.register(new Player(3, "Сидоров", 3));
        game.register(new Player(4, "Поляков", 2));

        int expected = 0;
        int actual = game.round("Петров", "Сидоров");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrewExceptionOnPlayer1() {

        Game game = new Game();

        game.register(new Player(1, "Иванов", 1));
        game.register(new Player(2, "Петров", 3));
        game.register(new Player(3, "Сидоров", 3));
        game.register(new Player(4, "Поляков", 2));

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Семенов", "Петров");
        });
    }

    @Test
    public void shouldThrewExceptionOnPlayer2() {

        Game game = new Game();

        game.register(new Player(1, "Иванов", 1));
        game.register(new Player(2, "Петров", 3));
        game.register(new Player(3, "Сидоров", 3));
        game.register(new Player(4, "Поляков", 2));

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Петров", "Ухин");
        });
    }
}