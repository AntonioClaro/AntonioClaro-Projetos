package tgid_teste;

import GUI.*;

public class TGID_Teste {

    public static void main(String[] args) {
        ConnectionDB con = new ConnectionDB();
        Login_Screen login = new Login_Screen();
        
        con.Connection();
        login.setVisible(true);
        
        
    }
}
