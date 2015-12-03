package dto;
public class People
{
        private int age;
        private  String name;

        public People(String name, int age)
        {
                this.age = age;
                this.name = name;
        }

        public void show()
        {
                System.out.println(getName()+":"+getAge());
                
        }

        public int getAge()
        {
                return age;
        }

        public String getName()
        {
                return name;
        }

        public void setAge(int age)
        {
                this.age = age;
        }


        public void setName(String name)
        {
                this.name = name;
        }

}

 

