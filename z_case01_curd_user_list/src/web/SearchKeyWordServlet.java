package web;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Contact;
import service.SearchKeyWordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/2/18
 */
@WebServlet("/searchKeyWordServlet")
public class SearchKeyWordServlet extends HttpServlet {
    private SearchKeyWordService keyWordService=new SearchKeyWordService();
    private ObjectMapper mapper=new ObjectMapper();
    private List<Contact> contacts;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        if (username != null) {
            try {
                contacts = keyWordService.seacherKeyword(username);
                String json = mapper.writeValueAsString(contacts);
                System.out.println(json);
                response.getWriter().print(json);
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
