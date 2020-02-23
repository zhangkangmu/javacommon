package service;

import dao.ContactsDao;
import domain.Contact;
import domain.ContactPage;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/2/12
 */
public class ContactsService {
    private ContactsDao contactsDao=new ContactsDao();
    public  ContactPage queryAll(int pageNumber, int pagesize) throws SQLException {
        //1.获得查询到的limit的全部列表
        List<Contact> contacts = contactsDao.queryAll(pageNumber, pagesize);
        //2.算出总页数
        int count = Math.toIntExact(contactsDao.queryCount());
        ContactPage contactPage = getContactPage(count,pageNumber, pagesize, contacts);
        return contactPage;
    }


//     这样封装数据有问题
    public   List<Contact> findById(String id) throws SQLException {
      return contactsDao.findById(id);
    }

    public boolean saveContact(Contact contact) throws SQLException {
        int i = contactsDao.saveContact(contact);
        return i>0;
    }

    public boolean addContact(Contact contact) throws SQLException {
        int i = contactsDao.addContact(contact);
        return i>0;
    }

    public boolean deleteContact(String id) throws SQLException {
        return contactsDao.deleteContact( id)>0;
    }

    /**
     * @param pageNumber 页码
     * @param pagesize  每页显示的数量
     * @param contacts  封装好了的联系人数据
     * @return
     * @throws SQLException
     */
    private ContactPage getContactPage(int count,int pageNumber, int pagesize, List<Contact> contacts) throws SQLException {


        int ceil = (int) Math.ceil(count*1.0 / pagesize);
        //3.当前页数pageNumber
        //4.每页数量pagesize
        ContactPage contactPage = new ContactPage();
        //设置联系人
        contactPage.setContactAll(contacts);
        //设置全部页数
        contactPage.setPageNumberAll(ceil);
        //设置页码
        contactPage.setPageNumber(pageNumber);
        //设置全部条目数
        contactPage.setTotalNumber(count);
        //设置显示页数
        contactPage.setPagesize(pagesize);
        return contactPage;
    }
}
