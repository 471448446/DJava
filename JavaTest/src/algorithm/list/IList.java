package algorithm.list;

/**
 * ����Ļ�������
 * Created by better on 2017/4/18.
 */
interface IList {

    boolean isEmpty();

    void clear();

    Object getElem(int p);

    boolean insert(int p, Object o);

    boolean delete(int p);

    int size();
}
