package day7.dmcme.mscgraduation;

import java.io.*;
import java.util.ArrayList;

public class MScSoftwareEngineering {

    public static void main(String[] args) {

        try {
            File file = new File("src\\main\\java\\day7\\dmcme\\mscgraduation\\ModuleScoresMSc.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            File outputFile = new File("src\\main\\java\\day7\\dmcme\\mscgraduation\\ListForGraduation.txt");
            FileWriter fileWriter = new FileWriter(outputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            ArrayList<Student> listOfStudents = new ArrayList<>();

            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            while (line != null) {
                String [] splitStudentArray = line.split(",");
                listOfStudents.add(addNewStudent(splitStudentArray));

                line = bufferedReader.readLine();
            }

            for (Student student: listOfStudents) {
                printStudentResults(student);
            }

            for (Student student: listOfStudents) {
                printAbbreviatedResults(student);
            }

            for (Student student: listOfStudents) {
                if(student.getStudentAverage() >= 40 && student.getStudentAverage() <= 100) {
                    String outputLine = student.getStudentID() + "," + student.getFirstName() + "," +
                            student.getLastName() + "," + student.setResultClassification();
                    bufferedWriter.write(outputLine);
                    bufferedWriter.newLine();
                }
            }


            bufferedWriter.close();
            fileWriter.close();

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Student addNewStudent(String [] studentArray) {
        String firstName = studentArray[1];
        String lastName = studentArray[2];
        String studentID = studentArray[0];

        Student newStudent = new Student(firstName, lastName, studentID);
        newStudent.addModule(new Module("Programming          ", Double.parseDouble(studentArray[3])));
        newStudent.addModule(new Module("Computer Foundations ", Double.parseDouble(studentArray[4])));
        newStudent.addModule(new Module("Database             ", Double.parseDouble(studentArray[5])));
        newStudent.addModule(new Module("Web Development      ", Double.parseDouble(studentArray[6])));
        newStudent.addModule(new Module("Software Engineering ", Double.parseDouble(studentArray[7])));

        newStudent.setResultClassification();

        return  newStudent;
    }

    public static void printStudentResults(Student student) {
        System.out.println("Student No: \t\t\t" + student.getStudentID());
        System.out.println("First Name: \t\t\t" + student.getFirstName());
        System.out.println("Last Name: \t\t\t\t" + student.getLastName());
        System.out.println("Module Results");
        for (Module module: student.getListOfModules()) {
            System.out.println(student.getModule(module.getModuleName()).getModuleName() + ": \t" +
                    student.getModule(module.getModuleName()).getResult());
        }
        System.out.println("-------------------------------------------");
        System.out.println("Classification: \t\t" + student.setResultClassification());
        System.out.println();
    }

    public static void printAbbreviatedResults(Student student) {
        System.out.println("Student No: \t\t\t" + student.getStudentID());
        System.out.println("First Name: \t\t\t" + student.getFirstName());
        System.out.println("Last Name: \t\t\t\t" + student.getLastName());
        System.out.println("Average  : \t\t\t\t" + student.getStudentAverage());
        System.out.println("Classification: \t\t" + student.setResultClassification());
    }



}
