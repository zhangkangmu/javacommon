package web;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Contact;
import domain.ContactPage;
import service.ContactsService;
import utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/2/20
 */
@WebServlet("/contactsWeb")
public class ContactsWeb extends HttpServlet {
    private ContactsService contactsService = new ContactsService();


    public void delete(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = request.getParameter("id");
            boolean isSuccess = contactsService.deleteContact(id);
            if (isSuccess){
                JsonUtils.printResult(response,new ContactPage(true,"删除成功!"));
            }else{
                JsonUtils.printResult(response,new ContactPage(false,"删除失败!"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updataContact(HttpServletRequest request, HttpServletResponse response) {
        try {
            Contact contact = JsonUtils.parseJSON2Object(request, Contact.class);
            System.out.println(contact);
            boolean isSuccess = contactsService.saveContact(contact);
            if (isSuccess) {
                JsonUtils.printResult(response, new ContactPage(true, "保存成功"));
            } else {
                JsonUtils.printResult(response, new ContactPage(false, "保存失败"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void findById(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = request.getParameter("id");
            System.out.println("findOneContact---:" + id);
            List<Contact> contacts = contactsService.findById(id);
            System.out.println(contacts.get(0));
            if (contacts != null) {
                ContactPage contactPage = new ContactPage(contacts.get(0), true, "成功获取数据");
                JsonUtils.printResult(response, contactPage);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void saveContacts(HttpServletRequest request, HttpServletResponse response) {
        try {
            Contact contact = JsonUtils.parseJSON2Object(request, Contact.class);
            System.out.println(contact);
            boolean saveSuccess = contactsService.addContact(contact);
            if (saveSuccess) {
                JsonUtils.printResult(response, new ContactPage(true, "保存成功"));
            } else {
                JsonUtils.printResult(response, new ContactPage(false, "保存失败"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有的联系人列表
     *
     * @param request
     * @param response
     */
    public void queryAll(HttpServletRequest request, HttpServletResponse response) {
        try {
            ContactPage contactPage = contactsService.queryAll(1, 20);
            contactPage.setFlag(true);
            contactPage.setMessage("查询成功");

            ObjectMapper mapper = new ObjectMapper();
            String string = mapper.writeValueAsString(contactPage);

            JsonUtils.printResult(response, string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        try {
            Method method = this.getClass().getMethod(request.getParameter("action"), HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        this.doPost(request, response);
    }
}
