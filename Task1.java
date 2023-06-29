//Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий)
//во вновь созданную папку
//        ./backup

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
public class Task1 {

    private String setWorkingPath = "E:\\IT\\GeekBrains\\дз\\1 курс JAVA core\\Seminar 1\\untitled1";
    public static void main(String[] args) throws IOException {

        Task1 task1 = new Task1();
        ArrayList listObjects = task1.readDir();
        ArrayList onlyFilesList = task1.sortOnlyFiles(listObjects);
        task1.createBackup(onlyFilesList);
    }

    private ArrayList readDir() throws IOException {

        ArrayList my_list = new ArrayList<>();
        Path path = Path.of(setWorkingPath);
        DirectoryStream<Path> listObjects = Files.newDirectoryStream(path);
        for (Path item : listObjects) {
            my_list.add(item);
        }
        return my_list;
    }

    private ArrayList sortOnlyFiles(ArrayList listObjects){

        ArrayList onlyFilesList = new ArrayList<>();

        for (int i = 0; i < listObjects.size(); i++) {
            String item = listObjects.get(i).toString();
            File file = new File(item);
            if (file.isFile()){
                onlyFilesList.add(item);
            }
        }
        return onlyFilesList;
    }

    private void createBackup(ArrayList onlyFilesList) throws IOException {

        try {
            Files.createDirectory(Path.of(setWorkingPath + "\\backup"));
        } catch (IOException e) {
//            throw new RuntimeException(e);
            System.out.println("каталог не создан, уже существует");
        }
        for (int i = 0; i < onlyFilesList.size(); i++) {
            String sourcePath = onlyFilesList.get(i).toString();
            String[] fileName = sourcePath.replace("\\", "/").split("/");
            String destinationPath = setWorkingPath + "\\backup\\" + fileName[fileName.length - 1].toString();
            Path path1 = Path.of(sourcePath);
            Path path2 = Path.of(destinationPath);
            Files.copy(path1, path2);
        }

    }
}
