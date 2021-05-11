import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.ditto.entity.Books;
import pers.ditto.service.BookService;
import pers.ditto.service.BookServiceImpl;

import java.util.function.Consumer;

/**
 * @author OrangeCH3
 * @create 2021-05-08 14:47
 */
public class MyTest {

    @Test
    public void test()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookServiceImpl", BookServiceImpl.class);
        for (Books books : bookService.queryAllBook()) {
            System.out.println(books);
        }


    }
}
