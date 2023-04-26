package Task_03;


public class Main {
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "";
        String s5 = "dvdf";
        lengthOfLongestSubstring(s1);
        lengthOfLongestSubstring(s2);
        lengthOfLongestSubstring(s3);
        lengthOfLongestSubstring(s4);
        lengthOfLongestSubstring(s5);
    }

    public static int lengthOfLongestSubstring(String s){
        if (s == null || s.length() == 0) return 0;
        String currentStrint = "" + s.charAt(0);
        String answer = currentStrint;
        //Номер буквы с которой начался повтор
        int repeatIndex = 0;
        //Для каждой буквы из переданной строки
        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            //Проверяем, повторяются ли буквы
            boolean repeat = false;
            for (int j = 0; j < currentStrint.length(); j++) {
                if (currentStrint.charAt(j) == currentChar){
                    repeat = true;
                    repeatIndex = j;
                }
            }
            //Если буквы повторяются
            if (repeat){
                //Переопределяем текущую последовательность, начиная ее с места после начала повтора буквы
                currentStrint = currentStrint.substring(repeatIndex + 1) + s.charAt(i);
            }
            //Если буквы не повторяются
            else {
                //Добавляем в текущую последовательность новую букву
                currentStrint += currentChar;
                //Если длина текущей последовательности больше той, что уже есть
                if (currentStrint.length() > answer.length()){
                    //Меняем ответ на новую последовательность
                    answer = currentStrint;
                }
            }
        }
        System.out.println("answer = " + answer);
        System.out.println("lenght = " + answer.length());
        return answer.length();
    }
}

/*
 3.Longest Substring Without Repeating Characters

 Given a string s, find the length of the longest substring without repeating characters.

 Example 1:

 Input: s = "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.
 Example 2:

 Input: s = "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.
 Example 3:

 Input: s = "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


 Constraints:
 0 <= s.length <= 5 * 104
 s consists of English letters, digits, symbols and spaces.
 */