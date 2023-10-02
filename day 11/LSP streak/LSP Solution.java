class Solution {
    abstract class Player {
        // Method for making a move
        public abstract boolean canMakeMove(String colors, int index);
    }

    class Alice extends Player {
        @Override
        public boolean canMakeMove(String colors, int index) {
            // Implement Alice's logic for making a move
            return index > 0 && index < colors.length() - 1 &&
                colors.charAt(index) == 'A' &&
                colors.charAt(index - 1) == 'A' &&
                colors.charAt(index + 1) == 'A';
        }
    }

    class Bob extends Player {
        @Override
        public boolean canMakeMove(String colors, int index) {
            // Implement Bob's logic for making a move
            return index > 0 && index < colors.length() - 1 &&
                colors.charAt(index) == 'B' &&
                colors.charAt(index - 1) == 'B' &&
                colors.charAt(index + 1) == 'B';
        }
    }

    public boolean winnerOfGame(String colors) {
        Player alice = new Alice();
        Player bob = new Bob();
        Player currentPlayer = alice; // Alice starts first

        for (int i = 1; i < colors.length() - 1; i++) {
            if (currentPlayer.canMakeMove(colors, i)) {
                // Make the move
                currentPlayer = (currentPlayer == alice) ? bob : alice; // Switch players
            } else {
                // The current player loses
                return currentPlayer == alice; // Alice wins if it's her turn
            }
        }

        // If the loop finishes, the last player to make a move wins
        return currentPlayer == bob;
    }
}
