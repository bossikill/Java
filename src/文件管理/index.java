package 文件管理;

import java.io.File;
import java.io.FilenameFilter;

//文件过滤
public class index {
    public static void main(String[] args) {
        //用File对象表示一个目录,.表示当前目录
        File dir = new File("./TestDir");
        //创建HTML文件过滤器
        Filter filter = new Filter("html");

        System.out.println("HTML文件目录:" + dir);
        //列出目录TestDir下,文件后缀名为HTML的所有文件
        String files[] = dir.list(filter);//dir.list();
        //遍历文件列表
        for (String fileName : files) {
            File f = new File(dir, fileName);
            if (f.isFile()) {
                System.out.println("文件名:" + f.getName());
                System.out.println("文件绝对路径:" + f.getAbsolutePath());
                System.out.println("文件路径:" + f.getPath());
            } else {
                System.out.println("子目录:" + f);
            }
        }
    }
}

class Filter implements FilenameFilter {
    String extent;

    Filter(String extent) {
        this.extent = extent;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith("." + extent);
    }
}
