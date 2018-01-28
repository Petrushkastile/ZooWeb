import Databases.CreateTable;
import org.json.JSONObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Select extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        StringBuffer sb = new StringBuffer();
        String line = null;

        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                sb.append( line );
        } catch (Exception e) {
            System.out.println( e.toString() );
        }
        try {
            JSONObject jsonObject = new JSONObject( sb.toString() );
            response.setContentType( "charset=UTF-8" );
            PrintWriter out = response.getWriter();
            int command = jsonObject.getInt( "command" );
            switch (command) {
                case 0: //getTypes from table
                    ArrayList<String> types = CreateTable.getAllTypes();
                    JSONObject jsonToReturn0 = new JSONObject();
                    jsonToReturn0.put( "answer", "types" );
                    jsonToReturn0.put( "types", types.toString() );
                    out.println( jsonToReturn0.toString() );
                    break;
                case 1: //get names Zoo
                    ArrayList<String> names = CreateTable.getZoo();
                    JSONObject jsonToReturn1 = new JSONObject();
                    jsonToReturn1.put( "answer", "names" );
                    jsonToReturn1.put( "names", names.toString() );
                    out.println( jsonToReturn1.toString() );
                    break;

                default:
                    System.out.println( "default switch" );
                    break;
            }
        } catch (Exception e) {
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