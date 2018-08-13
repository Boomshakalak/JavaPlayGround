import com.playground.DataStructure.LinkedList;
import com.playground.DataStructure.ListNode;

public class Main {

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        System.out.println(l);
        ListNode node = new ListNode(10);
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }
        System.out.println(l.size());
        System.out.println(l);
        l.addFromHead(node);
        System.out.println(l);
        l.add(node);
        System.out.println(l);
    }
}
