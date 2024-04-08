class Solution {
    public int solution(String my_string, String is_prefix) {
        int a = 2+3;
double b = 2+(double)3;
String c = ""+2+3;

        System.out.printf("a : %d\nb : %f\nc : %s", a, b, c);
        
        my_string = my_string.replace(is_prefix, "1");
        return my_string.charAt(0)!='1' ? 0 : 1;
        
        // 한 줄로 작성 시
        // return my_string.replace(is_prefix, "1").charAt(0)!='1' ? 0 : 1;
    }
}