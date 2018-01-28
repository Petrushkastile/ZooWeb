import java.io.*;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;

import Databases.CreateTable;
import org.json.JSONException;
import org.json.JSONObject;


public class AddNameZoo extends HttpServlet {

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                String nameZoo = new String();
                StringBuffer sb = new StringBuffer();
                String line = null;

                BufferedReader reader = request.getReader();
                while ((line = reader.readLine()) != null)
                    sb.append( line );

                try {
                    JSONObject jsonObject = new JSONObject( sb.toString() );
                    nameZoo = jsonObject.getString( "nameZoo" );
                    try {
                        CreateTable.addTable( nameZoo );
                        CreateTable.addName( nameZoo );
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } catch (JSONException e) {
                }

                String greetings = "Zoo with name " + nameZoo + " create successed";
                JSONObject result = new JSONObject();
                response.setContentType("charset=UTF-8");
                PrintWriter out = response.getWriter();
                result.put("result", greetings);
                out.println(result.toString());

            }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }
    }
