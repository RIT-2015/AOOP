package compression;

import java.util.Map;

/**
 * Created by Pratik on 10/8/2015.
 */
public class Element<K , V> implements Map.Entry {

    private K key;
    private V value;
    @Override
    public Object getKey() {
        return key;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public Object setValue(Object value) {
        this.value = (V)value;
        return this.value;
    }
}
