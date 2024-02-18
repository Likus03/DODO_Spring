package by.it.academy.dodo.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * AOP Aspect for logging method calls and results in the services layer.
 */
@Slf4j
@Aspect
@Component
public class ServicesLoggerAspect {
    private static final String LOG_PATTERN = "{} -> {}: {} -> {}";

    /**
     * Pointcut definition for methods in the services package.
     */
    @Pointcut("execution(* by.it.academy.dodo.services..*(..))")
    public void pointCut() {
    }

    /**
     * Advice to log the method call and result after method execution.
     *
     * @param joinPoint The join point at which the advice is applied.
     * @param result    The returned result from the method.
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void log(JoinPoint joinPoint, Object result) {
        log.info(LOG_PATTERN,
                joinPoint.getSignature().getName(),
                joinPoint.getSignature().toShortString(),
                joinPoint.getArgs(),
                result);
    }
}
