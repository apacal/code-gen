package cn.apacal.codegen;

import org.apache.commons.lang.SystemUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by apacalzhong on 2/4/16.
 */
public class CodeGen {


    private Formatter formatter;
    public CodeGen() {
        formatter = new Formatter();
    }

    public void genDBFile(String templatesPath, String templateName, String xmlPath, String outPath) {
        System.out.println(String.format("start genDBFile templatesPath[%s], templateName[%s], xmlPath[%s], outPath[%s]", templatesPath, templateName, xmlPath, outPath));
        try {
            Properties p = new Properties();
            p.setProperty("file.resource.loader.path", templatesPath);
            Velocity.init(p);
        }
        catch(Exception e) {
            System.out.println("Problem initializing Velocity : " + e );
            return;
        }

        /* lets make a Context and put data into it */

        VelocityContext context = new VelocityContext();


        context.put("formatter", formatter);




        try {

            File inputFile = new File(xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();

            String packageName = root.getAttribute("package");
            HashMap<String, Field> fields = new HashMap<>();
            String tableName;

            context.put("packageName", packageName);

            String outPackagePath = genPackagePath(outPath, packageName);
            NodeList nList = root.getElementsByTagName("table");
            for(int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    tableName = parseDBInfo(element, fields);
                    context.put("tableName", tableName);
                    context.put("fields", fields);

                    FileWriter w = new FileWriter(outPackagePath + tableName + ".java");

                    /* lets render a template */
                    try {
                        Velocity.mergeTemplate(templateName, "utf-8", context, w );
                    }
                    catch (Exception e ) {
                        System.out.println("Problem merging template : " + e );
                    }

                    w.close();
                    System.out.println("gen java db file: " + outPackagePath + tableName + ".java");
                }

            }


        } catch (Exception e) {
            System.out.print(e);
        }






    }

    private String genPackagePath(String outPath, String packageName) {
        // 对outPath进行添加 / 或者 \ 来表示目录
        if (SystemUtils.IS_OS_WINDOWS &&  outPath.charAt(outPath.length() - 1) != '\\') {
            outPath += "\\";
        } else if (outPath.charAt(outPath.length() - 1) != '/') {
            outPath += "/";
        }

        String path = outPath;


        if (SystemUtils.IS_OS_WINDOWS) {
            path += packageName.replace(".", "\\") + "\\";
        } else {
            path += packageName.replace(".", "/") + "/";
        }
        try {
            File file = new File(path);
            if (!file.isDirectory()) {
                file.delete();
            }
            file.mkdirs();

        } catch (Exception e) {
            System.out.print(e);
        }

        return path;
    }

    private String parseDBInfo(Element tableElement, HashMap<String, Field> fields) {
        fields.clear();
        String tableName = tableElement.getAttribute("name");
        NodeList nodeList = tableElement.getElementsByTagName("field");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                Field field = new Field();
                field.type = element.getAttribute("type");
                field.defaultValue = element.getAttribute("default");
                fields.put(element.getAttribute("name"), field);
            }
        }

        return tableName;



    }



}
