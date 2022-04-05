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
                Arguments.arguments("�����, ������� ���������� �������� � ������ - ��� ����� -22, � ��� ��� 0, -500, 282 - ������ ���� ���������", -22),
                Arguments.arguments("����� 044, - ��� �����, ������� ���������� �������� � ������, � ��� ��� 0, -500, 282 - ������ ���� ���������", 44),
                Arguments.arguments("�����, ������� ���������� �������� � ������ - ��� ����� -22.1, � ��� ��� 0, -500, 282 - ������ ���� ���������", -22.1)
        );
    }
}
