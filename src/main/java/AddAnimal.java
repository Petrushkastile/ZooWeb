import Databases.CreateTable;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddAnimal  extends HttpServlet {

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String zooName=new String();
            String type = new String();
            String[]param=new String[4];
            StringBuffer sb = new StringBuffer();
            String line = null;

            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                sb.append( line );

            try {
                JSONObject jsonObject = new JSONObject( sb.toString() );
            param[0]=jsonObject.getString( "name" );
            param[1] = jsonObject.getString( "age" );
            param[2] = jsonObject.getString( "zooName" );
            param[3] = jsonObject.getString( "type" );
                try {
                    CreateTable.addAnimal(param);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (JSONException e) {
            }

            String greetings = "Animal "+type+" to "+ zooName + " added successed";
            JSONObject result = new JSONObject();
            response.setContentType("charset=UTF-8");
            PrintWriter out = response.getWriter();
            result.put("result", greetings);
            out.println(result.toString());

        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }
    }

