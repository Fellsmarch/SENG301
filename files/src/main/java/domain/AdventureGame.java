package domain;

import domain.Commands.Action;
import domain.Commands.EnterCommand;
import domain.Commands.LeaveCommand;
import domain.Commands.SearchCommand;

import domain.Rooms.CompositeRoom;
import java.util.Random;
import java.util.Scanner;

import domain.Enemies.Ninja;
import domain.Enemies.Turtle;
import domain.Rooms.BasicRoom;
import domain.Rooms.EnemyRoom;
import domain.Rooms.MixedRoom;
import domain.Rooms.TreasureRoom;
import service.Command;
import service.Enemy;
import service.Room;
import service.Treasure;

public class AdventureGame {

    private static Action action = new Action();
    private static Random randomGenerator;
    private static Character character;
    private static int gameSize = 5;

    /**
     * Generates a random setup of a board with rooms, enemies and treasures.
     */
    private static void setupBoard() {
        randomGenerator = new Random();
        Board board = Board.getBoard();
        Room room;
        for (int i = 0; i < gameSize; i++) {
            room = generateRandomRoom();
            board.addRoom(room);

            if (board.getCurrentRoom() == null) {
                board.setCurrentRoom(room);
            }
        }

        character.enter();
    }

    /**
     * Generates a random type of room.
     * @return The room to be added to the board.
     */
    private static Room generateRandomRoom() {
        switch (randomGenerator.nextInt(4)) {
            case 0:
                return new BasicRoom();
            case 1:
                return new EnemyRoom(generateRandomEnemy());
            case 2:
                return new TreasureRoom(generateRandomTreasure());
            case 3:
                //Task 7
                CompositeRoom compRoom = new CompositeRoom();
                compRoom.add(new EnemyRoom(generateRandomEnemy()));
                compRoom.add(new TreasureRoom(generateRandomTreasure()));
                return compRoom;
        }

        return null;
    }

    /**
     * Generates a random enemy.
     * @return An enemy to be added to a room.
     */
    private static Enemy generateRandomEnemy() {
        Enemy enemy;
        switch (randomGenerator.nextInt(2)) {
            case 0:
                enemy = new Ninja();
                character.addEnemy(enemy);
                return enemy;
            case 1:
                enemy = new Turtle();
                character.addEnemy(enemy);
                return enemy;
        }
        return null;
    }

    /**
     * Generates a random treasure.
     * @return A treasure to be added to a room.
     */
    private static Treasure generateRandomTreasure() {
        switch (randomGenerator.nextInt(5)) {
            case 0:
                return Treasure.BRONZE;
            case 1:
                return Treasure.SILVER;
            case 2:
                return Treasure.GOLD;
            case 3:
                return Treasure.DIAMOND;
            case 4:
                return Treasure.ONE_RING;
        }
        return null;
    }

    /**
     * Displays the users score at the end of the game.
     */
    private static void displayScore() {
        System.out.println("You collected a " + character.getCollectedTreasures().toString());
        int totalScore = 0;
        for (Treasure t : character.getCollectedTreasures()) {
            totalScore += t.getScore();
        }
        System.out.println("You got a total of " + totalScore + " points!");
    }

    /**
     * Displays the intro text for the game.
     */
    private static void displayIntro() {
        System.out.println("Welcome to the Adventure Game!");
        System.out.println("You play as Indiana Jones and have found yourself teleported into a random room.");
        System.out.println("Each room contains a portal that you can leave through which will teleport you to another random room.");
        System.out.println("Rooms may contain treasure that you can search for, or an enemy that will attack you. You cannot attack the enemy.");
        System.out.println("The commands are: 'leave' - to leave a room, and 'search' - to search a room for treasure!");
        System.out.println("You are automatically placed in the first room but from there on you need to type 'leave' command in order to be placed into a next room.");
        System.out.println("If you are placed into a treasure room or mixed room make sure you search it first before leaving it!");
        System.out.println("There are " + gameSize + " rooms.");
        System.out.println();
    }

    /**
     * Sets up the scanner which gets user commands entered into the console.
     */
    private static void play() {
        //Task 4 -- Removed line
        displayIntro();
        character = new Character();
        setupBoard();
        String enteredCommand = "";
        while (!enteredCommand.equals("exit") && !Board.getBoard().allRoomsVisited() && !Board.getBoard().isGameOver()) {
            Command command = null;
            Scanner scanner = new Scanner(System.in);
            enteredCommand = scanner.nextLine();
            switch (enteredCommand.toLowerCase()) {
                case "search":
                    command = new SearchCommand(character);
                    action.setCommand(command);
                    break;
                case "leave":
                    command = new LeaveCommand(character);
                    action.setCommand(command);
                    Board.getBoard().changeRoom();
                    if (!Board.getBoard().allRoomsVisited()) {
                        //Task 1
                        command = new EnterCommand(character);
                        action.setCommand(command);
                    }
                    break;
                default:
                    if (!enteredCommand.equals("exit")) {
                        System.out.println("Please enter a valid command.");
                    }
            }

            if (command != null) {
                action.performAction();
            }
        }
        displayScore();
        System.out.println("Game Over!");

    }

    public static void main(String[] args) {
        play();
    }
}
