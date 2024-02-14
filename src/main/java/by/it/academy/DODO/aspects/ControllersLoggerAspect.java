package by.it.academy.DODO.aspects;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
    private static final String LOG_REQUEST_PARAMETER = "{} -> {}: {}";
    private static final String LOG_RESPONSE_PARAMETER = "{} -> {}: {}, request = {}";

    /**
     * Pointcut definition for methods in the controllers package.
     */
    @Pointcut("execution(* by.it.academy.DODO.controllers..*(..))")
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
        log.info(LOG_REQUEST_PARAMETER,
                request.getMethod(),
                joinPoint.getSignature(),
                request.getRequestURI());
    }

    /**
     * Advice to log the response information after method execution.
     *
     * @param joinPoint The join point at which the advice is applied.
     * @param response  The returned response from the method.
     */
    @AfterReturning(value = "pointCut()", returning = "response")
    public void logResponse(JoinPoint joinPoint, Object response) {
        HttpServletRequest request = getHttpServletRequest();
        log.info(LOG_RESPONSE_PARAMETER,
                request.getMethod(),
                joinPoint.getSignature().toShortString(),
                request.getRequestURI(),
                response);
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
