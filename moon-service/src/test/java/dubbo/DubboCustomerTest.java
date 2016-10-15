package dubbo;

import com.moon.service.api.AccountManage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * UserServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十一月 6, 2015</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class DubboCustomerTest {

     @Resource
     AccountManage accountManage;
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

        Thread.currentThread().sleep(3000000);
        System.out.println(accountManage.getAccountNameByAccountNo("DD"));


    }


} 
