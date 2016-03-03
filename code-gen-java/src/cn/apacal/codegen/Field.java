package cn.apacal.codegen;

/**
 * Created by apacalzhong on 2/17/16.
 */
public class Field {
    public String type;
    public String defaultValue;

    public String getType() {
        return type;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public boolean isNullDefault() {
        if (defaultValue == null || defaultValue.length() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return String.format("type[%s], defaultValue[%s]", type, defaultValue);
    }
}
