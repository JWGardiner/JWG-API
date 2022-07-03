package com.jwg.jwgapi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Scanner;

public class logger {
    public static void StartLogger(String logFile) {
        File LogFile = new File(logFile);
        if (LogFile.exists()) {
            try {
                Files.delete(Path.of(logFile));
            } catch (IOException x) {
                System.err.println(x);
            }
        }
        try {
            if (LogFile.createNewFile()) {
                System.out.println("[LOGGER] (jwgapi) Starting Logger...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void log(String logFile, int version, String name, int severity, String logMessage) {
        String[] logSeverity = {"[INFO]","[WARN]","[ERR]","[ERR/FATAL]","[NULL]"};
        if (severity >= 4) {
            severity = 4;
        }
        String logString = logSeverity[severity] + " (" + name + ", " + version + ") " + logMessage;
        Scanner readLog = new Scanner(logFile);
        String log = "";
        while (readLog.hasNextLine()) {
            log = log + readLog.nextLine() + "\n";
        }
        readLog.close();
        try {
            FileWriter myWriter = new FileWriter(logFile);
            myWriter.write(log);
            myWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(logString);
    }
}