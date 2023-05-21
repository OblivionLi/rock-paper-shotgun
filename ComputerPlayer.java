package rockpaperscissors;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class ComputerPlayer {
    public String getComputerGesture(Set<String> gestures) {

        List<Integer> gesturesOrdinals = Gesture.getOrdinals(gestures);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int number : gesturesOrdinals) {
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }

        Random random = new Random();
        boolean foundGesture = false;
        StringBuilder computerGesture = new StringBuilder();

        while (!foundGesture) {
            int index = random.nextInt(max - min + 1) - min;
            for (String gesture : gestures) {
                if (Gesture.getOrdinal(gesture) == index) {
                    foundGesture = true;
                    computerGesture.append(gesture);
                }
            }
        }

        return computerGesture.isEmpty() ? "" : computerGesture.toString();
    }
}
