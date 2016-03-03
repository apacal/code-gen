package cn.apacal.codegen;

/**
 * Created by apacalzhong on 2/16/16.
 */
public class Formatter {
    public String genGetDBTypeMethod(String type) throws Exception {
        type = type.toLowerCase();
        if (type.equals("byte[]") || type.equals("protobuf") || type.equals("proto")) {
            return "getBlob";
        }

        if (type.equals("short") || type.equals("Short")) {
            return "getShort";
        }

        if (type.equals("boolean") || type.equals("Boolean")) {
            return "getInt";
        }

        if (type.equals("int") || type.equals("Integer")) {
            return "getInt";
        }

        if (type.equals("float") || type.equals("Float")) {
            return "getFloat";
        }

        if (type.equals("double") || type.equals("Double")) {
            return "getDouble";
        }

        if (type.equals("long") || type.equals("Long")) {
            return "getLong";
        }

        if (type.equals("String") || type.equals("string")) {
            return "getString";
        }
        throw new Exception("can't gen db type method :" + type);

    }
    public String getDBType(String type) throws Exception{
        type = type.toLowerCase();

        if (type.equals("byte[]") || type.equals("protobuf") || type.equals("proto")) {
            return "BLOB";
        }

        if (type.equals("short") || type.equals("Short")) {
            return "SHORT";
        }

        if (type.equals("boolean") || type.equals("Boolean")) {
            return "INTEGER";
        }

        if (type.equals("int") || type.equals("Integer")) {
            return "INTEGER";
        }

        if (type.equals("float") || type.equals("Float")) {
            return "FLOAT";
        }

        if (type.equals("double") || type.equals("Double")) {
            return "DOUBLE";
        }

        if (type.equals("long") || type.equals("Long")) {
            return "LONG";
        }

        if (type.equals("String") || type.equals("string")) {
            return "TEXT";
        }
        throw new Exception("can't gen db type:" + type);

    };
}
