package day7.dmcme.mscgraduation;

import java.util.ArrayList;

public class Student extends Person {

    private String studentID;
    private String resultClassification;
    private ArrayList <Module> listOfModules = new ArrayList<>();

    /**
     * Constructor - Student extends Person
     * @param firstName - Super from Person
     * @param studentID - Student ID - String
     */
    public Student(String firstName, String lastName, String studentID) {
        super(firstName, lastName);
        this.studentID = studentID;
    }

    /**
     * Return StudentID
     * @return - String
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     *
     * @param studentID
     * @return
     */
    private String setStudentID(String studentID){

        if (studentID.equals("")){
            System.err.println("This is an invalid StudentID " + studentID);
            this.studentID = "";
        }
        else {
            this.studentID = studentID;
        }
        return this.studentID;
    }

    public void addModule(Module module){
        this.listOfModules.add(module);
    }

    public ArrayList<Module> getListOfModules() {
        return listOfModules;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", listOfModules=" + listOfModules.listIterator() +
                '}';
    }

    public Module getModule(String moduleName){

        Module returnModule = null;

        for (Module module: this.listOfModules) {
            if (module.getModuleName().equals(moduleName)){
                returnModule = module;
            }
        }
        return returnModule;
    }

    public double getStudentAverage() {

        double totalResult = 0;

        for (Module module: listOfModules){
            if(module.getModuleName().contains("Programming")) {
                totalResult += (module.getResult() * 2);
            }
            else{
                totalResult += module.getResult();
            }

        }

        return totalResult / listOfModules.size();

    }

    public String setResultClassification() {
        this.resultClassification = "ERROR";

        double totalAverage = getStudentAverage();

        if (totalAverage >= 70) {
            this.resultClassification = "Distinction";
        }
        else if (totalAverage >= 60) {
            this.resultClassification = "Commendation";
        }
        else if (totalAverage >= 50) {
            this.resultClassification = "Pass";
        }
        else if (totalAverage >=0) {
            this.resultClassification = "Fail";
        }
        return this.resultClassification;
    }

    public String getResultClassification() {
        return resultClassification;
    }
}
