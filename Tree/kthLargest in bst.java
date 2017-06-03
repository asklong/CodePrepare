/*Complete the function below
The Node is as follows 
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=null;
		right=null;
	}
}
*/
//travel the tree by right side, root, left side
//for the right tree, you also tavel the right side, root, left side.
// then we will get the element from lagest to the smallest in increase order
//we count each element when we travel
//the first travel is the largest element
class GfG
{
    int c = 0;
    public void kthLargest(Node root,int k)
    {
        if(root==null)return;
        //Your code here
        //find the number of nodes in the right side of the tree
        kthLargest(root.right, k);
        ++c;
        if(c==k){
            System.out.println(root.data);
        }
        kthLargest(root.left, k);
    }
}
