package shorts.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptimalPathInTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static Optional<List<Integer>> findOptimalPath(TreeNode root) {
        if (root == null) {
            return Optional.empty();
        }
        Optional<List<Integer>> leftPath = findOptimalPath(root.left);
        Optional<List<Integer>> rightPath = findOptimalPath(root.right);
        List<Integer> optimalPath = new ArrayList<>();
        optimalPath.add(root.val);
        if (!leftPath.isPresent() && !rightPath.isPresent()) {
            return Optional.of(optimalPath);
        }
        List<Integer> longerPath = leftPath.orElse(new ArrayList<>());
        if (rightPath.isPresent() && rightPath.get().size() > longerPath.size()) {
            longerPath = rightPath.get();
        }
        optimalPath.addAll(longerPath);
        return Optional.of(optimalPath);
    }

    public static void main(String[] vvv) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Optional<List<Integer>> optimalPath = findOptimalPath(root);
        optimalPath.ifPresent(path -> System.out.println("Optimal Path: " + path));
    }
}
