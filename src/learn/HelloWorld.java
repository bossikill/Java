package learn;

public class HelloWorld {

//	public static final double PI = 3.14;// 静态常量
//	final int y = 10;// 常量的定义

    public static void main(String[] args) {
//		//打印控制台参数
//		System.out.print(args[0]);
//		System.out.print(args[1]);
//
//		//%s表示格式化字符串
//		System.out.printf("%s", args[2]);
//		System.out.println();
//		int i=123;
//		System.out.printf("%d\n", i);
//
//		double d=123.456;
//		System.out.printf("%f%n", d);
//		System.out.printf("%5.2f", d);

//		String str1 = "Hello";
//		String str2 = str1;
//		str2 = "World";
//		System.out.print(str1);

//		int a = 12;
//		System.out.println(-a);
//		int b = a++;
//		System.out.println(b);
//		b = ++a;
//		System.out.println(b);

//		int[] numbers = { 43, 32, 53, 54, 75, 7, 10 };
//		System.out.println("====for each====");
//		for (int item : numbers) {
//			System.out.println("Count is:" + item);
//		}

        // 数组
//		int[] intArray = { 21, 32, 43, 45 };
//		String[] strArray = { "张三", "李四", "王五", "董六" };
//		int intArray[];
//		intArray = new int[4];
//		intArray[0] = 21;
//		intArray[1] = 32;
//		intArray[2] = 43;
//		intArray[3] = 45;
//
//		String[] stringArrayString = new String[4];
//		stringArrayString[0] = "张三";
//		stringArrayString[1] = "李四";

//		int array1[] = { 20, 10, 50, 40, 30 };
//		int array2[] = { 1, 2, 3 };
//		int array[] = new int[array1.length + array2.length];
//		for (int i = 0; i < array.length; i++) {
//			if (i < array1.length) {
//				array[i] = array1[i];
//			} else {
//				array[i] = array2[i - array1.length];
//			}
//		}
//		System.out.println("合并后");
//		for (int element : array) {
//			System.out.printf("%d\r\n", element);
//		}

        // 多维数组
//		int intArray[][] = { { 1, 2, 3 }, { 11, 12, 13 } };

//		String s7 = new String("Hello");
//		String s8 = new String("Hello");
//		String s9 = "Hello";
//		String s10 = "Hello";
//		System.out.printf("S7==S8:%b%n", s7 == s8);
//		System.out.printf("S9==S10:%b%n", s9 == s10);
//		System.out.printf("S7==S9:%b%n", s7 == s9);
//		System.out.printf("S8==S9:%b%n", s8 == s9);
//		s9 = "world";
//		System.out.printf("%s", s10);

//		String s1 = "Hello";
//		String s2 = s1 + " " + "World ".concat("Java");
//		System.out.println(s2);

//		String sourceString = "There is a string accessing example.";
//		int len = sourceString.length();
//		char ch = sourceString.charAt(16);
//		int firstChar1 = sourceString.indexOf('r');
//		int lastChar1 = sourceString.lastIndexOf('r');
//		System.out.println("原始字符串:" + sourceString);
//		System.out.println("字符串长度:" + len);
//		System.out.println("索引16的字符:" + ch);
//		System.out.println(firstChar1);
//		System.out.println(lastChar1);

        String s1 = new String("Hello");
        String s2 = new String("Hello");
        // 比较字符串是否是相同的引用
        System.out.println("s1==s2:" + (s1 == s2));
        // 比较字符串内容是否相等
        System.out.println("s1.equals(s2):" + (s1.equals(s2)));
        String s3 = "HELlo";
        // 忽略大小写比较字符串内容是否相等
        System.out.println("s1.equalsIgnoreCase(s3):" + (s1.equalsIgnoreCase(s3)));
        // 比较大小
        String s4 = "java";
        String s5 = "Swift";
        // 比较字符串大小s4>s5
        System.out.println("s4.compareTo(s5):" + (s4.compareTo(s5)));
        // 忽略大小写比较字符串大小s4<s5
        System.out.println("s4.compareToIgnoreCase(s5):" + (s4.compareToIgnoreCase(s5)));
        // 判断文件夹中文件名
        String[] docFolder = {"java.docx", "JavaBean.docx", "Objective-C.xlsx", "Swift.docx"};
        int wordDocCount = 0;
        // 查找文件夹中Word文档个数
        for (String doc : docFolder) {
            // 去的前后空格
            doc = doc.trim();
            // 比较后缀是否有.docx字符串
            if (doc.endsWith(".docx")) {
                wordDocCount++;
            }
        }
        System.out.println("文件夹中word文档个数是:" + wordDocCount);
        int javaDocCount = 0;
        // 查找文件夹中Java相关文档个数
        for (String doc : docFolder) {
            // 去的前后空格
            doc = doc.trim();
            // 全部字符转成小写
            doc = doc.toLowerCase();
            // 比较前缀是否有java字符串
            if (doc.startsWith("java")) {
                javaDocCount++;
            }
        }
        System.out.println("文件夹中Java相关文档个数是:" + javaDocCount);
    }
}
