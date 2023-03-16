import cn.edu.ctgu.junitTest.Triangle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {
    @ParameterizedTest
    @CsvSource({
            "1,2,3,非三角形",
            "-1,2,3,输入错误"
    })
    void testWithCsvSource(int a,int b,int c,String expected) {
        assertEquals(expected, new Triangle().classify(a,b,c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/general.csv", numLinesToSkip = 1)
    void test_csv_file_general(int a, int b, int c, String expected) {
        assertEquals(expected, new Triangle().classify(a,b,c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/robustness.csv", numLinesToSkip = 1)
    void test_csv_file_robustness(int a, int b, int c, String expected) {
        assertEquals(expected, new Triangle().classify(a,b,c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/worstGeneral.csv", numLinesToSkip = 1)
    void test_csv_file_worst_general(int a, int b, int c, String expected) {
        assertEquals(expected, new Triangle().classify(a,b,c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/worstRobustness.csv", numLinesToSkip = 1)
    void test_csv_file_worst_robustness(int a, int b, int c, String expected) {
        assertEquals(expected, new Triangle().classify(a,b,c));
    }

    void worst(){
        int []arr = new int[]{0,1,2,50,99,100,101};
        for (int i : arr) {
            for (int j : arr) {
                for (int k : arr) {
                    new Triangle().classify(i, j, k);
                }
            }
        }
    }

    void robustness(){
        new Triangle().classify(50, 50, 50);
        int []arr = new int[]{0,1,2,99,100,101};
        int []n = new int[]{50,50,50};
        for(int i = 0; i < n.length; i++){
            for (int j = 0; j < 4; j++) {
                n[i] = arr[j];
                new Triangle().classify(n[0], n[1], n[2]);
            }
            n[i] = 50;
        }
    }
}
