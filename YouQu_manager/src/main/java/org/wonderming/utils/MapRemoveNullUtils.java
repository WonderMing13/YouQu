package org.wonderming.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/17
 * @Time: 15:40
 * @Project: youqu
 * @Package: org.wonderming.utils
 */
public class MapRemoveNullUtils {

    /**
     * 移除map的空key
     * @param map
     * @return
     */
    public void removeNullKey(Map<String,Object> map){
        Set<String> set = map.keySet();
        for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
            Object obj = (Object) iterator.next();
            remove(obj, iterator);
        }
    }

    /**
     * 移除map中的value空值
     * @param map
     * @return
     */
    public  Map<String,Object> removeNullValue(Map<String,Object> map){
        Set<String> set = map.keySet();
        for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
            Object obj = (Object) iterator.next();
            Object value =(Object)map.get(obj);
            remove(value, iterator);
        }
        return map;
    }

    /**
     * 移除map中的空值
     *
     * Iterator 是工作在一个独立的线程中，并且拥有一个 mutex 锁。
     * Iterator 被创建之后会建立一个指向原来对象的单链索引表，当原来的对象数量发生变化时，这个索引表的内容不会同步改变，
     * 所以当索引指针往后移动的时候就找不到要迭代的对象，所以按照 fail-fast 原则 Iterator 会马上抛出 java.util.ConcurrentModificationException 异常。
     * 所以 Iterator 在工作的时候是不允许被迭代的对象被改变的。
     * 但你可以使用 Iterator 本身的方法 remove() 来删除对象， Iterator.remove() 方法会在删除当前迭代对象的同时维护索引的一致性。
     * @param obj
     * @param iterator
     */
    private  void remove(Object obj, Iterator<String> iterator){
        if(obj instanceof String){
            String str = (String)obj;
            if(isEmpty(str)){
                iterator.remove();
            }
        } else{
            if(obj==null){
                iterator.remove();
            }
        }
    }

    public static boolean isEmpty(Object obj){
        return obj == null || obj.toString().length() == 0;
    }
}
