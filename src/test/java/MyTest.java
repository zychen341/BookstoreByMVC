import com.zychen.controller.AccountController;
import com.zychen.pojo.Account;
import com.zychen.pojo.Book;
import com.zychen.pojo.Cart;
import com.zychen.service.AccountService;
import com.zychen.service.BookService;
import com.zychen.service.BookServiceImpl;
import com.zychen.service.CartServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookServiceImpl bookServiceImpl = context.getBean("BookServiceImpl", BookServiceImpl.class);

    }
}
