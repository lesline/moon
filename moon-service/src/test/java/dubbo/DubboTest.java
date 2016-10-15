package dubbo;

import com.moon.service.impl.UserServiceImpl;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * UserServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十一月 6, 2015</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class DubboTest {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Before
    public void before() throws Exception {
        System.out.println("--------------start----------------");

    }

    @After
    public void after() throws Exception {
        System.out.println("--------------end----------------");

    }

    /**
     * Method: getUsers(User user)
     */
    @Test
    public void testGetUsers() throws Exception {
        System.out.println("-------------------");
            // 创建一个与服务器的连接
            ZooKeeper zk = new ZooKeeper("192.168.136.128:2181", 60000, new Watcher() {
                // 监控所有被触发的事件
                public void process(WatchedEvent event) {
                    System.out.println("EVENT:" + event.getType());
                }
            });

            // 查看根节点
            System.out.println("ls / => " + zk.getChildren("/", true));


            // 关闭连接
            zk.close();
        }


} 
