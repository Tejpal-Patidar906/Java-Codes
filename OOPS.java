public class OOPS {
    public static void main(String[] args){
        
    }
}

class Animal{
    void eat(){
         System.out.println("Eat");
    }
    void breath(){
        System.out.println("Breath");
    }
}

class Fish extends Animal{
     void swim(){
        System.out.println("Swim");
     }
}
class shark extends Fish{
    void carnivour(){
        System.out.println("Carnivour");
    }
}

class Mammals extends Animal{
    void walk(){
        System.out.println("Walk");
    }
}

class Dog extends Mammals{
     void bark(){
        System.err.println("Barks");
     }
}



class Student{
    String name;
    int roll;
    String password;
    int marks[];

    // Student(Student s1){   //shalow copy constructor
    //     marks = new int[3];
    //     this.name = s1.name;
    //     this.roll = s1.roll;
    //     this.marks = s1.marks;
    // }

    Student(Student s1){   //deep copy constructor
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;
        for(int i=0; i<marks.length; i++){
            marks[i] = s1.marks[i];
        }
    }

    Student(String name , int roll){
         marks = new int[3];
         this.name = name;
         this.roll = roll;
    }

    Student(){
        marks = new int[3];
        System.out.println("called");
    }
}


class Pen{
    private int tip;
    private String color;
    public void setTip(int tip){
        this.tip = tip;
    }
    public void setColor(String newColor){
        this.color = newColor;
    }

    public String getColor(){
        return this.color;
    }

    public int getTip(){
        return this.tip;
    }
}