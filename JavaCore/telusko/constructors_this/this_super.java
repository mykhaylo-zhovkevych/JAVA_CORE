package telusko.constructors_this;

class a {

public a() {

    System.out.print("in a ");
}


public a(int n)
{
    System.out.print("in a int ");

    }
}

class b extends a{

    public b() {
        System.out.print("in b");

    }
    // this paratamized will net wokr because this 
    public b(int n)
    {
        super(n);
        System.out.print("in b int");
    }
}
// whenever i get object of calss it will call me constructor of subclass annd superclass both a is super and b is subclass
// every constructor has a method that is called super even if i dont mention it specifically
// the super is placed at the first place and means call the constrcucto of the superclass
// the basic i idee that with placing atributes to the brackets of the super() in constructor and when they extending to another constructor i can manage which constructor shoud be called 
public class this_super {
    
public static void main(String[] args) {
    
    b obj = new b();


    }
}
