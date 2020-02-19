package service;

import dao.SearchKeyWordDao;
import domain.Contact;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/2/18
 */
public class SearchKeyWordService {
    private SearchKeyWordDao keyWordDao=new SearchKeyWordDao();
    public  List<Contact> seacherKeyword(String username) throws SQLException {
        return keyWordDao.searchKeyWord(username);
    }
}
