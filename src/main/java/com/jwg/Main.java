package com.jwg;

/*
This file is just here as an example; it is not required for this project to work
The code on line 15, 16, 17 and 19 are important though for the logger.
The version must be X.X.X and the project name must be lowercase.
 */

import com.jwg.jwgapi.cfgFileUtils;
import com.jwg.jwgapi.logger;


import static com.jwg.jwgapi.FileChooserKt.fileChooser;
import static com.jwg.jwgapi.parseVersion.versionInt;

public class Main {
    public static String version = "0.0.3";
    static String project = "jwgapi";
    public static String logFile = "test.log";
    public static void main(String[] args) {
        logger.StartLogger(logFile);
        logger.log(logFile, versionInt(version), project, 0, "Hello, World!");
        logger.log(logFile, versionInt(version), project, 0, "Test Line 2");
        fileChooser("/home/jwg/Projects", "Choose File", true, new String[]{"folder"});
    }
}