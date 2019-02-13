package com.transerainc.adaws.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CallAssociatedData {
    private static Logger LOGGER = LoggerFactory.getLogger(CallAssociatedData.class.getName());

    // <String, Data>
    private final TreeMap<String, Data> dataMap = new TreeMap<String, Data>();

    /**
     * @return
     */
    public SortedMap<String, Data> getDataMap() {
        return dataMap;
    }

    /**
     * @param id
     * @param name
     * @param value
     * @param editable
     */
    public void putData(final String id, final String name, final String value, final boolean editable) {
        final Data data = new Data();
        data.setId(id);
        data.setName(name);
        data.setValue(value);
        data.setEditable(editable);
        dataMap.put(name, data);
    }

    /**
     * @param name
     * @return
     */
    public Data getData(final String name) {
        return dataMap.get(name);
    }

    /**
     * @param name
     * @param value
     */
    public void updateData(final String name, final String value) {
        final Data data = dataMap.get(name);
        if (data != null) {
            data.setValue(value);
        }
    }

    /**
     * @return
     */
    public Iterator<Data> iterator() {
        return dataMap.values().iterator();
    }

    /**
     * @param name
     * @return
     */
    public boolean contains(final String name) {
        return dataMap.containsKey(name);
    }

    /**
     * @param key
     * @return
     */
    public boolean isEditable(final String key) {
        final Data data = getData(key);
        return data != null && data.isEditable();
    }

    /**
     * @return
     */
    public Map<String, String> getKeyValueMap() {
        final Map<String, String> map = new HashMap<String, String>();
        for (final Data data : dataMap.values()) {
            map.put(data.getName(), data.getValue());
        }
        return map;
    }

    /**
     * 
     */
    public void clear() {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Clearing CAD");
        }
        dataMap.clear();
    }

    /**
     * @param cad
     */
    public void merge(final CallAssociatedData cad) {

        for (final Iterator<Data> it = cad.iterator(); it.hasNext();) {
            final Data newData = it.next();
            final Data myData = dataMap.get(newData.getName());
            if (myData != null) {
                myData.setValue(newData.getValue());
                myData.setEditable(newData.isEditable());
            } else {
                dataMap.put(newData.getName(), newData);
            }
        }
    }

    /**
     * @return
     */
    public Set<String> getNames() {
        return dataMap.keySet();
    }

    /**
     * @return
     */
    public boolean isEmpty() {
        return dataMap.isEmpty();
    }

    public static class Data implements Cloneable {

        private String id;
        private String name;
        private String value;
        private String uncommittedValue;
        private boolean editable = false;

        /**
         * @return
         */
        public boolean commit() {
            if (uncommittedValue != null && !uncommittedValue.equals(value)) {
                value = uncommittedValue;
                return true;
            }
            return false;
        }

        /**
         * @return
         */
        public String getId() {
            return id;
        }

        /**
         * @param id
         */
        public void setId(final String id) {
            this.id = id;
        }

        /**
         * @return
         */
        public String getName() {
            return name;
        }

        /**
         * @param name
         */
        public void setName(final String name) {
            this.name = name;
        }

        /**
         * @return
         */
        public String getValue() {
            return value;
        }

        /**
         * @param value
         */
        public void setValue(final String value) {
            this.value = value;
        }

        /**
         * @return
         */
        public String getUncommittedValue() {
            return uncommittedValue;
        }

        /**
         * @param uncommittedValue
         */
        public void setUncommittedValue(final String uncommittedValue) {
            this.uncommittedValue = uncommittedValue;
        }

        /**
         * @return
         */
        public boolean isEditable() {
            return editable;
        }

        /**
         * @param editable
         */
        public void setEditable(final boolean editable) {
            this.editable = editable;
        }

        /**
         * 
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (value == null ? 0 : value.hashCode());
            return result;
        }

        /**
         * 
         */
        @Override
        public boolean equals(final Object obj) {
            if (this == obj) { return true; }
            if (obj == null) { return false; }
            if (getClass() != obj.getClass()) { return false; }
            final Data other = (Data) obj;
            if (name == null) {
                if (other.name != null) { return false; }
            } else if (!name.equals(other.name)) { return false; }
            return true;
        }

        /**
         * 
         */
        @Override
        public Object clone() {
            final Data theClone = new Data();
            theClone.name = name;
            theClone.value = value;
            theClone.editable = editable;
            theClone.uncommittedValue = uncommittedValue;

            return theClone;
        }
    }
}
