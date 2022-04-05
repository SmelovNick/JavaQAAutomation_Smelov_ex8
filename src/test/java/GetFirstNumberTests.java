import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class GetFirstNumberTests extends BaseTest{
    @ParameterizedTest
    @MethodSource("methodArgs")
    void getFirstNumber(String text, double result){
        stringHelper = new StringHelper(text);
        Assertions.assertEquals(result, Double.parseDouble(stringHelper.getFirstNumber(text)));
    }

    static Stream<Arguments> methodArgs(){
        return Stream.of(
                Arguments.arguments("Число, которое необходимо получить в выводе - это число -22, а вот эти 0, -500, 282 - должны быть пропущены", -22),
                Arguments.arguments("Число 044, - это число, которое необходимо получить в выводе, а вот эти 0, -500, 282 - должны быть пропущены", 44),
                Arguments.arguments("Число, которое необходимо получить в выводе - это число -22.1, а вот эти 0, -500, 282 - должны быть пропущены", -22.1)
        );
    }
}
