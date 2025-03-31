package a0331.hak1;

public class Compare1 {
    public static void main(String[] args) {

        String str1 = "apple";
        String str2 = "banana";
        String str3 = "apple";
        System.out.println(str1.compareTo(str2));
        // 'a' 아스키코드(97) b(98) // 음수 (-1)
        System.out.println(str1.compareTo(str3));
        // 두문자열이 같으면 0
        System.out.println(str2.compareTo(str1));
        // 양수 b(98) a(97) 양수
    }
    // -1 'apple'이 'banana'보다 사전순으로 앞섭니다.
    // 0 'apple'과 'apple'은 같아서 0을 반환합니다.
    // 1 'banana'가 'apple'보다 사전순으로 뒤에 있습니다.
}
