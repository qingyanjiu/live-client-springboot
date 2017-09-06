package louis.live.client.mapper;

import louis.live.client.vo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM user_info")
    @Results({
            @Result(property = "userName",  column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "nick", column = "nick"),
            @Result(property = "registerDate", column = "register_date"),
            @Result(property = "lastLoginDate", column = "last_login_date"),
            @Result(property = "trueNameCert", column = "true_name_cert"),
            @Result(property = "trueName", column = "true_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "email", column = "email"),
            @Result(property = "status", column = "status")
    })
    List<User> getAll();

    @Select("SELECT * FROM user_info WHERE id = #{id}")
    @Results({
            @Result(property = "userName",  column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "nick", column = "nick"),
            @Result(property = "registerDate", column = "register_date"),
            @Result(property = "lastLoginDate", column = "last_login_date"),
            @Result(property = "trueNameCert", column = "true_name_cert"),
            @Result(property = "trueName", column = "true_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "email", column = "email"),
            @Result(property = "status", column = "status")
    })
    User getOne(String userId);

    @Insert("INSERT INTO users(username,password,gender) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(User user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);

}
