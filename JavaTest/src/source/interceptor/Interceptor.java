package source.interceptor;

public interface Interceptor {
    // 假设最终的结果是一个String
    String intercept(Chain chain);

    public interface Chain {
        String request();

        String proceed(String request);
    }
}
