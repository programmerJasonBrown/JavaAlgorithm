package searchProblem;

public class Key implements Comparable {
    char key;

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    @Override
    public int compareTo(Object o) {
        Key object = (Key) o;
        return key - object.getKey();
    }

    public Key(char key){
        this.key = key;
    }
}
