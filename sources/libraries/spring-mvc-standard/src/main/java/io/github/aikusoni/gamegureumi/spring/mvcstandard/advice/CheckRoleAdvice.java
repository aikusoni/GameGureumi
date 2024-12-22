package io.github.aikusoni.gamegureumi.spring.mvcstandard.advice;

import io.github.aikusoni.gamegureumi.spring.core.constants.ErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;

import static io.github.aikusoni.gamegureumi.spring.mvcstandard.constants.WebMvcMessageCode.*;

@Slf4j
@Aspect
@Component
public class CheckRoleAdvice implements Ordered {
    @Override
    public int getOrder() {
        return 1;
    }

    @Before("@annotation(io.github.aikusoni.gamegureumi.spring.mvcstandard.advice.CheckRole)")
    public void checkRole(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            throw new io.github.aikusoni.gamegureumi.spring.core.exception.GureumiRuntimeException(ErrorCode.FORBIDDEN, "RCA-000001", NO_REQUEST_ATTRIBUTES);
        }

        HttpServletRequest request = attributes.getRequest();
        String roles = request.getHeader("X-Roles");

        if (roles == null) {
            throw new io.github.aikusoni.gamegureumi.spring.core.exception.GureumiRuntimeException(ErrorCode.FORBIDDEN, "RCA-000002", NO_ROLES);
        }

        Method method = getMethodFromJoinPoint(joinPoint);
        CheckRole checkRole = method.getAnnotation(CheckRole.class);
        if (checkRole == null) {
            throw new io.github.aikusoni.gamegureumi.spring.core.exception.GureumiRuntimeException(ErrorCode.INTERNAL_SERVER_ERROR, "RCA-000004", FAILED_TO_ACCESS_SERVER_ERROR);
        }

        String requiredRole = checkRole.value();
        if (!roles.contains(requiredRole)) {
            throw new io.github.aikusoni.gamegureumi.spring.core.exception.GureumiRuntimeException(ErrorCode.FORBIDDEN, "RCA-000003", NO_PERMISSION);
        }
    }

    private Method getMethodFromJoinPoint(JoinPoint joinPoint) {
        var signature = joinPoint.getSignature();
        var methodSignature = (org.aspectj.lang.reflect.MethodSignature) signature;
        Class<?> targetClass = joinPoint.getTarget().getClass();

        Method method = null;
        try {
            Class<?>[] parameterTypes = methodSignature.getParameterTypes();
            method = targetClass.getMethod(methodSignature.getName(), parameterTypes);
        } catch (NoSuchMethodException e) {
            throw new io.github.aikusoni.gamegureumi.spring.core.exception.GureumiRuntimeException(ErrorCode.INTERNAL_SERVER_ERROR, "RCA-000005", FAILED_TO_ACCESS_SERVER_ERROR);
        }
        return method;
    }
}

