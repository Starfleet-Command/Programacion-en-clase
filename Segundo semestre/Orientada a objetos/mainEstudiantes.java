import java.util.Collections;
import java.util.ArrayList;
public class mainEstudiantes
{
  public static void main(String[] args)
  {
    ArrayList<Student> al =new ArrayList<Student>();
    al.add(new Student(101,"Jose",23));
    al.add(new Student(102,"Neria",17));
    al.add(new Student(102,"Yann",19));


  for(Student st: al)
  {
    System.out.println(st.rollno+""+st.name+""+st.age);
  }

  Collections.sort(al);
}
}
