package dao;

import domain.Contact;
import domain.ContactPage;
import domain.SearchContact;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JdbcUtil;

import javax.naming.CompositeName;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/2/12
 */
public class ContactsDao {

    private QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());


    /**
     * @param pageNumber 页码
     * @param pagesize   每页显示多少条数据
     */
    public List<Contact> queryAll(int pageNumber, int pagesize) throws SQLException {
        //        String sql="select * from user limit (pageNumber-1)*pagesize,pagesize";
        String sql = "select * from user limit ?,?";
        return queryRunner.query(sql, new BeanListHandler<>(Contact.class), (pageNumber - 1) * pagesize, pagesize);
    }

    public List<Contact> findById(String id) throws SQLException {
        String sql = "select * from user where id=?";
        return queryRunner.query(sql, new BeanListHandler<>(Contact.class), id);
    }

    public int saveContact(Contact contact) throws SQLException {
        String sql = "update user set username=?,sex=?,age=?,address=?,QQ=?,email=? where id=?";
        System.out.println(contact);
        return queryRunner.update(sql,
                contact.getUsername(),
                contact.getSex(),
                contact.getAge(),
                contact.getAddress(),
                contact.getQQ(),
                contact.getEmail(),
                contact.getId()
        );
    }

    public int addContact(Contact contact) throws SQLException {
        String sql = "INSERT INTO USER VALUE (NULL,?,?,?,?,?,?,?) ";
        return queryRunner.update(sql,
                contact.getUsername(),
                "123456",
                contact.getSex(),
                contact.getAddress(),
                contact.getQQ(),
                contact.getEmail(),
                contact.getAge()
        );
    }

    public int deleteContact(String id) throws SQLException {
        String sql = "delete from user where id=? ";
        return queryRunner.update(sql, id);
    }

    public Long queryCount() throws SQLException {
        String sql = "select count(*) from user ";
        return (Long) queryRunner.query(sql, new ScalarHandler());
    }

    public List<Contact> searchContact(SearchContact searchContact, int pageNumber, int pagesize) throws SQLException {
        String sql = "SELECT * FROM USER WHERE username LIKE ? AND address LIKE ? AND email LIKE ? limit ?,?";
        String searchName = searchContact.getSearchName();
        if (searchName == null) {
            searchName = "";
        }
        String searchAddress = searchContact.getSearchAddress();
        if (searchAddress == null) {
            searchAddress = "";
        }
        String searchEmail = searchContact.getSearchEmail();
        if (searchEmail == null) {
            searchEmail = "";
        }
        System.out.println("---搜索数据---"+searchName+"---"+searchAddress+"----"+searchEmail);
        List<Contact> query = queryRunner.query(sql, new BeanListHandler<>(
            Contact.class), "%" + searchName + "%", "%" + searchAddress + "%", "%" + searchEmail + "%",
            (pageNumber - 1) * pagesize, pagesize);
        return query;
    }

}
