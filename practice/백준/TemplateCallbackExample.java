package practice.백준;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TemplateCallbackExample {

    public static void main(String[] args) throws IOException {
        BufferedReaderCallback bufferedReaderCallback = getBufferedReaderCallback();
        String result = fileProcess("test.txt", bufferedReaderCallback);

        System.out.println(result);
    }

    private static BufferedReaderCallback getBufferedReaderCallback() {
        return (BufferedReader br) -> {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        };
    }

    public static String fileProcess(String filePath, BufferedReaderCallback callback) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // 템플릿 역할을 하는 부분: 파일 열기와 닫기
            // 콜백을 통해 파일 내용 처리
            return callback.doSomethingWithReader(br);
        }
    }

    @FunctionalInterface
    public interface BufferedReaderCallback {
        String doSomethingWithReader(BufferedReader br) throws IOException;
    }
}

