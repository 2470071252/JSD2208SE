package map;

import java.util.HashMap;
import java.util.Map;

/**
 * Map 查找表
 * Map是JAVA集合框架中的一员，但是并不继承自java.util.collection接口！！！
 *
 * Map体现的样子是一个多行两列的表格，其中左列为key，右列为value，
 * Map总是根据key-value对的形式保存数据，且总是根据key获取对应的value
 * Map中可以使用null作为key或value
 * Map中key是唯一的，用equals()比较
 *
 * Map本身是一个接口：
 * 常用的实现类：
 * java.util.HashMap：基于散列算法实现的Map，也称为散列表，当今查询速度最快的数据结构
 * （大量用于缓存服务器上），不受空间复杂度影响
 * java.util.TreeMap：基于二叉树实现的Map
 */
public class MapDemo1 {
    public static void main(String[] args) {
        // 泛型只能用于引用类型
        Map<String,Double> map = new HashMap<>();
        /*
           V put(K k,V v)
           向Map中添加一组键值对。
           由于Map中的key不允许重复，如果使用Map中已有的key存放value时
           则是替换value操作并将被替换的value返回。如果没有任何替换时，返回值为null
         */
        // 如果Map的value是包装类类型时，要用包装类定义的变量接收返回值，避免使用基本类型因自动拆箱导致空指针异常
        Double v = map.put("地理", (double) 99);
        System.out.println(v);
        map.put("语文", (double) 99);
        map.put("数学", (double) 97);
        map.put("英语", (double) 96);
        map.put("化学", (double) 92);
        map.put("物理", (double) 94);
        System.out.println(map);
        // 会将数学原来对应的value返回
        v = map.put("数学",(double)60);
        System.out.println(v);
        System.out.println(map);
        /*
            V get(Object key)
            根据给定的key获取对应的value
         */
        v = map.get("英语");
        System.out.println(v);

        /*
        返回当前Map中的元素个数，每组键值对算一个元素
         */
        int size = map.size();
        System.out.println("size:"+size);

        /*
            V remove(Object key)
            删除Map中指定的Key对应的这组键值对。返回值为这个Key对应的Value
         */
        // v为对应key的value
        v = map.remove("数学");
        System.out.println(v);
        System.out.println(map);

        //判断当前Map是否包含Key：“物理”
        boolean ck = map.containsKey("物理");
        //判断当前Map是否包含Value：92.0
        boolean cv = map.containsValue((double)92);
        System.out.println(ck+","+cv);



        // 清空map
//        map.clear();
//        System.out.println(map);
    }
}
