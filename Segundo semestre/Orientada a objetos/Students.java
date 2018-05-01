public class Students implements Comparable<Student>
{
  public int rollno;
  public String name;
  public int age;

  public Students(int rollno,String name, int age)
  {
    this.rollno=rollno;
    this.name=name;
    this.age=age;
  }

@Override
  public int compareTo(Students st)
  {
    if(age==st.age)
    return 0;
    else if(age<st.age)
    return -1;
    else return 1;
  }
}
