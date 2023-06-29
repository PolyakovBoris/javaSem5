//// создать два текстовых файла по 50-100
//
//import java.io.*;
//import java.nio.charset.StandardCharsets;
//
//public class Practice {
//    private boolean createNewFile(String fileName){
//        File file = new File(fileName);
//
//        if (file.exists() == false){
//            try {
//                file.createNewFile();
//                System.out.println("файл создан");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//            return true;
//        } else {
//            System.out.println("файл не создан");
//            return false;
//        }
//    }
//
//    private boolean writeToFile(String fileName) throws IOException {
//
//        StringBuilder my_string = new StringBuilder();
//        for (int i = 0; i < 100; i++) {
//            int nextSymbol = (int) (Math.random()*((90-65)+1))+65;
//            my_string.append((char) nextSymbol);
//            my_string.append(" ");
//            System.out.print(nextSymbol);
//        }
//        System.out.println("\n" + my_string);
//        System.out.println();
//        try {
//            FileWriter fileToWrite = new FileWriter(fileName);
//            fileToWrite.write(String.valueOf(my_string));
//            System.out.println("записал");
//            return true;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
//        fileOutputStream.write(my_string.toString().getBytes(StandardCharsets.UTF_8));
//        return true;
//
//    }
//    public static void main(String[] args) throws IOException {
//
//        String fileName = "file.txt";
//        Practice practice = new Practice();
//        System.out.println(practice.createNewFile(fileName));
//        practice.writeToFile(fileName);
//    }
//
//}
