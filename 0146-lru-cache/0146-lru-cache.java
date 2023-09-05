class LRUCache {
    Map<Integer,Node> mp = new HashMap<>();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int cap ;
    class Node 
    {
        Node prev,next;
        int key,val;
        Node(int key,int val)
        {
            this.key = key;
            this.val = val;
        }
    }
    
    private void insert(Node node)
    {
        mp.put(node.key,node);
        Node headNext = head.next;
        head.next=node;
        node.next=headNext;
        node.prev=head;
        headNext.prev=node;
        
    }
    
    private void remove(Node node)
    {
        mp.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public LRUCache(int capacity) {
        this.cap = capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        
        if(mp.containsKey(key))
        {
            Node node = mp.get(key);
            remove(node);
            insert(node);//make it the most frequent
            return node.val;
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        
        if(mp.containsKey(key))
        {
            remove(mp.get(key));
        }
        
        if(mp.size()==cap)
        {
            remove(tail.prev);
        }
        
        insert(new Node(key,value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */