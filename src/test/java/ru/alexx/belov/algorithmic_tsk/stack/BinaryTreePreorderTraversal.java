package ru.alexx.belov.algorithmic_tsk.stack;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
  https://leetcode.com/problems/binary-tree-preorder-traversal/

  # Binary tree # DFS # Deep First search
 */
@QuarkusTest
class BinaryTreePreorderTraversal {


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
     *  Runtime: 1 ms, faster than 44.92% of Java online submissions for Binary Tree Preorder Traversal.
     * Memory Usage: 41.8 MB, less than 41.87% of Java online submissions for Binary Tree Preorder Traversal.
     */
    public List<Integer> myStackMethod(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node = root;
        while (node != null) {
            res.add(node.val);
            if (node.right != null) {
                deque.push(node.right);
            }
            node = node.left;
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