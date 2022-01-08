package day7.dmcme.mscgraduation;

public class Module {

    private String moduleName;
    private double result;

    public Module(String moduleName, double result){
        this.setModuleName(moduleName);
        this.setResult(result);
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        if (result > 100) {
            this.result = 100;
        }
        else if (result < 0){
            this.result = 0;
        }
        else {
            this.result = result;
        }
    }

    @Override
    public String toString() {
        return "Module{" +
                "moduleName='" + moduleName + '\'' +
                ", result=" + result +
                '}';
    }

    public String returnModuleResults() {
        return this.getModuleName() + ": \t\t" + this.getResult();
    }
}
