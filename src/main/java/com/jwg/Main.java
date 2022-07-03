package com.jwg;

/*
This file is just here as an example; it is not required for this project to work
The code on line 9 and 10 are important though for the logger.
The version must be X.X.X and the project name must be lowercase.
 */

import com.jwg.jwgapi.logger;

import static com.jwg.jwgapi.parseVersion.versionInt;

public class Main {
    static String version = "0.0.1";
    static String project = "jwgapi";
    public static void main(String[] args) {
        logger.StartLogger("test.log");
        logger.log("test.log", versionInt(version), project, 0, "Hello, World!");
        logger.log("test.log", versionInt(version), project, 0, "WEeeee");
    }
}