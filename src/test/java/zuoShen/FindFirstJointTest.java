package zuoShen;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindFirstJointTest {
    FindFirstJoint.Node head1;
    FindFirstJoint.Node head2;

    @Before
    public void setUp() throws Exception {
        FindFirstJoint.Node node1 = new FindFirstJoint.Node(1, null);
        FindFirstJoint.Node node2 = new FindFirstJoint.Node(2, null);
        FindFirstJoint.Node node3 = new FindFirstJoint.Node(3, null);
        FindFirstJoint.Node node4 = new FindFirstJoint.Node(4, null);
        FindFirstJoint.Node node5 = new FindFirstJoint.Node(5, null);
        FindFirstJoint.Node node6 = new FindFirstJoint.Node(6, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //node5.next = node4;
        node6.next = node4;
        head1 = node1;
        head2 = node6;
    }

    @Test
    public void findFirstJoint() {
        //FindFirstJoint.Node loop1 = FindFirstJoint.findLoop(head1);
        //FindFirstJoint.Node loop2 = FindFirstJoint.findLoop(head2);

        System.out.println(FindFirstJoint.findFirstJoint(head1,head2).value);

        System.out.println();

    }
}