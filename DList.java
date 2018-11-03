package top.bingoxin.practice;

import sun.plugin2.applet.context.NoopExecutionContext;

interface ILink {
    void add(Object obj);
    boolean remove(Object obj);

    /**
     * 修改指定位置几点内容
     * @param index 指定节点位置
     * @param newData 更新后的节点内容
     * @return 修改前的节点内容
     */
    Object set(int index,Object newData);

    /**
     * 根据指定位置获取节点内容
     * @param index 指定节点
     * @return 节点内容
     */
    Object get(int index);

    /**
     * 判断指定内容在链表中是否存在
     * @param data
     * @return -1表示内容不存在。
     */
    int contains(Object data);
    int size();

    /**
     * 清空链表
     */
    void clear();

    /**
     * 将链表转为数组
     * @return 所有节点内容数组
     */
    Object[] toArray();
    void printLink();
}

class Link implements ILink{
    private Node head;
    private Node last;
    private int size;
    //内部类
    private class Node{
        private Node prev;
        private Node next;
        private Object data;

        public Node(){}
        public Node(Node prev, Node next, Object data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }

   public void add(Object obj){
        Node newNode = new Node(last,null,obj);
       if(null == head){
           head = newNode;

       }else{
           newNode.prev = last;
           last.next = newNode;
       }
       last = newNode;
       this.size++;
   }
    public boolean remove(Object obj)
    {
        Node node = head;
        Node delNode = null;
        //找到要删除的节点
        if(null == head){
            return false;
        }else{
            int count = 0;
            for(;count < size;count++){
                if(node.data == obj){
                    delNode = node;
                    break;
                }
                node = node.next;
            }
        }
        if(null == delNode){
            return false;
        }
        if(delNode == last){
            Node lastNode = last.prev;
            last.prev.next = null;
            last.prev = null;
            last.data = null;
            last = lastNode;
        }else if(delNode == head){
            Node headNode = delNode.next;
            delNode.next.prev = null;
            delNode.next = null;
            delNode.data = null;
            head = headNode;
        }else {
            delNode.prev.next = delNode.next;
            delNode.next.prev = delNode.prev;
            delNode.prev = null;
            delNode.next = null;
            delNode.data = null;
        }
        return true;
    }

    /**
     * 修改指定位置几点内容
     * @param index 指定节点位置
     * @param newData 更新后的节点内容
     * @return 修改前的节点内容
     */
    public Object set(int index,Object newData)
    {
        Node node = head;
        //找到指定下标的结点
        for(int i=0;i < index;++i){
            node=node.next;
        }
        Object obj = node.data;
        node.data = newData;
        return obj;
    }

    /**
     * 根据指定位置获取节点内容
     * @param index 指定节点
     * @return 节点内容
     */
    public Object get(int index){
        if(index > 0 && index < size){
            Object[] data = toArray();
            return data[index];
        }
        return null;
    }

    /**
     * 判断指定内容在链表中是否存在
     * @param data
     * @return -1表示内容不存在。
     */
    public int contains(Object data){
        int i = 0;
        if(null == data){
            for(Node temp = head;temp != null;temp=temp.next){
                if(temp.data == data){
                    return i;
                }
                i++;
            }
        }else{
            for(Node temp = head;temp != null;temp=temp.next){
                if(data.equals(temp.data)){
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public int size(){
        return this.size;
    }

    /**
     * 清空链表
     */
    public void clear(){
        Node node = head;
        Node nextNode = null;
        if(null == head){
            return;
        }else if(head == last){
            head.data = null;
        }else{
            int count = this.size;
            while((--count)>0){
                nextNode = node.next;
                node.data = null;
                node.prev = null;
                node.next = null;
                node = nextNode;
            }
        }

    }

    /**
     * 将链表转为数组
     * @return 所有节点内容数组
     */
    public Object[] toArray()
    {
        Object[] result = new Object[this.size];
        Node node = head;
        for(int i=0;i<this.size;i++){
            result[i]=node.data;
            node=node.next;
        }
        return result;
    }
    public void printLink(){
        Object[] data = this.toArray();
        for(int i=0;i<this.size;++i){
            System.out.println(data[i]);
        }
    }
}

public class DList {
    public static void main(String[] args) {
        ILink link = new Link();
        link.add("head");
        link.add("first");
        //link.add(null);
        //System.out.println(link.size());
        //link.printLink();
        //System.out.println(link.contains("h"));
        //System.out.println();
        System.out.println(link.set(0,"pppp"));
        link.printLink();
        System.out.println(link.remove("o"));

    }
}
