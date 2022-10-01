public class Set {
    private MyNode head;

    /**
     * a) Add a new item to the set. If the item is already in the set then nothing happens.
     * Adds new node with provided data
     * @param data Data of the new node added to the set.
     */
    public void add(String data){
        MyNode newNode = new MyNode(data);
        if(head == null){
            head = newNode;
        }
        else if (!this.exists(data)){
            newNode.next = head;
            this.head = newNode;

        }
    }

    /**
     * prints the contents of the set to console
     */
    public void show(){
        MyNode tempNode = head;
        if(head == null){
            System.out.println("there aare no items");
            return;
        }
        while(tempNode.next != null){
            System.out.println(tempNode.getData());
            tempNode = tempNode.next;
        }
        if(tempNode.next == null && tempNode.getData() != null){
            System.out.println(tempNode.getData());
        }
    }

    /**
     * d) Determine if an item is a member of the set.
     * returns true if Set contains a node with data matching input String
     * @param s Input String to be searched for
     * @return True if the set contains node matching s. False if no nodes contain data matching s.
     */
    public boolean exists(String s){
        MyNode tempNode = head;
        if(tempNode == null){
            return false;
        }
        else{
            while(tempNode.next != null){
                if(tempNode.getData().equals(s)){
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        if(tempNode.next == null && tempNode.getData() != null){
            return tempNode.getData().equals(s);
        }
        return false;
    }

    /**
     * d) Determine if an item is a member of the set.
     * returns true if Set contains a node with data matching input String
     * @param s Input String to be searched for
     * @return True if the set contains node matching s. False if no nodes contain data matching s.
     */
    public MyNode search(String s){
        MyNode tempNode = head;
        if(tempNode == null){
            return null;
        }
        else{
            while(tempNode.next != null){
                if(tempNode.getData().equals(s)){
                    return tempNode;
                }
                tempNode = tempNode.next;
            }
        }
        if(tempNode.next == null && tempNode.getData().equals(s)){
            return tempNode;
        }
        return null;
    }

    /**
     * b) Remove an item from the set.
     * @param s Item to be removed from the test
     */
    public void remove(String s){
        if(exists(s)){
            if(head.getData().equals(s)){
                head = head.next;
            }
            else{
                MyNode previous = head;
                MyNode current = head.next;
                while(current != null){
                    if(current.getData().equals(s)){
                        previous.next = current.next;
                        return;
                    }
                    previous = current;
                    current = current.next;
                }
            }
        }
    }

    /**
     * c) return the items in a set
     * Counts the elements in the set
     * @return int with the elements in the set
     */
    public int count(){
        int rtval = 1;
        if(head == null ){
            return 0;
        }
        else{
            MyNode tempNode = head.next;
            while(tempNode != null){
                rtval++;
                tempNode = tempNode.next;
            }
        }
        return rtval;
    }

    /**
     * f) Determine the union of two sets
     * @param s Set to be unionized with this
     * @return The set contaning the union of this and set s
     */
    public Set union(Set s){
        Set rtSet = new Set();
        MyNode tempNode = this.head;
        while(tempNode != null){
            rtSet.add(tempNode.getData());
            tempNode = tempNode.next;
        }
        tempNode = s.head;
        while(tempNode != null){
            rtSet.add(tempNode.getData());
            tempNode = tempNode.next;
        }
        return rtSet;
    }

    /**
     * f) Determine the intersection of two sets
     * @param s The set to be intersected with this
     * @return A set containing the intersection of this and set s
     */
    public Set intersect(Set s){
        Set rtSet = new Set();
        MyNode tempNode = this.head;
        while(tempNode != null){
            if(s.exists(tempNode.getData())){
                rtSet.add(tempNode.getData());
            }
            tempNode = tempNode.next;
        }
        return rtSet;
    }


}
