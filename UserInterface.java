package rockpaperscissors;

import java.util.*;

public class UserInterface {

    private final Scanner scanner;
    private final Player player;
    private final ComputerPlayer computerPlayer;

    UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.player = new Player();
        this.computerPlayer = new ComputerPlayer();
    }

    public void startGame() {
        this.greetPlayer();
        Set<String> gestures = this.getGameModeGestures();
        if (!Gesture.containsValue(gestures)) {
            System.out.println("Invalid gestures.");
            return;
        }

        System.out.println("Okay, let's start");

        while (true) {
            String userGesture = this.scanner.nextLine().toUpperCase();
            if (userGesture.equals("!EXIT")) {
                System.out.println("Bye!");
                break;
            }
            String computerGesture = this.computerPlayer.getComputerGesture(gestures);
            if (computerGesture.isEmpty()) {
                System.out.println("Couldn't get computer gesture, please try again.");
                continue;
            }

            if (userGesture.equals("!RATING")) {
                System.out.println("Your rating: " + this.player.getScore());
                continue;
            }

            if (!Gesture.containsValue(userGesture)) {
                System.out.println("User provided invalid gesture.");
                break;
            }

            if (!gestures.contains(userGesture)) {
                System.out.println("User provided gesture that doesn't exist in this current gamemode.");
                break;
            }

            if (userGesture.equals(computerGesture)) {
                System.out.println("There is a draw (" + userGesture.toLowerCase() + ")");
                this.player.addScore(50);
                continue;
            }

            this.getResult(userGesture, computerGesture);
        }
    }

    private void getResult(String userGesture, String computerGesture) {
        int userGestureOrdinal = Gesture.getOrdinal(userGesture);
        if (userGestureOrdinal == -1) {
            System.out.println("Failed to get ordinal for user gesture " + userGesture);
            return;
        }
        int computerGestureOrdinal = Gesture.getOrdinal(computerGesture);
        if (computerGestureOrdinal == -1) {
            System.out.println("Failed to get ordinal for computer gesture " + computerGesture);
            return;
        }

        List<Integer> gameModeGesturesOrdinals = Gesture.getOrdinals();

        int startIndex = gameModeGesturesOrdinals.indexOf(userGestureOrdinal);

        List<Integer> newList = new ArrayList<>();

        newList.addAll(gameModeGesturesOrdinals.subList(startIndex, gameModeGesturesOrdinals.size()));
        newList.addAll(gameModeGesturesOrdinals.subList(0, startIndex));

        int midpoint = (newList.size() + 1) / 2;

        List<Integer> firstHalf = newList.subList(0, midpoint);
        List<Integer> secondHalf = newList.subList(midpoint, newList.size());

        if (secondHalf.contains(computerGestureOrdinal)) {
            System.out.println("Loss: Sorry, but the computer chose " + computerGesture.toLowerCase());
            return;
        }

        if (firstHalf.indexOf(userGestureOrdinal) < firstHalf.indexOf(computerGestureOrdinal)) {
            System.out.println("Win: Well done. The computer chose " + computerGesture.toLowerCase() + " and failed");
            this.player.addScore(100);
        } else {
            System.out.println("Loss: Sorry, but the computer chose " + computerGesture.toLowerCase());
        }
    }

    private void greetPlayer() {
        System.out.print("Enter your name: ");
        String username = this.scanner.nextLine();
        if (username.isEmpty()) {
            System.out.println("Username can't be empty");
            return;
        }

        this.player.setUsername(username);
        System.out.println("Hello, " + this.player.getUsername());
        this.player.initializeScore();
    }

    private Set<String> getGameModeGestures() {
        Set<String> gestures = new HashSet<>();
        String gesturesInput = scanner.nextLine();
        if (gesturesInput.isEmpty()) {
            gestures.add(Gesture.ROCK.name());
            gestures.add(Gesture.SCISSORS.name());
            gestures.add(Gesture.PAPER.name());
            return gestures;
        }

        String[] gesturesList = gesturesInput.split(",");

        for (String gesture : gesturesList) {
            gestures.add(gesture.toUpperCase());
        }

        System.out.println(gestures);
        return gestures;
    }
}
