package source.interceptor;

import java.util.ArrayList;
import java.util.List;

public class RealInterceptorChain implements Interceptor.Chain {
    private String request;
    // 当前执行哪个 Interceptor
    private int index;
    private List<Interceptor> list = new ArrayList<>();

    public RealInterceptorChain(String request, int index, List<Interceptor> list) {
        this.request = request;
        this.index = index;
        this.list.addAll(list);
    }

    @Override
    public String request() {
        return request;
    }

    @Override
    public String proceed(String request) {
        if (index > list.size()) {
            return null;
        }
        // index +1,下一个
        RealInterceptorChain chain = new RealInterceptorChain(request, index + 1, list);
        // 当前的获取结果，结果是通过index+1获取
        Interceptor interceptor = list.get(index);
        return interceptor.intercept(chain);
    }
}
