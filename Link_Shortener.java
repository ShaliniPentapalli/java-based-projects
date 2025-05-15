// --- Project 2: Link Shortener Development ---

import java.util.*;

class LinkShortener {
    private Map<String, String> shortToLong = new HashMap<>();
    private Map<String, String> longToShort = new HashMap<>();
    private static final String DOMAIN = "http://short.ly/";

    public String shorten(String longUrl) {
        if (longToShort.containsKey(longUrl)) {
            return DOMAIN + longToShort.get(longUrl);
        }
        String shortCode = Integer.toHexString(longUrl.hashCode());
        shortToLong.put(shortCode, longUrl);
        longToShort.put(longUrl, shortCode);
        return DOMAIN + shortCode;
    }

    public String expand(String shortUrl) {
        String code = shortUrl.replace(DOMAIN, "");
        return shortToLong.getOrDefault(code, "Invalid short URL");
    }
}

class LinkShortenerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkShortener shortener = new LinkShortener();

        while (true) {
            System.out.println("1. Shorten URL\n2. Expand URL\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.print("Enter long URL: ");
                String longUrl = scanner.nextLine();
                System.out.println("Shortened: " + shortener.shorten(longUrl));
            } else if (choice == 2) {
                System.out.print("Enter short URL: ");
                String shortUrl = scanner.nextLine();
                System.out.println("Original: " + shortener.expand(shortUrl));
            } else {
                break;
            }
        }
    }
}
