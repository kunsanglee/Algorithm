package practice.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int chance = 10;
    static Map<Character, Character> map = new HashMap<>();
    static int distance;

    public static void main(String[] args) throws IOException {
        decodeProgram();
    }

    private static void decodeProgram() throws IOException {
        setDictionary();
        StringBuffer code = getInput();
        StringBuffer translatedCode = decryptCode(code, code.length());
        System.out.println("해독 결과: meet.google.com/" + translatedCode.substring(0,3) + "-" + translatedCode.substring(3, 7) + "-" + translatedCode.substring(7));
    }


    private static StringBuffer decryptCode(StringBuffer code, int length) {
        for (int i = 0; i < length; i++) {
            wordHandle(code, i);
        }
        return code;
    }

    private static void wordCheck(StringBuffer code) {
        try {
            if (code.length() == 0) {
                throw new RuntimeException();
            }
            for (int i = 0; i < code.length(); i++) {
                char word = code.charAt(i);
                if (word < 'a' || 'z' < word) {
                    Character translate = map.get(word);
                    code.setCharAt(i, translate);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private static void wordHandle(StringBuffer code, int i) {
        char target = code.charAt(i);
        int adjustDistance = distance % 26;
        if (target - adjustDistance < 'a') {
            code.setCharAt(i, (char) (target - adjustDistance + 26));
        } else {
            code.setCharAt(i, (char) (target - adjustDistance));
        }
    }

    private static void setDictionary() {
        map.put('ㅁ', 'a');
        map.put('ㅠ', 'b');
        map.put('ㅊ', 'c');
        map.put('ㅇ', 'd');
        map.put('ㄷ', 'e');
        map.put('ㄹ', 'f');
        map.put('ㅎ', 'g');
        map.put('ㅗ', 'h');
        map.put('ㅑ', 'i');
        map.put('ㅓ', 'j');
        map.put('ㅏ', 'k');
        map.put('ㅣ', 'l');
        map.put('ㅡ', 'm');
        map.put('ㅜ', 'n');
        map.put('ㅐ', 'o');
        map.put('ㅔ', 'p');
        map.put('ㅂ', 'q');
        map.put('ㄱ', 'r');
        map.put('ㄴ', 's');
        map.put('ㅅ', 't');
        map.put('ㅕ', 'u');
        map.put('ㅍ', 'v');
        map.put('ㅈ', 'w');
        map.put('ㅌ', 'x');
        map.put('ㅛ', 'y');
        map.put('ㅋ', 'z');
    }

    private static StringBuffer getInput() throws IOException {
        StringBuffer code = new StringBuffer();
        while(chance > 0) {
            try {
                System.out.println("남은 기회: " + chance);
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("암호문을 입력하세요: ");
                code = new StringBuffer(br.readLine());
                wordCheck(code);
                System.out.print("암호화에 사용된 거리를 입력하세요: ");
                distance = Integer.parseInt(br.readLine());
                return code;
            } catch (Exception e) {
                if (e.getClass().isNestmateOf(NumberFormatException.class)) {
                    System.out.println("암호화에 사용되는 거리 입력은 숫자만 입력 가능합니다. ex) 123");
                } else {
                    System.out.println("잘못된 암호문 입력입니다. 암호문은 알파벳 소문자와 한글 자음으로만 이루어져야 합니다. ex) acㄱbㄴㄷd");
                }
                System.out.println();
                chance--;
            }
        }
        if (chance > 0) {
            return code;
        }
        System.out.println("프로그램을 종료합니다");
        System.exit(400);
        return null;
    }
}
