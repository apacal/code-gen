#code-gen-java
[code-gen-java](https://github.com/apacal/code-gen.git)是一个使用```velocity```来生成java源文件的程序，可以用在一些重复性的编码工作，比如根据xml来生成对应的java文件。
在code-gen-java项目中，是一个根据xml文件生成对应的java源码文件。

### java  版本
大于或等于1.5

###使用方法
在idea中生成jar文件，然后在终端运行（或者直接在idea中运行）
```java -jar jarFile  genType templatePath templateName xmlPath outPath```

```
java -jar out/artifacts/codegen_jar/codegen.jar db /Users/apacalzhong/IdeaProjects/codegen/template/ table.vm /Users/apacalzhong/IdeaProjects/codegen/template/table.db /Users/apacalzhong/IdeaProjects/codegen/build/
```
