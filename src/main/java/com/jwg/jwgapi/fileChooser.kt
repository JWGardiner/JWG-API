package com.jwg.jwgapi

import java.io.File
import javax.swing.*

fun scanFiles(dir: File): Array<String?> {
    val listOfFiles: Array<File> = dir.listFiles()!!
    var j = 0
    var k = 0
    for (i in listOfFiles.indices) {
        j += 1
    }
    val listOfFileNames = arrayOfNulls<String>(j)
    while (k < j) {
        listOfFileNames[k] = listOfFiles[k].name
        k += 1
    }

    return listOfFileNames
}
    fun fileChooser(startingDir: String, windowTitle: String, allowBack: Boolean): String {
        println(File(startingDir).listFiles())
        //Create the actual window
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
        val model = DefaultListModel<String>()
        val folderList = JList(model)
        folderList.setListData(scanFiles(File(startingDir)))

        val chosenFile = ""
        var dir = startingDir
        JFrame().also { window ->
            window.title = windowTitle
            window.setSize(750, 500)
            window.isResizable = false
            window.layout = null
            window.setLocationRelativeTo(null)
            if (allowBack) {
                val back = JButton("Go Back")
                window.add(back)
                back.setBounds(9, 10, 135, 35)
                back.addActionListener {
                    dir += "/.."
                    folderList.setListData(scanFiles(File(dir)))
                    folderList.updateUI()

                }
            }
            window.add(folderList)
            folderList.setBounds(10, 55, 280, 405)
            window.isVisible = true
        }

        return chosenFile
    }






