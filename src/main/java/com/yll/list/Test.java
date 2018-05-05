package main.java.com.yll.list;

import main.java.com.yll.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试父类，所有子类都要实现runTestCase方法，并且自定义类要实现equals方法
 */
public abstract class Test {
    public List<Case> cases;

    public Test() {
        initCases();
    }

    private List<Case> initCases() {
        cases = new ArrayList<Case>();
        List<List<Object>> lists = FileUtil.readTestCases(this.getClass().getSimpleName());
        if (lists == null || lists.size() == 0) {
            return null;
        }

        for (List<Object> list : lists) {
            Integer id = Integer.valueOf((String) list.get(0));
            String input = (String) list.get(1);
            String output = (String) list.get(2);
            Case  testCase = new Case(id,input,output);
            cases.add(testCase);
        }

        return cases;
    }

    public abstract void runTestCase(Object object);

    void printResult(String clazz, boolean passed, String input, String expectOutput, String actualOutput) {
        if (passed) {
            System.out.println(clazz + " pass all case");
        } else {
            System.out.println(clazz + " not pass");
            System.out.println("测试用例：" + input);
            System.out.println("期望结果：" + expectOutput);
            System.out.println("实际结果：" + actualOutput);
        }
    }

    boolean checkEquals(Object obj1, Object obj2) {
        if (obj1 == null && obj2 == null) {
            return true;
        } else if (obj1 == null && obj2 != null) {
            return false;
        } else if (obj1 != null && obj2 == null) {
            return false;
        } else {
            return obj1.equals(obj2);
        }
    }

    class Case {
        Integer id;
        String input;
        String output;

        public Case() {

        }

        public Case(Integer id, String input, String output) {
            this.id = id;
            this.input = input;
            this.output = output;
        }
    }
}
