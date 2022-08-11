package ru.alexx.belov.algorithmic_tsk.stack;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
  https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
@QuarkusTest
class BinaryTreePostorderTraversal {


    @Test
    void process() {

        TreeNode tn = new TreeNode();
        tn.val = 1;
        tn.left = new TreeNode(2, null, new TreeNode(4, null, null));
        tn.right = new TreeNode(3, new TreeNode(5, null, null), new TreeNode(6, null, null));
        System.out.println(myStackMethod(tn));

    }

    /**
     *  Алгоритм - ноды справа кладем в стек на хранение, ноды слева используем пока есть. Нету - берем из стека.
     *
     Runtime: 1 ms, faster than 44.58% of Java online submissions for Binary Tree Postorder Traversal.
     Memory Usage: 42.3 MB, less than 24.13% of Java online submissions for Binary Tree Postorder Traversal.
     */
    public List<Integer> myStackMethod(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node = root;
        while (node != null) {
            res.add(0, node.val);
            if (node.left != null) {
                deque.push(node.left);
            }
            node = node.right;
            if (node == null && !deque.isEmpty()) {
                node = deque.pop();
            }
        }

        return res;

    }
    
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


}