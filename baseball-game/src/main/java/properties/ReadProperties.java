package properties;

import java.io.*;
import java.util.*;

public class ReadProperties {
    public static void main(String[] args) throws IOException {

        // Properties 파일 경로 (C 드라이브의 경우 예: "C:\\example.properties")
        String filePath = "C:\\dev\\test.properties";

        // Properties 객체 생성
        Properties properties = new Properties();
        File file = new File(filePath);
        FileInputStream fileInputStream = null;

        try {
            // 파일에서 프로퍼티 읽기
            fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);

            // 프로퍼티 열거형 얻기
            Set<String> setStringPropertyNames = properties.stringPropertyNames();
            Iterator<String> it = setStringPropertyNames.iterator();

            // 각 프로퍼티를 순회하면서 처리
            while (it.hasNext()) {
                String key = it.next();
                String value = properties.getProperty(key);
                if (value != null && !value.isEmpty()) {
                    System.out.println(key + " : " + value);
                } else {
                    System.out.println(key);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
        }
    }
}
