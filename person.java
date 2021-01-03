
import java.io.Serializable;


public class person implements Serializable
{
    private String name;
    private int age;
    private String DOB;
    person()
    {
        name="ahsan";
        age=20;
        DOB="hjh";
    }
    person(String a,int b,String c)
    {
        name=a;
        age=b;
        DOB=c;
        
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

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
    
    public void display()
    {
        System.out.println("name is:"+name);
        System.out.println("age is: "+age);
        System.out.println("Date of Birth is: "+DOB);
    }
    
}
