import java.util.ArrayList;
import java.util.Arrays;

public class TesterCLient {
    public static void main(String[] args) {
        int[] WVM = new int[] {1, 2, 3,};
        int[] VTM = new int[] {2, 3, 1, 2, 3, 4, 5, 1};
        int[] comprehensiveTest = new int[] {1, 5, 6, 2, 2, 1, 2, 1, 4, 1, 3, 2};


        ProtocolParser tester = new ProtocolParser();
        //test WVMprocessing
        for(int i = 0; i < WVM.length - 1; i++) {
            tester.processNewWord(WVM[i]);
        }
        System.out.println(tester.processNewWord(WVM[WVM.length - 1]));

        //test VTMprocessing
        for(int i = 0; i < VTM.length - 1; i++) {
            tester.processNewWord(VTM[i]);
        }
        System.out.println(tester.processNewWord(VTM[VTM.length - 1]));

        //test comprehensiveTest
        for(int i = 0; i < comprehensiveTest.length; i++) {
            ArrayList<String> result = tester.processNewWord(comprehensiveTest[i]);
            if(i == 2 || i == 8 || i == comprehensiveTest.length - 1) {
                System.out.println(result);
            }
        }
    }
}
