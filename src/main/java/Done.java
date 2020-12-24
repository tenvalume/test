import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Done {
    public String readFile(String filePath) {
        String value;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            value = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Can`t read or found file!");
        }
        return value;
    }

    public List<Double> parseFile(String line) {
        if (line == null) {
            throw new RuntimeException("File is empty");
        }
        String[] s = line.split(" ");
        return Arrays.stream(s).map(str -> Double.parseDouble(str)).collect(Collectors.toList());
    }

    public double calculate(double a, double b, double c, double d) {
        return Math.sqrt(Math.abs(Math.sin(a) - 4 * Math.log(b) / Math.pow(c, d)));
    }

    public static void main(String[] args) {
        Done main = new Done();
        List<Double> list = main.parseFile(main.readFile("src/main/resources/test.txt"));
        System.out.println(main.calculate(list.get(0), list.get(1), list.get(2), list.get(3)));
    }
}
