package titan_software;

import GUI.*;

public class Titan_Software {

    public static void main(String[] args) {
        
        ConnectionDB con = new ConnectionDB();
        con.Connection();
        
        Login login = new Login();
	login.setVisible(true);
    }
    
}
