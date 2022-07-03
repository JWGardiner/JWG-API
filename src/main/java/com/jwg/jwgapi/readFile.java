package com.jwg.jwgapi;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class readFile {
    public String fileRead(String filePath) throws IOException {
        String file = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        return file;
    }
    public String fileReadLine(String filepath, int line) throws IOException {
        String file = Files.readAllLines(Paths.get(filepath)).get(line);
        return file;
    }
}