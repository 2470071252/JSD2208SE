package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Map的遍历
 * 遍历Map有三种方式
 * 1.遍历所有Key
 * 2.遍历每一组键值对
 * 3.遍历所有Value (使用率不高)
 */
public class MapDemo2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("语文",99);
        map.put("数学",98);
        map.put("英语",97);
        map.put("物理",96);
        map.put("化学",99);
        System.out.println(map);

        /*
            遍历所有的key
            Set<K> keySet()
            将当前Map中所有的Key以一个Set集合形式返回。遍历这个集合就等同于遍历所有Key
            // 因为Set集合不能放置重复元素，所有返回一个Set
         */
        Set<String> keySet = map.keySet();
        for ( String key : keySet ) {
            System.out.println("Key："+key);
        }
        System.out.println("------------------------------------");

        /*
        Set<Entry> entrySet()
        将当前Map中的每一组键值对以一个Entry形式表示，并最终以Set集合形式返回所有键值对
        Entry提供了两个常用方法：
        K getKey()
        V getValue()
        来获取其表示的这组键值对的key和value
         */
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        for ( Map.Entry<String,Integer> entry: entrySet ){
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+":"+value);
        }
        System.out.println("------------------------------------");

        /*
            遍历所有的value
            Collection values()
            因为Set集合不能放重复元素，但是value在生产中可能会有重复值
            将当前Map中所有的value以一个集合形式返回
         */
        Collection<Integer> values = map.values();
        for ( Integer e:values ){
            System.out.println("value:"+e);
        }
        System.out.println("------------------------------------");
        /*
            JDK8之后集合框架的成员都支持了基于lambda表达式遍历元素的方法：forEach()

         */
        // 遍历集合
        values.forEach(e-> System.out.println("value:"+e));  // 相当于上面代码
        // lambda变种写法
        System.out.println("-----------------lambda变种写法----------------");
        values.forEach(System.out::println);

        System.out.println("---------------------遍历Map------------------------");
        map.forEach((k,v)-> System.out.println(k+":"+v));
    }
}
