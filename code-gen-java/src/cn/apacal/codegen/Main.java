package cn.apacal.codegen;


public class Main {

    /**
     * 使用velocity来生成文件,可以是java源码, cpp源码等
     * java -jar genType templatePath templateName xmlPath outPath
     * genType 使用何种方式
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
            System.out.println("args less, must five args, [genType templatePath templateName xmlPath outPath]");
            System.out.println("genType: as[db]");
            return;
        }

        String genType = args[0];
        String templatePath = args[1];
        String templateName = args[2];
        String xmlPath = args[3];
        String outPath = args[4];

        CodeGen codeGen = new CodeGen();
        if (genType.equals("db")) {
            codeGen.genDBFile(templatePath, templateName, xmlPath, outPath);
        }



    }
}
