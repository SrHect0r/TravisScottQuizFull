package util;

import logic.Player;
import java.io.*;
import java.util.*;

public class FileUtils {
    public static List<Player> loadRanking(String filePath) {
        List<Player> ranking = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    ranking.add(new Player(parts[0], Integer.parseInt(parts[1])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ranking;
    }

    public static void saveRanking(List<Player> ranking, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Player p : ranking) {
                writer.write(p.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
