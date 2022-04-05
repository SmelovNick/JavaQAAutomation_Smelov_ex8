import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringHelper {
//    �������� ����� StringHelper, � ������� ����������� ��������� ������:
//    ����������� - ��������� � ���� ������, � ������� ����� ����� �������� � �������
//    getWordsCount() - �������� ���������� ���� � ������ � ������ ������������. ����� ��� ����� �� ����� �� ���������

//    cut() - ���������� ������, ���������� �� 100 �������� � �������������� ���������� � �����. ���������� ����� ������ � ����� 100 ��������.
//    ���� ��������� ������ "�����������" ������ (����� �����������) ���������� �� �������� �����, �� ������� ����� ����� �������������.
//    �.�. ��������� ���������� ������ �� ������� ����� (��������, "� ���� ���� �����" ������������� � "� ���� ����...", �� �� � "� ���� ���� �..."

//    find(int index, String str) - ����� ���� ��������� str, ������� � ������� index. ���� str ������� ����� ������� index,
//    �� ���������� ��������� �������� ������, ������� �� ������� ��������� str. ���� ���, �� ������������ �������� ������.
//    ��������: ��� ������ "test this class please" ����� find(5, "is") ������ "is class please", � find(10, is) ������ "test this class please"

//    getFirstNumber() - ���������� ������ �����, ������������� � ������ ��� ��������� �����, �.�. ���������� ��������� �/��� ������� ����������.
//    ��� ���������� ����� � ������ ������������� ���������� RuntimeException � ������� "���������� ����� ����� � ������"
//

    static String userInput;

    public StringHelper(String userInput) {
        this.userInput = userInput;
    }

    public int getWordsCount(){
        List<String> wordsArray = Arrays.stream(userInput.trim().split(" ")).collect(Collectors.toList());

        List<String> newList = new ArrayList<>();
        wordsArray.stream()
                .forEach(x -> {
                    if (!x.matches("[-�-��-�a-zA-Z]+")) {
                        newList.add(x);
                    }
                });

        wordsArray.removeAll(newList);
        return wordsArray.size();
    }

    public String cut(){
        String substring = userInput.substring(0, 100);
        while (substring.lastIndexOf(' ') >97) {
            substring = new StringBuilder().deleteCharAt(substring.lastIndexOf(' ')).toString();
        }
        StringBuilder cutString = new StringBuilder(substring).delete(substring.lastIndexOf(' '), substring.length()).append("...");
        return cutString.toString();
    }

    public String find(int index, String str){
        int ind = userInput.indexOf(str, index);
        if (ind == -1) return userInput;
        else return userInput.substring(ind);
    }

    public String getFirstNumber(String input){
            String[] array = input.trim().replaceAll("[^-0-9�-���-�a-zA-z\\.]+", " ").split(" ");
            List<String> result = Arrays.stream(array).filter(p -> p.matches("-?[0-9\\.]+")).collect(Collectors.toList());
            if(result.size() == 0) throw new RuntimeException("���������� ����� ����� � ������");
            return result.get(0);
    }
}
