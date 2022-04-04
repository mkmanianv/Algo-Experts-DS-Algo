package trees;

public class KthLargestValueInBST {
	static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  static class TreeInfo{

    public int numberofNodesVisited;
    public int latestVisitedNodeValue;

    public TreeInfo(int numberofNodesVisited,int latestVisitedNodeValue){
      this.numberofNodesVisited=numberofNodesVisited;
      this.latestVisitedNodeValue=latestVisitedNodeValue;
    }

  }

  public int findKthLargestValueInBst(BST tree, int k) {
    TreeInfo treeInfo=new TreeInfo(0,-1);
    findKthLargestValueInBst(tree, k, treeInfo);
    return treeInfo.latestVisitedNodeValue;
  }

  void findKthLargestValueInBst(BST tree, int k, TreeInfo treeInfo){
    if(tree==null || treeInfo.numberofNodesVisited >=k){
      return;
    }

    findKthLargestValueInBst(tree.right, k,treeInfo);
    if(treeInfo.numberofNodesVisited<k){
      treeInfo.numberofNodesVisited++;
      treeInfo.latestVisitedNodeValue=tree.value;
      findKthLargestValueInBst(tree.left, k,treeInfo);
    }
    
  }

	public static void main(String[] args){

	}


}
