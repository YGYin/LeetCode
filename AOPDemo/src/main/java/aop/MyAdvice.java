package aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // 告诉 Spring 来加载该类为 bean
@Aspect    // 定义当前类为切面类
public class MyAdvice {
    // 定义切入点，私有，无参数无返回值，方法体实际逻辑
    @Pointcut("execution(void dao.BookDao.update())")
    private void pc() {
    }

    // 定义通知功能，并绑定切入点和通知
    @Before("pc()")
    public void method() {
        System.out.println(System.currentTimeMillis());
    }
}
