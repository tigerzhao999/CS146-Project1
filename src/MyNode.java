public class MyNode {
    public MyNode next;
    private String data;
    public MyNode(String newData){
        this.setData(newData);
        next = null;
    }
    public boolean hasNext(){
        return next != null;
    }

    public void setData(String newData){
        data = newData;
    }
    public String getData(){
        return data;
    }
}
