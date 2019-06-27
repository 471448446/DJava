package source.interceptor;

public class CallServerInterceptor implements Interceptor {
    @Override
    public String intercept(Chain chain) {
        return "success";
    }
}
