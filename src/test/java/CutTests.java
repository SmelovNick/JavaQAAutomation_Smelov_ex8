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
                arguments("����� ������� �����, ��������� �� ��������� ���������� ���� � ����, ����� ��������� ��� " +
                        "������ �� ��������� �����!",
                        "����� ������� �����, ��������� �� ��������� ���������� ���� � ����, ����� ��������� ��� ������ ��..."),
                arguments("����� ������� �����, ��������� �� ��������� ���������� ���� � ����, ����� ��������� ��� " +
                                "������ � ��������� ������!",
                        "����� ������� �����, ��������� �� ��������� ���������� ���� � ����, ����� ��������� ��� ������ �..."),
                arguments("����� ������� �����, ��������� �� ��������� ���������� ���� � ����, ����� ��������� ��� " +
                                "������      ��������� ������!",
                        "����� ������� �����, ��������� �� ��������� ���������� ���� � ����, ����� ��������� ��� ������...")
        );
    }

    @Test
    void getCutStringFromNull() {
        stringHelper = new StringHelper(null);
        Assertions.assertThrows(NullPointerException.class, stringHelper::cut);
    }

    @Test
    void originalStringShorterThan100SymbolsExpectedException() {
        stringHelper = new StringHelper("�� ����� ������� �����, ������� ������ ������� ����������");
        Assertions.assertThrows(Exception.class, stringHelper::cut);
    }

    @Test
    void originalStringShorterThan100SymbolsExpectedPassed() {
        stringHelper = new StringHelper("�� ����� ������� �����, ������� ������ ������� ����������");
        Assertions.assertEquals("�� ����� ������� �����, ������� ������ ������� ����������", stringHelper.cut());
    }
}
