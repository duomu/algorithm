package main.java.com.yll.list;

public class ReverseListTest extends Test{

    @Override
    public void runTestCase(Object object) {
        ReverseList reverseList = (ReverseList) object;
        if (cases == null || cases.size() == 0) {
            return;
        }

        boolean result = true;
        String input = null;
        String expectOutput = null;
        String actualOutput = null;
        for (Case testCase : cases) {
            ListNode inputList = ListNode.create(testCase.input);
            ListNode expectOutputList = ListNode.create(testCase.output);
            ListNode actualOutputList = reverseList.reverse(inputList);//静态代理
            if (!checkEquals(expectOutputList, actualOutputList)) {
                input = testCase.input;
                expectOutput = testCase.output;
                actualOutput = ListNode.convertString(actualOutputList);
                result = false;
                break;
            }
        }

        printResult(object.getClass().getSimpleName(), result, input, expectOutput, actualOutput);
    }

    public static void main(String[] args) {
        ReverseListTest test = new ReverseListTest();
        test.runTestCase(new ReverseList());
    }
}
