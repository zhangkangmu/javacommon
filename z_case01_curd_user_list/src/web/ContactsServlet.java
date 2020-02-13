package web;

import domain.Contact;
import domain.ContactPage;
import domain.SearchContact;
import org.apache.commons.beanutils.BeanUtils;
import service.ContactsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyuhong
 * Date:2020/2/12
 */
@WebServlet("/contactsServlet")
public class ContactsServlet extends HttpServlet {
    private ContactsService contactsService = new ContactsService();
    private int pageNumber = 1;
    private int pagesize = 10;
    private ContactPage contacts;

    public void queryAll(HttpServletRequest request, HttpServletResponse response) {
        try {
            String pageNumber1 = request.getParameter("pageNumber");
            String pagesize1 = request.getParameter("pagesize");

            if (pageNumber1 != null && pagesize1 != null) {
                int pageNumber = Integer.parseInt(pageNumber1);
                int pagesize = Integer.parseInt(pagesize1);
                contacts = contactsService.queryAll(pageNumber, pagesize);
            } else {
                contacts = contactsService.queryAll(this.pageNumber, this.pagesize);
            }

            request.setAttribute("contacts", contacts);
            System.out.println(contacts.getContactAll());
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editPage(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        System.out.println("----准备修改-----------");

        try {
            List<Contact> contacts = contactsService.findById(id);
            Contact con = contacts.get(0);
            request.setAttribute("contact", con);
            System.out.println("contacts.get(0)数据:" + con);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存修改的联系人
     */
    public void edit(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String[]> map = request.getParameterMap();
        try {
            Contact user = new Contact();
            BeanUtils.populate(user, map);
            boolean success = contactsService.saveContact(user);
            if (success) {
                response.sendRedirect(request.getContextPath() + "/contactsServlet?action=queryAll");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteContact(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        System.out.println("删除的id:" + id);
        try {
            boolean scuess = contactsService.deleteContact(id);
            if (scuess) {
                response.sendRedirect(request.getContextPath() + "/contactsServlet?action=queryAll");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addContact(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Contact contact = new Contact();
        try {
            BeanUtils.populate(contact, parameterMap);
            boolean success = contactsService.addContact(contact);
            if (success) {
                response.sendRedirect(request.getContextPath() + "/contactsServlet?action=queryAll");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchContact(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        SearchContact searchContact = new SearchContact();
        try {
            BeanUtils.populate(searchContact, parameterMap);

            ContactPage contactPage = contactsService.searchContact(searchContact, pageNumber, pagesize);
            request.setAttribute("contacts", contactPage);
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //action=queryAll
        try {
            String action = request.getParameter("action");
            Method method = this.getClass().getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
