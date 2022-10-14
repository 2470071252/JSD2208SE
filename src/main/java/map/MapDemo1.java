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
         */
        map.put("语文", (double) 99);
        map.put("数学", (double) 97);
        map.put("英语", (double) 96);
        map.put("化学", (double) 92);
        map.put("物理", (double) 94);
        System.out.println(map);

    }
}