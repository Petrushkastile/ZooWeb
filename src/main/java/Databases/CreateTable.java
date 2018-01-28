package Databases;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;

public class CreateTable {

        private static final String DB_URL = "jdbc:mysql://localhost:3306/zoo_web";
        private static final String USER_NAME = "root";
        private static final String PASSWORD = "110119841";


        public static Connection conn;
        public static Statement stat;
        public static ResultSet rs;

        public static void Conn() throws ClassNotFoundException, SQLException, NamingException {
            Class.forName( "com.mysql.jdbc.Driver" );
            conn = DriverManager.getConnection( DB_URL, USER_NAME, PASSWORD );
        }

        public static void addTable (String name) throws ClassNotFoundException, SQLException {

            String createTableSQL = "CREATE TABLE IF NOT EXISTS "+name+"("
                    + "ID INT(11) NOT NULL AUTO_INCREMENT, "
                    + "TYPE_OF_ANIMAL VARCHAR(45) NOT NULL, "
                    + "NAME_ANIMAL VARCHAR(45) NOT NULL, "
                    + "AGE_ANIMAL INT(11),"
                    + "PRIMARY KEY (ID)"
                    + ")";
            try {
                Conn();
                stat = conn.createStatement();
                stat.execute(createTableSQL);
                stat.close();
                           } catch (Exception e) {
                System.out.println( e );
            } finally {
                stat.close();
                CloseDB();
            }
        }
    public static void addName(String name) throws ClassNotFoundException, SQLException {
        try {
            Conn();
            stat = conn.createStatement();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO zoo_names (ZOO_NAMES) VALUES (?)");
            statement.setString(1, name);
            statement.execute();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            stat.close();
            CloseDB();
        }
    }

    public static void addAnimal(String[]param) throws ClassNotFoundException, SQLException {
      String prepared = "INSERT INTO "+param[2]+" (TYPE_OF_ANIMAL, NAME_ANIMAL, AGE_ANIMAL) VALUES (?,?,?)";
       String addAnimal = "INSERT INTO "+param[2]+" (TYPE_OF_ANIMAL, NAME_ANIMAL, AGE_ANIMAL) VALUES ("+"'"+param[3]+"'"+","+" '"+param[0]+"'"+","+param[1]+")";
        try {
            Conn();
            stat = conn.createStatement();
            stat.execute(addAnimal);
            stat.close();
        } catch (Exception e) {
            System.out.println( e );
        } finally {
            stat.close();
            CloseDB();
        }
    }
    public static ArrayList<String> getAllTypes() throws ClassNotFoundException, SQLException, NamingException {
        ArrayList<String> types = new ArrayList<String>();
        Conn();
        stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("select type_animal from zoo_animals");

        while (rs.next()) {
            types.add(rs.getString("type_animal"));
        }

        rs.close();
        stat.close();
        CloseDB();

        return types;
}
    public static ArrayList<String> getZoo() throws ClassNotFoundException, SQLException, NamingException {
        ArrayList<String> zoo = new ArrayList<String>();
        Conn();
        stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("select ZOO_NAMES from zoo_names");

        while (rs.next()) {
            zoo.add(rs.getString("ZOO_NAMES"));
        }

        rs.close();
        stat.close();
        CloseDB();

        return zoo;
    }
    public static ArrayList<String> show(String seeZoo) throws ClassNotFoundException, SQLException, NamingException {
        ArrayList<String> animals = new ArrayList<>();
        String show = "SELECT * FROM " + seeZoo + "";
        Conn();
        stat = conn.createStatement();
        ResultSet rs = stat.executeQuery( show );

        while (rs.next()) {
            Animal animal = new Animal();
            animal.setTYPE_OF_ANIMAL(rs.getString("TYPE_OF_ANIMAL"));
            animal.setNAME_ANIMAL(rs.getString("NAME_ANIMAL"));
            animal.setAGE_ANIMAL(rs.getString("AGE_ANIMAL"));
            animals.add( String.valueOf( animal ) );
        }

        rs.close();
        stat.close();
        CloseDB();

        return animals;
    }
    public static void CloseDB() throws ClassNotFoundException, SQLException {
        conn.close();
    }
}
