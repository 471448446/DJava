package source.interceptor;

import java.util.ArrayList;
import java.util.List;

public class InterceptorMain {
    public static void main(String[] args) {
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new BridgeInterceptor());
        interceptors.add(new CacheInterceptor());
        interceptors.add(new ConnectInterceptor());
        interceptors.add(new CallServerInterceptor());

        String request = "getUserName";
        RealInterceptorChain chain = new RealInterceptorChain(request, 0, interceptors);
        chain.proceed(request);
    }

}
