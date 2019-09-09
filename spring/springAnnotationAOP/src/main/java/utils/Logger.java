package utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类,它里面提供了公共的代码
 */
@Component("logger")
@Aspect  //标识当前类是一个切面类
public class Logger {

    @Pointcut("execution(public void service.impl.AccountServiceImpl.saveAccount())")
    private void pointcut1() { }
    /**
     * 用于打印日志,计划让其在切入点方法执行之前执行(切入点方法就是业务层方法)
     */
    @Before(value = "pointcut1()")
    public void printLog() {
        System.out.println("Logger类中的pringLog方法开始记录日志...");
    }

}
