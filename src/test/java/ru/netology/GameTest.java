package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;
import ru.netology.manager.Game;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game = new Game();
    private Player first = new Player(1, "First", 1);
    private Player second = new Player(2, "Second", 2);
    private Player third = new Player(3, "Third", 3);
    private Player forth = new Player(4, "Forth", 3);
    private Player fifth = new Player(5, "Fifth", 100);
    private Player sixth = new Player(6, "Sixth", 150);

    @BeforeEach
    void setUp() {
        game.register(first);
        game.register(second);
        game.register(third);
        game.register(forth);
    }

    @Test
    void shouldWinFirstPlayer() {
        int actual = game.round(forth.getName(), second.getName());

        assertEquals(1, actual);
    }

    @Test
    void shouldWinSecondPlayer() {
        int actual = game.round(first.getName(), "SECOND");

        assertEquals(2, actual);
    }

    @Test
    void shouldDraw() {
        int actual = game.round(forth.getName(), third.getName());

        assertEquals(0, actual);
    }

    @Test
    void shouldThrowExceptionUnRegisteredOnePlayer() {
        assertThrows(NotRegisteredException.class,
                () -> game.round(third.getName(), fifth.getName()));
    }

    @Test
    void shouldThrowExceptionUnRegisteredTwoPlayers() {
        assertThrows(NotRegisteredException.class,
                () -> game.round(fifth.getName(), sixth.getName()));
    }

}