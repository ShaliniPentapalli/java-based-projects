// --- Project 4: Ping Pong Game (Console) ---

public class PingPong {
    public static void main(String[] args) {
        int limit = 20; // Adjust for length of game
        for (int i = 1; i <= limit; i++) {
            if (i % 3 == 0 && i % 5 == 0) System.out.println("PingPong");
            else if (i % 3 == 0) System.out.println("Ping");
            else if (i % 5 == 0) System.out.println("Pong");
            else System.out.println(i);
        }
    }
}
