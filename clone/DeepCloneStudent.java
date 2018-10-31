package clone;

//DeepCloneProfessor实现Cloneable接口，并重写了clone方法
class DeepCloneProfessor implements Cloneable{
    String name;
    int age;
    DeepCloneProfessor(String name,int age){
        this.name=name;
        this.age=age;
    }
    @Override
    public Object clone(){
        Object o=null;
        try{
            o=super.clone();
        }catch(CloneNotSupportedException e){
            System.out.println(e.toString());
        }
        return o;
    }
}


//DeepCloneStudent实现了Cloneable接口
public class DeepCloneStudent implements Cloneable{
    String name;
    int age;
    DeepCloneProfessor p;
    DeepCloneStudent(String name,int age, DeepCloneProfessor p){
        this.name=name;
        this.age=age;
        this.p=p;
    }
    public Object clone(){
        DeepCloneStudent o=null;
        try{
            //Object中的clone()识别出你要复制的是哪一个对象
        	o=(DeepCloneStudent)super.clone();
        }catch(CloneNotSupportedException e){
            System.out.println(e.toString());
        }
        //调用Professor类的clone()方法实现深拷贝
        o.p=(DeepCloneProfessor)this.p.clone();
        return o;
    }
    public static void main(String[] args){
        DeepCloneProfessor p=new DeepCloneProfessor("wangwu",50);
        DeepCloneStudent s1=new DeepCloneStudent("zhangsan",18,p);
        DeepCloneStudent s2=(DeepCloneStudent)s1.clone();
        s2.name="lisi";
        s2.age=30;
        //学生1的教授不改变
        System.out.println("name="+s1.p.name+","+"age="+s1.p.age);
    }

}