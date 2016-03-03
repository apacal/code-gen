package cn.apacal.codegen;


public class Main {

    /**
     * 使用velocity来生成文件,可以是java源码, cpp源码等
     * java -jar templatePath templateName xmlPath outPath
     * templatePath velocity的模版目录路径
     * templateName 模版文件名
     * xmlPath java读取数据的xml文件路径
     * outPath 生成文件的目录
     * @param args
     */
    public static void main(String[] args) {

//        String templatePath = "/Users/apacalzhong/src/code-gen/code-gen-java/template/";
//        String templateName = "table.vm";
//        String xmlPath = "/Users/apacalzhong/src/code-gen/code-gen-java/template/table.db";
//        String outPath = "/Users/apacalzhong/src/code-gen/code-gen-java/build";

        if (args.length < 4) {
            System.out.println("args less, must four args, [templatePath templateName xmlPath outPath]");
            return;
        }

        String templatePath = args[0];
        String templateName = args[1];
        String xmlPath = args[2];
        String outPath = args[3];

        CodeGen codeGen = new CodeGen();
        codeGen.genDBFile(templatePath, templateName, xmlPath, outPath);



    }
}
