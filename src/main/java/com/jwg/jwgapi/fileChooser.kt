package com.jwg.jwgapi

import java.io.IOException
import java.nio.file.*
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JList
import javax.swing.UIManager


fun scanFolder(folder: String): Array<String?> {
    val folders = arrayOfNulls<String>(100000)
    try {
        Files
            .newDirectoryStream(Paths.get(folder)).use { stream ->
                var i = 0
                for (path in stream) {
                    folders[i] = path.toString()
                    i += 1
                }
            }
    } catch (e: IOException) {
        throw RuntimeException(e)
    }
    return folders
}

fun fileChooser(startingDir: String, windowTitle: String): String {
    //Create the actual window
    var dir = startingDir
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
    var folderList = JList(scanFolder(dir))
    val back = JButton("Go Back")
    val chosenFile = ""
    JFrame().also { window ->
        window.title = windowTitle
        window.setSize(750, 500)
        window.isResizable = false
        window.layout = null
        window.setLocationRelativeTo(null)

        window.add(back)
        window.add(folderList)

        window.isVisible = true
        back.addActionListener {
            dir += "/.."
            val lsDir = scanFolder(dir)
            folderList.setListData(lsDir)
            folderList.updateUI()
            
        }
    }
    back.setBounds(9, 10, 135, 35)
    folderList.setBounds(10, 55, 280, 405)

    return chosenFile;
}