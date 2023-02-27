import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;

public class App2 {

    public static void main(String[] args) {
        // 1. 加载配置文件得到 IoC 容器对象
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. 获取 bean
        BookService bookService = (BookService) ioc.getBean("bookService");
        bookService.save();
    }
}
