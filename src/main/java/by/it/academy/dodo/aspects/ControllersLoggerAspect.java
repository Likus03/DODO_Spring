package by.it.academy.dodo.aspects;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * AOP Aspect for logging requests and responses in the controllers layer.
 */
@Slf4j
@Aspect
@Component
public class ControllersLoggerAspect {
    private static final String LOG_REQUEST_PATTERN = "{} -> {}: {}";

    /**
     * Pointcut definition for methods in the controllers package.
     */
    @Pointcut("execution(* by.it.academy.dodo.controllers..*(..))")
    public void pointCut() {
    }

    /**
     * Advice to log the request information before method execution.
     *
     * @param joinPoint The join point at which the advice is applied.
     */
    @Before("pointCut()")
    public void logRequest(JoinPoint joinPoint) {
        HttpServletRequest request = getHttpServletRequest();
        log.info(LOG_REQUEST_PATTERN,
                request.getMethod(),
                joinPoint.getSignature().toShortString(),
                request.getRequestURI());
    }

    /**
     * Retrieves the current HttpServletRequest.
     *
     * @return The current HttpServletRequest.
     */
    private HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }
}
