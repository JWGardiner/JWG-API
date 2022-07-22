package com.jwg.jwgapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static com.jwg.Main.logFile;
import static com.jwg.jwgapi.writeFile.overwriteFile;

public class cfgFileUtils {
    public static void createCfg(File file) throws IOException {
            if (file.createNewFile()) {
                logger.log(logFile, 1, "jwg-cfg", 0, "Created config file");
            } else {
                logger.log(logFile, 1, "jwg-cfg", 1, "Config file already exists");
            }
    }
    public static void addCfg(File file, String entry, String value) throws IOException {
        String fileData = "";
        BufferedReader checkFileEmpty = new BufferedReader(new FileReader(file));
        if (checkFileEmpty.readLine() == null) {
            overwriteFile(String.valueOf(file), entry+" = "+value+"\n");
        } else {
            fileData = readFile.fileRead(String.valueOf(file));
        }
        overwriteFile(String.valueOf(file), fileData+"\n"+entry+" = "+value+"\n");
    }
    public static void modifyCfg(File file, String entry, String newValue, String oldValue) throws IOException{
        String fileData = readFile.fileRead(String.valueOf(file));
        fileData = fileData.replaceFirst(entry + " = " + oldValue, entry + " = " + newValue);
        overwriteFile(String.valueOf(file), fileData);
    }
    public static String readCfg(File file, String entry, int cfgLine) throws IOException {
        String line = "";
        FileReader FileReader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(FileReader);

        for (int i = 0; i < 50; i++) {
            System.out.println(buffer.readLine());
            if (i == cfgLine) {
                line = buffer.readLine();
                break;
            }}
        return line.substring(entry.length()+3);
        }

    }
