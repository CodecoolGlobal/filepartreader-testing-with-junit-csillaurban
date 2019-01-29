import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {
    private FilePartReader reader;

    public FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }

    public List<String> getWordsOrderedAlphabetically () throws IOException {
        String lines = this.reader.readlines();
        return linesToArray(lines).stream().sorted().collect(Collectors.toList());
    }

    public List<String> getWordsContainingSubstring (String subString) throws IOException{
        String lines = this.reader.readlines();
        return linesToArray(lines).stream().filter(word -> word.contains(subString)).collect(Collectors.toList());
    }

    public List<String> getStringsWhichPalindromes () throws IOException {
        String lines = this.reader.readlines();
        return linesToArray(lines).stream().filter(word -> word.equals(new StringBuffer(word).reverse().toString())).collect(Collectors.toList());
    }

    public ArrayList<String> linesToArray(String lines) {
        return new ArrayList<String>(Arrays.asList(lines.split("\\s+|\\n")));

    }

    public FilePartReader getReader() {
        return reader;
    }
}
