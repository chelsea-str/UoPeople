package Unit3;

class Student {
    private int ID;
    private String name;
    private int age;
    private int grade;

    Student(int ID, String name, int age, int grade) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = Integer.parseInt(String.valueOf(ID));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
