package source.interceptor;

public class BridgeInterceptor implements Interceptor {
    @Override
    public String intercept(Chain chain) {
        System.out.println("BridgeInterceptor before ");
        String response = chain.proceed(chain.request());
        System.out.println("BridgeInterceptor after :" + response);
        return response;
    }
}
