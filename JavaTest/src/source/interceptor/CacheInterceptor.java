package source.interceptor;

public class CacheInterceptor implements Interceptor {
    @Override
    public String intercept(Interceptor.Chain chain) {
        System.out.println("CacheInterceptor before ");
        String response = chain.proceed(chain.request());
        System.out.println("CacheInterceptor after :" + response);
        return response;
    }
}
