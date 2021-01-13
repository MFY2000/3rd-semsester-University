package Lab_Exam.Search;

import java.util.Arrays;

public class Binary {
    private int[] array_Search;
    private int key;
    private int lenght;
    private int count;
    private boolean flag;
    private int LP, RP, hit;


    public Binary(int[] array_Search, int key){
        this.setArray_Search(array_Search);
        this.setKey(key);
        this.setLenght();
        this.setFlag(true);
        LP = hit = 0;
        RP = getLenght();

    }

    public int[] getArray_Search() { return array_Search; }
    public String getArray(){return Arrays.toString(getArray_Search());}
    public int getArray_index(int index) { return array_Search[index]; }
    public int getKey() { return key; }
    public int getLenght() { return lenght; }
    public boolean isFlag() { return flag; }

    public int setMid(int LP,int RP) { return (LP+RP)/2; }
    public void setArray_Search(int[] array_Search) {
        Arrays.sort(array_Search);
        this.array_Search = array_Search;
    }
    public void setKey(int key) { this.key = key; }
    public void setLenght() { this.lenght = (getArray_Search()).length; }
    public void setFlag(boolean flag) { this.flag = flag; }
    public void setCount(int count) { this.count = count; }

    private void Search(){
        while (LP<=RP){
            int mid = setMid(LP,RP);
            if(getKey() == getArray_index(mid)){
                setFlag(true);
                return;
            }
            else if(getArray_index(mid) < getKey() ){
                LP = mid+1;
            }
            else if(getArray_index(mid) > getKey() ){
                RP = mid-1;
            }
            hit++;
        }
    }

    public String toString(){
        Search();
        return getArray()+" to Search: "+getKey()+(isFlag()?" ":"not ")+"Found  in the hit: "+hit;
    }
}
