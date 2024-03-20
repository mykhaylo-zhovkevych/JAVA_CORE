package chapters.nonSpecified;

public class MyString01 {
    private final char[] value;

    public MyString01(String str) {
        this.value = str.toCharArray();
    }

    public int length() {
        return value.length;
    }

    public char charAt(int index) {
        if (index < 0 || index >= value.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return value[index];
    }

    public MyString01 substring(int beginIndex, int endIndex) {
        if (beginIndex < 0 || endIndex > value.length || beginIndex > endIndex) {
            throw new IndexOutOfBoundsException("Invalid substring indices");
        }

        char[] subArray = new char[endIndex - beginIndex];
        System.arraycopy(value, beginIndex, subArray, 0, endIndex - beginIndex);

        return new MyString01(new String(subArray));
    }

    @Override
    public String toString() {
        return new String(value);
    }

    public static void main(String[] args) {
        MyString01 myString1 = new MyString01("Hello");

        // Test retained methods
        System.out.println("Length: " + myString1.length());
        System.out.println("Char at index 2: " + myString1.charAt(2));
        System.out.println("Substring(1, 4): " + myString1.substring(1, 4));
        System.out.println("ToString: " + myString1.toString());
    }
}




