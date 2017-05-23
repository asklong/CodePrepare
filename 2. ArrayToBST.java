//第二题是 给定一个array A[], length of A[], two values(n1 和n2), first, to compute a BST, 
//then compute the distance between these two nodes in the BST.
//解题思路：这道题，包含了很多子问题，1）如何将unsorted array 变成Binary Search Tree; 
//先排序，然后找中点，变为root,然后用递归写root.left 和root.right. 
//2)在一颗BST中求两个节点的lowest common ancestor. 
//3) 然后计算每个节点到root的距离，也用递归。
//4）主函数，求BST, 求LCA, 求pathLen，最后是n1_pathlen + n2_pathlen - 2*lca_pathlen.
//大家参考下这个代码：http://algorithms.tutorialhorizon.com/find-the-distance-between-two-nodes-of-a-binary-tree/。
//build the BST
	public TreeNode arrayToBST(int[] nums) {
		Arrays.sort(nums);
        return getBST(nums, 0, nums.length-1);
    }
	private TreeNode getBST(int[] nums, int start, int end) {
		if(start>end){
			return null;
		}
		//build the root node
		int midIndex = (end-start)/2 + start;
		TreeNode root = new TreeNode(nums[midIndex]);
		//build the left tree
		root.left = getBST(nums, start, midIndex-1);
		root.right = getBST(nums, midIndex+1, end);
		//build the right tree
		return root;
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
//the distance between 2 nodes = distance from root to node1 + distance from root to node2 - lowest commom anster from root * 2;
	public TreeNode findLCAOfBST(TreeNode root, int n1, int n2){
		if(root==null)return null;
		if(n1>root.val && n2>root.val){
			return findLCAOfBST(root.right, n1, n2);
		}
		if(n1<root.val && n2<root.val){
			return findLCAOfBST(root.left, n1, n2);
		}
		return root;
	}
	//if we find the element, we return the distance, else we return -1
	public int Pathlength(TreeNode root, int n1) {
		if(root==null)return -1;
		if(root.val == n1)return 0;
		int d = 0;
		if(n1<root.val){
			d = Pathlength(root.left, n1);
			if(d<0){
				return -1;
			}
			return 1+d;
		}
		d = Pathlength(root.right, n1);
		if(d<0){
			return -1;
		}
		return 1+d;
	}
	//get result
	int getDistance(TreeNode root, int n1, int n2){
		int d1 = Pathlength(root, n1);
		int d2 = Pathlength(root, n2);
		TreeNode lcn = findLCAOfBST(root, n1, n2);
		int d3 = Pathlength(root, lcn.val);
		return d1+d2-2*d3;
	}
