import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CutTests extends BaseTest{

    @ParameterizedTest
    @MethodSource("textParametersProvider")
    void getCutStringFromOriginal(String text, String result){
        stringHelper = new StringHelper(text);
        Assertions.assertTrue(result.equals(stringHelper.cut()));
    }

    static Stream<Arguments> textParametersProvider() {
        return Stream.of(
                arguments("Очень длинный текст, состоящий из различных комбинаций букв и цифр, нужно заполнить эту " +
                        "строку до победного конца!",
                        "Очень длинный текст, состоящий из различных комбинаций букв и цифр, нужно заполнить эту строку до..."),
                arguments("Очень длинный текст, состоящий из различных комбинаций букв и цифр, нужно заполнить эту " +
                                "строку д победного концаа!",
                        "Очень длинный текст, состоящий из различных комбинаций букв и цифр, нужно заполнить эту строку д..."),
                arguments("Очень длинный текст, состоящий из различных комбинаций букв и цифр, нужно заполнить эту " +
                                "строку      победного концаа!",
                        "Очень длинный текст, состоящий из различных комбинаций букв и цифр, нужно заполнить эту строку...")
        );
    }

    @Test
    void getCutStringFromNull() {
        stringHelper = new StringHelper(null);
        Assertions.assertThrows(NullPointerException.class, stringHelper::cut);
    }

    @Test
    void originalStringShorterThan100SymbolsExpectedException() {
        stringHelper = new StringHelper("Не очень длинный текст, который должен вызвать исключение");
        Assertions.assertThrows(Exception.class, stringHelper::cut);
    }

    @Test
    void originalStringShorterThan100SymbolsExpectedPassed() {
        stringHelper = new StringHelper("Не очень длинный текст, который должен вызвать исключение");
        Assertions.assertEquals("Не очень длинный текст, который должен вызвать исключение", stringHelper.cut());
    }
}
