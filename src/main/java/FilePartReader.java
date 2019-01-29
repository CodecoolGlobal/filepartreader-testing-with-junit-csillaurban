import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = " ";
        this.fromLine = -1;
        this.toLine = -1;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if(toLine < fromLine) {throw new IllegalArgumentException("toLine is smaller than fromLine");}
        if(fromLine < 1) {throw new IllegalArgumentException("fromLine smaller than 1");}
        else {
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toLine;
        }
    }

    public String read() throws IOException {
        FileReader file = new FileReader(this.filePath);
        BufferedReader br = new BufferedReader(file);
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }

        return sb.toString();
    }

    public String readlines() throws IOException {
        StringBuilder sb = new StringBuilder();
        String text = this.read();
        String[] lines = text.split("\\r?\\n");
        for (int i = this.fromLine - 1; i <= this.toLine - 1; i++) {
            sb.append(lines[i]);
            sb.append("\n");
            if(i==this.toLine) {
                break;
            }
        }
        return sb.toString();
    }
}
