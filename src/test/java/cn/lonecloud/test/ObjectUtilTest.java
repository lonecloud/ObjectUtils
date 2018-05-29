package cn.lonecloud.test;

import cn.lonecloud.test.model.Role;
import cn.lonecloud.test.model.User;
import cn.lonelcoud.util.ObjectUtils;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

/**
 * 测试类
 * Created by lonecloud on 17/3/12.
 * @author lonecloud
 */
public class ObjectUtilTest {

    @Test
    public void obj() throws IllegalAccessException {

        Map<String, Object> map = ObjectUtils.objectToMap(new User(1, "cscs", 232,new Date()));
        for (String name : map.keySet()) {
            System.out.println(name+":"+map.get(name));
        }
    }
    @Test
    public void AllObj() throws IllegalAccessException {
        User user = new User(1, "cscs", 232, new Date());
        user.setRole(new Role(12,"dsds"));
        Map<String, String> map = ObjectUtils.objectToMapString("yy-MM-dd",user,"User.role");
        for (String name : map.keySet()) {
            System.out.println(name+":"+map.get(name));
        }
    }
}
