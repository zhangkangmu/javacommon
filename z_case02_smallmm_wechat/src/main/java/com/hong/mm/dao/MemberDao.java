package com.hong.mm.dao;

import com.hong.mm.pojo.WxMember;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;

/**
 * Created by zhangyuhong
 * Date:2020/3/12
 */
public interface MemberDao {
    @Select(" SELECT * FROM t_wx_member WHERE open_id=#{openid}")
    WxMember findMemberByOpenId(String openid);

    int saveWxMember(WxMember wxMember);


    @Update("UPDATE t_wx_member SET city_id=#{cityID} ,course_id=#{subjectID} where open_id=#{openid}")
    int saveCityCourse(HashMap map);

}
