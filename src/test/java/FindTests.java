import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FindTests extends BaseTest{

    @ParameterizedTest
    @MethodSource("methodArgs")
    void findMethodTest(int index, String word, String result, String original){
        stringHelper = new StringHelper(original);
        Assertions.assertEquals(result, stringHelper.find(index, word));
    }

    static Stream<Arguments> methodArgs(){
        return Stream.of(
                Arguments.arguments(90, "одной", "Какая порода собак вам нравится больше всего? Я вот никак не могу отдать предпочтение ни одной - все пёсики одинаково хороши!",
                        "Какая порода собак вам нравится больше всего? Я вот никак не могу отдать предпочтение ни одной - все пёсики одинаково хороши!"),
                Arguments.arguments(9, "одной", "одной - все пёсики одинаково хороши!",
                        "Какая порода собак вам нравится больше всего? Я вот никак не могу отдать предпочтение ни одной - все пёсики одинаково хороши!"),
                Arguments.arguments(100, "Какая", "Какая порода собак вам нравится больше всего?","Какая порода собак вам нравится больше всего?")
        );
    }
}
