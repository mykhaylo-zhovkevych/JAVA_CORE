package telusko.objectJavaClass;

class laptop {

    int price;
    String brand;
    
   
//    public String toString() { 
//        return brand + " : " + price;

//    }



@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + price;
    result = prime * result + ((brand == null) ? 0 : brand.hashCode());
    return result;
}


@Override
public String toString() {
    return "laptop [price=" + price + ", brand=" + brand + "]";
}


@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    laptop other = (laptop) obj;
    if (price != other.price)
        return false;
    if (brand == null) {
        if (other.brand != null)
            return false;
    } else if (!brand.equals(other.brand))
        return false;
    return true;
}

}

public class ObjectClass {
    public static void main(String[] args) {
        
        laptop obj = new laptop();
        obj.price = 2;
        obj.brand = "samsung";

        System.out.print(obj.toString());
        // every time i try to print the opbejt behind the sce it will call the toString method

    }
}
