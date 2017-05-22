//第二题是 给定一个array A[], length of A[], two values(n1 和n2), first, to compute a BST, 
//then compute the distance between these two nodes in the BST.
//解题思路：这道题，包含了很多子问题，1）如何将unsorted array 变成Binary Search Tree; 
//先排序，然后找中点，变为root,然后用递归写root.left 和root.right. 
//2)在一颗BST中求两个节点的lowest common ancestor. 
//3) 然后计算每个节点到root的距离，也用递归。
//4）主函数，求BST, 求LCA, 求pathLen，最后是n1_pathlen + n2_pathlen - 2*lca_pathlen.
//大家参考下这个代码：http://algorithms.tutorialhorizon.com/find-the-distance-between-two-nodes-of-a-binary-tree/。
