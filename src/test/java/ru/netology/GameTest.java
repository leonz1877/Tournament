package ru.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();

    Player playerVanDamme = new Player(11,"VanDamme", 80);
    Player playerSchwarzenegger = new Player(12,"Schwarzenegger", 80);
    Player playerLee = new Player(31,"Lee", 120);
    Player playerNorris = new Player(14,"Norris", 999);



    //Силы игроков равны
    @Test
    public void playersAreEqualTest() {

        game.register(playerSchwarzenegger);
        game.register(playerVanDamme);


        int excpected = 0;

        int actual = game.round ("Schwarzenegger", "VanDamme");

        Assertions.assertEquals(excpected, actual);
    }

    //Игрок 1 сильнее
    @Test
    public void player1IsStrongerTest() {

        game.register(playerNorris);
        game.register(playerLee);


        int excpected = 1;

        int actual = game.round ("Norris", "Lee");

        Assertions.assertEquals(excpected, actual);
    }

    //Игрок 2 сильнее
    @Test
    public void player2IsStrongerTest() {

        game.register(playerVanDamme);
        game.register(playerLee);


        int excpected = 2;

        int actual = game.round ("VanDamme", "Lee");

        Assertions.assertEquals(excpected, actual);
    }

    //Игрок 1 не зарегистрирован
    @Test
    public void player1NotRegisteredTest() {

        game.register(playerVanDamme);
        game.register(playerLee);

        Assertions.assertThrows(NotRegisteredException.class,() -> {
            game.round ("VanDamm", "Lee");
                    });
    }

    //Игрок 1 не зарегистрирован
    @Test
    public void player2NotRegisteredTest() {

        game.register(playerVanDamme);
        game.register(playerLee);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("VanDamme", "Li");
        });
    }


}
