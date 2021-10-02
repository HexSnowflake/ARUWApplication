import java.util.Arrays;

public class TesterCLient {
    public static void main(String[] args) {
        int[] WVM = new int[] {1, 2, 3,};
        int[] VTM = new int[] {2, 3, 1, 2, 3, 4, 5, 6};


        ProtocolParser tester = new ProtocolParser();
        //test WVMprocessing
        for(int i = 0; i < WVM.length - 1; i++) {
            tester.processNewWord(WVM[i]);
        }
        System.out.println(tester.processNewWord(WVM[WVM.length - 1]));

        //testVTMprocessing
        for(int i = 0; i < VTM.length - 1; i++) {
            tester.processNewWord(VTM[i]);
        }
        System.out.println(tester.processNewWord(VTM[VTM.length - 1]));
    }
}
