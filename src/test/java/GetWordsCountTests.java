import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class GetWordsCountTests extends BaseTest{

    @ParameterizedTest
    @MethodSource("textAndWordCountProvider")
    void countWordsInUsualText(String text, int wordCount){
        stringHelper = new StringHelper(text);
        Assertions.assertEquals(wordCount, stringHelper.getWordsCount(), "Incorrect words count, expected: " + wordCount);
    }

    static Stream<Arguments> textAndWordCountProvider() {
        return Stream.of(
                arguments("Простой текст -22, без каких-либо изысков ...", 5),
                arguments("Простой текст, без каких-либо изысков ...", 5)
        );
    }

    @Test
    void countWordsInNullString() {
        stringHelper = new StringHelper(null);
        Assertions.assertThrows(NullPointerException.class, stringHelper::getWordsCount);
    }

}
