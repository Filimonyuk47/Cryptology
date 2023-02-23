import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WriteAndReadFile {
    public void write (Path path, String str) throws Exception {
           if (Files.exists(path)) {
               Files.writeString(path,str, StandardOpenOption.WRITE);
           }else {
               Files.createFile(path);
               Files.writeString(path, str, StandardOpenOption.WRITE);
           }
       }
    public char[] read (Path path) throws Exception {
            char[] line = Files.readString(path,
                    StandardCharsets.UTF_8).toCharArray();
            return line;
    }
    int p = 0;
}
