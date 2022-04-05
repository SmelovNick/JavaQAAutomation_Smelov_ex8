import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringHelper {
//    Написать класс StringHelper, в котором реализовать следующие методы:
//    конструктор - принимает в себя строку, с которой далее будем работать в объекте
//    getWordsCount() - получает количество слов в строке с учетом спецсимволов. Цифра или число за слово не считается

//    cut() - возвращает строку, обрезанную до 100 символов с использованием многоточия в конце. Многоточие также входит в лимит 100 символов.
//    Если последний символ "укороченной" строки (перед многоточием) приходится на середину слова, то остаток этого слова выбрасывается.
//    Т.е. обрезание происходит всегда по границе слова (например, "я пишу этот текст" преобразуется в "я пишу этот...", но не в "я пишу этот т..."

//    find(int index, String str) - метод ищет подстроку str, начиная с индекса index. Если str найдена после индекса index,
//    то возвращает подстроку исходной строки, начиная от позиции вхождения str. Если нет, то возвращается исходная строка.
//    Например: для строки "test this class please" метод find(5, "is") вернет "is class please", а find(10, is) вернет "test this class please"

//    getFirstNumber() - возвращает первое число, встретившееся в строке как отдельное слово, т.е. отделенное пробелами и/или знаками препинания.
//    При отсутствии числа в строке выбрасывается исключение RuntimeException с текстом "Невозможно найти число в строке"
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
                    if (!x.matches("[-а-яА-яa-zA-Z]+")) {
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
            String[] array = input.trim().replaceAll("[^-0-9а-яёА-Яa-zA-z\\.]+", " ").split(" ");
            List<String> result = Arrays.stream(array).filter(p -> p.matches("-?[0-9\\.]+")).collect(Collectors.toList());
            if(result.size() == 0) throw new RuntimeException("Невозможно найти число в строке");
            return result.get(0);
    }
}
