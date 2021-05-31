package test;

import com.lv.dao.ManagerMap;
import com.lv.pojo.Manager;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ManagerMapTest {
    @Test
    public void managerTest(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        ManagerMap managerMap = (ManagerMap) classPathXmlApplicationContext.getBean("managerMap");
//        所有管理员
        Manager[] manager = managerMap.selectAllManager();
        System.out.println("所有管理员!");
        for (int i = 0; i < manager.length; i++) {
            System.out.println(manager[i]);
        }
//        单一管理员
        Manager manager1 = managerMap.selectManagerById("1001");
        System.out.println("单一管理员!");
        System.out.println(manager1);
//        索引指定管理员
        Manager manager2 = managerMap.selectManager(new Manager("1001","", "123456"));
        System.out.println("指定管理员!");
        System.out.println(manager2 != null);
//        修改密码
        managerMap.updateManager("1001","123456","12345");
        System.out.println("更新管理员!");
        manager1 = managerMap.selectManagerById("1001");
        System.out.println(manager1);
    }
}
