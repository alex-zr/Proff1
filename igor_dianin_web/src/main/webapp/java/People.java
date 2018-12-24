import java.util.Date;

public class People {

        private String name;
        private String lastName;
        private int age;
        private boolean married;
        private Date date;

    public People(String name, String lastName, int age, boolean married) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.married = married;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", married=" + married +
                ", date=" + date +
                '}';
    }
}
