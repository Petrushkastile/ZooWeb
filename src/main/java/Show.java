import Databases.CreateTable;
import org.json.JSONException;
import org.json.JSONObject;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Show extends HttpServlet {

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String seeZoo = new String();
            StringBuffer sb = new StringBuffer();
            String line = null;

            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                sb.append( line );


            try {
                JSONObject jsonObject = new JSONObject( sb.toString() );
                seeZoo = jsonObject.getString( "showZoo" );
                response.setContentType( "charset=UTF-8" );
                PrintWriter out = response.getWriter();
                    ArrayList<String> animals = CreateTable.show( seeZoo );
                    JSONObject jsonToReturn = new JSONObject();
                    jsonToReturn.put("animals", animals.toString());
                    out.println( jsonToReturn.toString() );



            }catch (Exception e) {
                System.out.println( e.toString() );
            }
        }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType( "text/html" );
        RequestDispatcher dispatcher = request.getRequestDispatcher( "index.html" );
        if (dispatcher != null) {
            dispatcher.forward( request, response );
        }
    }
}


