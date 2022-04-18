package titan_software;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import GUI.Main_Screen;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {
        public static Connection con = null;
	public static Statement stmt = null;
	public static ResultSet rs = null;
    	public void Connection() {
		
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root","root","Antonio220198");
			stmt = con.createStatement();
			/*rs = stmt.executeQuery("SELECT * FROM titan_software.tbl_movimentacao;");
			
			while(rs.next()) {
				Object[] o = new Object[] {rs.getInt("id"),rs.getString("placa"),rs.getString("modelo"),rs.getString("data_entrada"),rs.getString("data_saida"),rs.getString("tempo"),rs.getDouble("valor_pago"),rs.getBoolean("veiculo_estacionado")};
				//System.out.println(o[0]+" "+o[1]+" "+o[2]+" "+o[3]+" "+o[4]+" "+o[5]+" "+o[6]+" "+o[7]);
				list.add(o);
			}*/

		}catch(Exception e) {
			System.out.println(e);
		}
		
		//return list;
	}
        
        public void CloseConnection() {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
        public void TableUpdate(String query) {
            int id;
            String plate, model, entry, departure, time;
            Double value;
            boolean parked;
            int i = 0;
            Main_Screen.emptyJTable();
            try {
                rs = stmt.executeQuery(query);
                while(rs.next()){
                    id = rs.getInt("id");
                    plate = rs.getString("placa");
                    model = rs.getString("modelo");
                    entry = rs.getString("data_entrada");
                    departure = rs.getString("data_saida");
                    time = rs.getString("tempo");
                    value = rs.getDouble("valor_pago");
                    parked = rs.getBoolean("veiculo_estacionado");                   
                    Main_Screen.setJTable(i, id, plate, model, entry, departure, time, value, parked);
                    i++;
                }
            }
            catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
        public void Entry() {
            TableUpdate("SELECT * FROM titan_software.tbl_movimentacao;");
        }
        
        public void Select(String type) {
            String query = "SELECT * FROM titan_software.tbl_movimentacao " + type;
            TableUpdate(query);
        }
        
        public void Insert(String i1, String i2) {
            Date time = new java.util.Date(System.currentTimeMillis());
            String t = new SimpleDateFormat("HH:mm:ss").format(time);
            System.out.println(t);
            String query = "INSERT INTO `titan_software`.`tbl_movimentacao` (`placa`,`modelo`,`data_entrada`) "+
                 "VALUES ('" + i1 + "','" + i2 + "','" + t +"')";
            try{
                stmt.executeUpdate(query);
                Entry();
            }
            catch(SQLException ex){
                System.out.println(ex);
            }
        }
        
        public void Edit(int i1, String i2, String i3) {
            String query = "UPDATE `titan_software`.`tbl_movimentacao` " +
                "SET "+
                "`placa` ='"+i2+"', "+
                "`modelo` ='"+i3+"' "+
                "WHERE `id` ="+i1;
            
            try{
                stmt.executeUpdate(query);
                Entry();
            }
            catch(SQLException ex){
                System.out.println(ex);
            }
        }
        
        public void Exit(int i1, String i2,String i3, double i4){
            String query = "UPDATE `titan_software`.`tbl_movimentacao` " +
                "SET "+
                "`data_saida` ='"+i2+"', "+
                "`tempo` ='"+i3+"', "+
                "`valor_pago` ='"+i4+"', "+
                "`veiculo_estacionado` = 0 "+
                "WHERE `id` ="+i1;
            
            try{
                stmt.executeUpdate(query);
                Entry();
            }
            catch(SQLException ex){
                System.out.println(ex);
            }
        }
        
        public double Value(int[] a1) {
            double first = 0, others = 0, sum = 0;
            String query = "SELECT * FROM `titan_software`.`tbl_valor` "+
                    "WHERE `id` = 1";
            try{
                rs = stmt.executeQuery(query);
                while(rs.next()){
                    first = rs.getDouble("valor_primeira_hora");
                    others = rs.getDouble("valor_demais_horas");
                }
                
                sum = first + (others*(a1[0]-1)) + others*a1[1]/60;
                
            }
            catch(SQLException ex){
                System.out.println(ex);
            }
            
            return sum;
        }
        
        public boolean Login(String a1, String a2){
            try{
                rs = stmt.executeQuery("SELECT * FROM `titan_software`.`tbl_usuario`");
                while(rs.next()){
                    if(a1.equals(rs.getString("usuario")) && a2.equals(rs.getString("senha"))){
                        return true;
                    }
                }
            }
            catch(SQLException ex){
                System.out.println(ex);
            }
            return false;
        }
}
