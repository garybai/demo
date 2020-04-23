package com.example.structurealgorithmdemo.linkedlist;

/**
 * 链表
 *
 * @author Gary
 * @date 2020/4/19 22:11
 **/
public class LinkedTest {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 整个链表逆序
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        // 定义一个指针指向新链表头
        ListNode newHead = null;
        while (head != null) {
            // 保存当前节点的后继节点
            ListNode next = head.next;
            // 将当前节点的后继指向新链表头
            head.next = newHead;
            // 移动新链表头指针
            newHead = head;
            // 移动原链表头指针，也就是当前要处理的节点
            head = next;
        }
        return newHead;
    }

    /**
     * 逆序链表的第m到第n个位置的元素
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        /**
         * 1->2->3->4->5->
         * 逆序2-4的元素
         * 1->4->3->2->5->
         */
        // 计算逆序部分的长度
        int changeLen = n - m + 1;
        // 记录结果链表的 head 节点
        ListNode result = head;
        // 保存逆序部分的前驱节点，例子也就是节点1
        ListNode changeListBefore = null;
        // 将指针想后移动 m-1 个位置
        int x = m - 1;
        while (x-- > 0) {
            changeListBefore = head;
            head = head.next;
        }
        // 此时 head 就指向逆序段的第一个节点，也就是逆序完成之后逆序段的最后一个节点，这个节点的next要指向逆序段的后继节点
        ListNode changeListLast = head;
        // 下面完成逆序段的操作，和逆序整个链表一样，不过需要计数，逆序 n-m+1 个元素
        ListNode newHead = null;
        while (changeLen-- > 0) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        // 经过逆序之后，此时的head就是逆序段的后继节点
        ListNode changeListAfter = head;
        changeListLast.next = changeListAfter;
        // changeListBefore 不是空，说明不是从第一个节点开始逆序
        if (changeListBefore != null) {
            // 逆序段的前驱指向逆序段的第一个节点
            changeListBefore.next = newHead;
        } else {
            // 这种情况说明是从第一个节点开始逆序，那么新链表的head就是逆序段的head，即newHead
            result = newHead;
        }
        return result;
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    public static ListNode merge1(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode cur = temp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;
        }
        return temp.next;
    }

    public static ListNode deleteDuplicatedNode(ListNode head) {
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    public static ListNode detectCycle(ListNode head) {
        // 快指针
        ListNode fast = head;
        // 慢指针
        ListNode slow = head;
        // 相遇的节点
        ListNode meet = null;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            // 快指针一次走两步，慢指针一次走一步
            fast = fast.next.next;
            slow = slow.next;
            // 相遇之后记录相遇的位置
            if (fast == slow) {
                meet = fast;
                break;
            }
        }
        // 将快指针复原到head
        fast = head;
        while (fast != slow) {
            // 快慢指针每次都走一步，他们相遇的点就是环的起点
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static ListNode swapNodesInpairs(ListNode head) {
        // 定义个假头并指向当前链表头
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 被交换的两个节点的前驱从dummy节点开始
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            // 找到要交换的两个节点
            ListNode l1 = pre.next;
            ListNode l2 = pre.next.next;

            // 开始交换
            l1.next = l2.next;
            l2.next = l1;
            pre.next = l2;

            // 交换完成之后将前驱节点移动到l1
            pre = l1;
        }
        return dummy.next;
    }

    public static void showList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(7);
        ListNode e = new ListNode(9);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        showList(a);

        showList(swapNodesInpairs(a));

        ListNode f = new ListNode(2);
        ListNode g = new ListNode(4);
        ListNode h = new ListNode(6);
        ListNode i = new ListNode(8);
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = null;
        showList(f);

//        ListNode newList = reverseList(a);
//        ListNode newList = reverseBetween(a, 2, 5);
//        showList(newList);

//        showList(merge(a, f));
        showList(merge1(a, f));

        ListNode j = new ListNode(1);
        ListNode k = new ListNode(2);
        ListNode l = new ListNode(2);
        ListNode m = new ListNode(4);
        ListNode n = new ListNode(5);
        j.next = k;
        k.next = l;
        l.next = m;
        m.next = n;
        showList(j);
        showList(deleteDuplicatedNode(j));

        ListNode o = new ListNode(1);
        ListNode p = new ListNode(2);
        ListNode q = new ListNode(3);
        ListNode r = new ListNode(4);
        ListNode s = new ListNode(5);
        ListNode t = new ListNode(6);
        ListNode u = new ListNode(7);
        o.next = p;
        p.next = q;
        q.next = r;
        r.next = s;
        s.next = t;
        t.next = u;
        u.next = q;
//        showList(o);
//        System.out.println(detectCycle(o).val);

    }
}
