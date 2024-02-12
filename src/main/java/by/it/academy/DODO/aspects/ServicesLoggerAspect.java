package by.it.academy.DODO.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ServicesLoggerAspect {
    private static final String LOG_PARAMETER = "{} -> {}: {} -> {}";

    @Pointcut("execution(* by.it.academy.DODO.services..*(..))")
    public void pointCut() {
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void log(JoinPoint joinPoint, Object result) {
        log.info(LOG_PARAMETER,
                joinPoint.getSignature().getName(),
                joinPoint.getSignature().toShortString(),
                joinPoint.getArgs(),
                result);
    }
}
