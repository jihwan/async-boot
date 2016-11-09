package x3.benjamin.study.async;

import org.junit.Test;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by benjamin on 2016. 11. 7..
 */
public class StreamExample3 {

    @Test
    public void testCreateStreamFromIO() {

        try (BufferedReader bis = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/textfile.txt")))){
            List<String> lines = bis.lines()
                    .peek(System.out::println)
                    .collect(Collectors.toList());
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
