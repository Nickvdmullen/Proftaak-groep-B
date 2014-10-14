/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package steampunky;

import classes.Server;

/**
 *
 * @author Melanie
 */
public class Steampunky {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          Server a = new Server();
          a.createUser("Willem2", "Kat");
          a.loginUser("Willem2", "Kat");
    }
    
}
