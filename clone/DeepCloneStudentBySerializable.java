package clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//这样做的前提是对象以及对象内部所有引用到的对象都是可串行化的，否则，就需要仔细考察那些不可串行化的对象可否设成transient，从而将之排除在复制过程之外。
class SerializableProfessor implements Serializable{
    String name;
    int age;
    SerializableProfessor(String name,int age){
        this.name=name;
        this.age=age;
    }
}

public class DeepCloneStudentBySerializable implements Serializable{
    String name;
    int age;
    SerializableProfessor p;
    DeepCloneStudentBySerializable(String name,int age,SerializableProfessor p){
        this.name=name;
        this.age=age;
        this.p=p;
    }
    public Object deepClone() throws IOException,ClassNotFoundException{
        //将对象写到流里
        ByteArrayOutputStream bo=new ByteArrayOutputStream();
        ObjectOutputStream oo=new ObjectOutputStream(bo);
        oo.writeObject(this);// object of DeepCloneStudentBySerializable
        //从流里读出来
        ByteArrayInputStream bi=new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi=new ObjectInputStream(bi);
        return(oi.readObject());
    }
    public static void main(String[] args){
        SerializableProfessor p=new SerializableProfessor("wangwu",50);
        DeepCloneStudentBySerializable s1=new DeepCloneStudentBySerializable("zhangsan",18,p);
        try {
            DeepCloneStudentBySerializable s2=(DeepCloneStudentBySerializable)s1.deepClone();
            s2.p.name="lisi";
            s2.p.age=30;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //学生1的教授不改变
        System.out.println("name="+s1.p.name+","+"age="+s1.p.age); 
    }
}