package source.interceptor;

public class ConnectInterceptor implements Interceptor {
    @Override
    public String intercept(Interceptor.Chain chain) {
        System.out.println("ConnectInterceptor before ");
        String response = chain.proceed(chain.request());
        System.out.println("ConnectInterceptor after :" + response);
        return response;
    }
}
