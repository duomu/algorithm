package main.java.com.yll.list;

import java.util.ArrayList;

/**
 * @author：linlin.yang
 * @date：2018/3/23 16:32
 */
public class DeleteDuplicateTest extends Test{

    public void runTestCase(Object object) {
        DeleteDuplicate deleteDuplicate = (DeleteDuplicate) object;
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
            ListNode actualOutputList = deleteDuplicate.deleteDuplicate(inputList);//静态代理
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
        DeleteDuplicateTest test = new DeleteDuplicateTest();
        test.runTestCase(new DeleteDuplicateSolution());
        test.runTestCase(new DeleteDuplicateSolution2());
        test.runTestCase(new DeleteDuplicateSolution3());
    }


}
