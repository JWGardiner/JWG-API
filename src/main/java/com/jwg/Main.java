package com.jwg;

/*
This file is just here as an example; it is not required for this project to work
The code on line 15, 16, 17 and 19 are important though for the logger.
The version must be X.X.X and the project name must be lowercase.
 */


import com.jwg.jwgapi.logger;
import com.jwg.jwgapi.swingUtils;
import com.jwg.jwgapi.sysinfo;

import javax.swing.*;

import static com.jwg.jwgapi.parseVersion.versionInt;

public class Main {
    static String version = "0.0.2";
    static String project = "jwgapi";
    static String logFile = "test.log";
    public static void main(String[] args) {
        logger.StartLogger(logFile);
        logger.log(logFile, versionInt(version), project, 0, "Hello, World!");
        logger.log(logFile, versionInt(version), project, 0, "Test Line 2");
        JFrame frame = new JFrame();
        swingUtils.configureJframe(frame, 100, 100, 100, 100, true, true);
        frame.setVisible(true);

        System.getProperties().list(System.out);
    }
}