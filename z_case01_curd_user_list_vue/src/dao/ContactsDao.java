package dao;

import domain.Contact;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JdbcUtil;

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
        System.out.println("addContact"+contact);
//        Contact{id=null, username='2452', sex='男', age=12, address='广西', QQ='fdf', email='2895903561@qq.com'}
        String sql = "INSERT INTO USER VALUE (NULL,?,?,?,?,?,?,?) ";
        return queryRunner.update(sql,
//                contact.getId(),
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


}
