import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FileWordAnalyzerTest {
    String filePath = "/home/csilla/codecool/OOP/FileReader/test.txt";
    FilePartReader reader = new FilePartReader();
    FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);

    @Test
    @DisplayName("Test alphabetical ordering")
    public void testAlpOrder() throws IOException {
        this.analyzer.getReader().setup(filePath, 14, 14);
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("a", "fák", "itt", "kell", "meg", "tanulni"));
        assertEquals(expected, this.analyzer.getWordsOrderedAlphabetically());
    }

    @Test
    @DisplayName("Test whether gets list with words containing substring")
    public void testWordsWithSubstring() throws IOException{
        this.analyzer.getReader().setup(filePath, 1, 15);
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Tanulni", "Ahogyan", "Mozdíthatatlan", "tanulni", "tanulni", "kimondhatatlan"));
        assertEquals(expected, this.analyzer.getWordsContainingSubstring("an"));
    }

    @Test
    @DisplayName("Test whether gets list of palindromes")
    public void testPalindromes() throws IOException {
        this.analyzer.getReader().setup(filePath, 17, 17);
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("kokok"));
        assertEquals(expected, this.analyzer.getStringsWhichPalindromes());
    }
}