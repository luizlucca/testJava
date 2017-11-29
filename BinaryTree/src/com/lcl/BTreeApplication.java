package com.lcl;

public class BTreeApplication {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//cricao da arvore
		BinaryTree<Integer> bt = new BinaryTree<>(new Integer(8));
		
		//insercao dos nos
		Node<Integer> nTree = bt.insertValue(new Integer(3));
		bt.insertValue(new Integer(10));
		bt.insertValue(new Integer(1));
		bt.insertValue(new Integer(6));
		bt.insertValue(new Integer(14));
		bt.insertValue(new Integer(4));
		bt.insertValue(new Integer(7));
		bt.insertValue(new Integer(13));
//		bt.levelOrder(bt.getRoot());
//		bt.inOrder(bt.getRoot());
//		bt.inOrderIterative(bt.getRoot());
//		bt.remove(6);
//		bt.levelOrder(bt.getRoot());
		
		//impressao da soma
		System.out.println("Soma: "+bt.sumAll(nTree));
		
	}

}
