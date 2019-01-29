import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class FilePartReaderTest {
    String filePath = "/home/csilla/codecool/OOP/FileReader/test.txt";
    FilePartReader reader = new FilePartReader();

    @Test
    @DisplayName("Test setup() with toLine smaller than fromLine")
    public void testSetupToLineSmallerThanFromLine() {
        assertThrows(IllegalArgumentException.class, () -> {this.reader.setup(this.filePath, 5, 3);});
    }

    @Test
    @DisplayName("Test setup() with fromLine smaller than 1")
    public void testSetupFromLineSmallerThanOne() {
        assertThrows(IllegalArgumentException.class, () -> {this.reader.setup(this.filePath, -1, 3);});
    }

    @Test
    @DisplayName("Test whether read() returns a String")
    public void testReadReturnsString() throws IOException {
        this.reader.setup(this.filePath, 1,9);
        assertThat(this.reader.read(), instanceOf(String.class));
    }

    @Test
    @DisplayName("Test whether readlines() gives back every line between fromLine and toLine")
    public void testReadlinesContent() throws IOException{
        this.reader.setup(this.filePath, 6,8);
        String expected = "hol a kristály már füstölög,\n" + "és ködbe úszik át a fa,\n" + "akár a test emlékezetbe.\n";
        assertEquals(expected, this.reader.readlines());
    }

    @Test
    @DisplayName("Test whether the same fromLine and toLine returns the expected String")
    public void testSameFromAndToLine() throws IOException{
        this.reader.setup(this.filePath, 2, 2);
        String expected = "Ahogyan talpig zúzmarásak.\n";
        assertEquals(expected, this.reader.readlines());
    }

    @Test
    @DisplayName("Test if toLine is bigger then the number of lines")
    public void testToLinePastEnd() {
        this.reader.setup(this.filePath, 4, 100);
        assertThrows(ArrayIndexOutOfBoundsException.class, ()->{this.reader.readlines();});
    }
}