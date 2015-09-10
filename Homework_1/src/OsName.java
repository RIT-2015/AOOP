/*
 * OsName.java
 *
 * Version:  1.1    2015/08/28  20:30:47
 *
 * Revisions: 1.1   Kapil Dole   2015/08/30     21:54:23
 */

/**
 * This program displays your operating system name.
 *
 * @author      Kapil Dole
 */

public class OsName {

    /**
     * The main program. prints your OS name.
     *
     * @param   args    String array as command line input (ignored)
     */
    public static void main(String args []) {
             System.out.println("OS name: " + System.getProperty("os.name"));
    }
}