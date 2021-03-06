package com.bartdebever.twetter.interceptors;

import com.bartdebever.twetter.helpers.Twetter;
import com.bartdebever.twetter.interceptors.interfaces.ILogPerformanceInterceptor;
import com.google.common.base.Stopwatch;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.concurrent.TimeUnit;

@Interceptor
@ILogPerformanceInterceptor
public class LogPerformanceInterceptor {

    @AroundInvoke
    public void logPerformance(InvocationContext ctx) throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            ctx.proceed();
        }
        finally {
            stopwatch.stop();
            Twetter.getLogger("PerformanceLogger").info("%s %s: %s ms.", ctx.getTarget().toString(), ctx.getMethod().toString(), stopwatch.elapsed(TimeUnit.MILLISECONDS));
        }
    }
}
