import Databases.CreateTable;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class PriemParametrami extends HttpServlet{

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String nameZoo = request.getParameter( "nameZoo" );
            String greetings = "Zoo with name " + nameZoo + " create successed";
            try {
                CreateTable.addTable( nameZoo );
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.setContentType( "text/plain" );
            response.getWriter().write( greetings );
        }

    }

