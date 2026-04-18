package bai1.code.ham3.code;

public class ContentAnalyzer {
    public static void contentAnalysis(String content){
        StringBuffer sb = new StringBuffer(content);

        int sentence = 0;
        for (int i = 0; i < sb.length(); i++){
            char c = sb.charAt(i);
            if (c == '.' || c == '?' || c == '!'){
                sentence++;
            }
        }

        System.out.println("So cau trong doan van ban la: " + sentence);

        String target = "Java";
        String replacement = "Python";
        int index = sb.indexOf(target);

        System.out.println("Doan van truoc khi da thay the 'Java' bang 'Python': ");
        System.out.println(sb.toString());

        while (index != -1) {
            sb.replace(index, index + target.length(), replacement);

            index = sb.indexOf(target, index + target.length());
        }

        System.out.println("Doan van sau khi da thay the 'Java' bang 'Python': ");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        String text = "Học Java rất thú vị! Bạn đã biết Java chưa? Java là ngôn ngữ phổ biến.";
        contentAnalysis(text);
    }
}
