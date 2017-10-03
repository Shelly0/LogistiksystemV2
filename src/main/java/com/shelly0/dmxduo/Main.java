package com.shelly0.dmxduo;

import com.shelly0.dmxduo.ui.UserInterface;

/**
 * Created by vogeslu on 03.10.17.
 */
public class Main {

    public static MySQL mySQL;
    public static UserInterface userInterface;

    public static void main(String[] args) {
        Main.mySQL = new MySQL();
        if(Main.mySQL.connection != null) {
            Main.mySQL.initialize();
            Main.userInterface = new UserInterface();
            Main.userInterface.createWindow();
        }
    }

}
