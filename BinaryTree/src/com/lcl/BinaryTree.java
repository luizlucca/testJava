package com.lcl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T> > {

	private Node<T> root; //raiz

	/**
	 * Construtor, iniciando a arvore com um valor do tipo T (no raiz)
	 * @param value
	 */
	public BinaryTree(T value) {
		this.root = new Node<>();
		this.root.setValue(value);
	}
	
	
	/**
	 * Insere um valor iterativamente
	 * @param value Valor a ser inserido
	 * @return Noh inserido
	 */
	public Node<T> insertValue(T value){
		
//		System.out.println("rootnode:" + root.getValue());
		
		Node<T> rAux = root;
		Node<T> rAuxFather = root;
		
		Node<T> toInsert = new Node<>();
		toInsert.setValue(value);
		
		while(rAux!=null){
			rAuxFather = rAux;
			if(toInsert.compareTo(rAux.getValue())<=0){
				rAux = rAuxFather.getLeft();
			}else{
				rAux = rAuxFather.getRight();
			}
		}
		
		if(value.compareTo(rAuxFather.getValue())<=0){
//			System.out.println("inserindo left");
			rAuxFather.setLeft(toInsert);
		}else{
//			System.out.println("inserindo rigth");
			rAuxFather.setRight(toInsert);
		}
		
		return toInsert;
	}
	
	
	
	public Node<T> getRoot() {
		return root;
	}


	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
	/**
	 * Percurso em preOrdem iterativo
	 * @param node A partir de onde sera o percurso
	 */
	public void preOrderIterative(Node<T>node){
		if(node==null){
			return;
		}
		Stack<Node<T>> stack = new Stack<>();
		stack.push(node);
		
		while(!stack.isEmpty()){
			Node<T> n = stack.pop();
			vistNode(n);
			
			if(n.getRight()!=null){
				stack.push(n.getRight());
			}
			if(n.getLeft()!=null){
				stack.push(n.getLeft());
			}
		}
		
	}
	


	/**
	 * Percurso em preOrdem recursivo
	 * @param node A partir de onde sera o percurso
	 */
	public void preOrder(Node<T> node) {
        if(node != null){
        	vistNode(node);
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
	
	/**
	 * Percurso emOrdem Iterativo
	 * @param node A partir de onde sera o percurso
	 */
	public void inOrderIterative(Node<T> node) {
		Stack<Node<T>> stack = new Stack<>();

		while (!stack.isEmpty() || node != null) {

			if (node != null) {
				stack.push(node);
				node = node.getLeft();
			}else{
				node = stack.pop();
				vistNode(node);
				node = node.getRight();
			}

		}
		
	}
	
	/**
	 * Percurso emOrdem recursivo
	 * @param node A partir de onde sera o percurso
	 */
	public void inOrder(Node<T> node) {
        if(node != null){
        	inOrder(node.getLeft());
        	vistNode(node);
            inOrder(node.getRight());
        }
    }
	
	/**
	 * Percurso em posOrdem Iterativo
	 * @param node A partir de onde sera o percurso
	 */
	public void postOrderIterative(Node<T> node) {
		Stack<Node<T>> stack = new Stack<>();
		Node<T> lastNodeVisited = null;
		
       while(!stack.isEmpty()|| node!=null){
    	   if(node!=null){
    		   stack.push(node);
    		   node = node.getLeft();
    	   }else{
    		   Node<T> peekNode = stack.peek();
    		   if(peekNode.getRight()!=null && lastNodeVisited!= peekNode.getRight()){
    			   node=peekNode.getRight();
    		   }else{
    			   vistNode(peekNode);
    			   lastNodeVisited = stack.pop();
    		   }
    	   }
       }
    }
	
	
	 /**
	  * Percurso posOrdem recursivo
	  * @param node
	  */
	public void postOrder(Node<T> node) {
        if(node != null){
        	postOrder(node.getLeft());
        	postOrder(node.getRight());
            vistNode(node);
        }
    }
	
	/**
	 * Metodo para somar todos os elemntos a partir de um noh
	 * @param node A partir de onde sera o percurso
	 * @return A soma da sub-arvore (ou arvore no caso de node=root)
	 */
	public Integer sumAll(Node<T> node) {
		if(node==null) {
			return 0;
		}
		return ( (Integer) node.getValue() +sumAll(node.getLeft())+sumAll(node.getRight()));
		
	}
	
	/**
	 * Remocao de valor da arvore
	 * @param value Valor a ser removido
	 * @return True ->removeu; False-> algo de errado nao deu certo ;)
	 */
	 public boolean remove(T value) {
         if (root == null)
               return false;
         else {
               if (root.getValue() == value) {
                     Node<T> auxRoot = new Node<>();
                     auxRoot.setLeft(root);
                     boolean result = root.remove(value, auxRoot);
                     root = auxRoot.getLeft();
                     return result;
               } else {
                     return root.remove(value, null);
               }
         }
   }
	
	 
	 /**
	  * Percurso em nivel-- Breadth-first search 
	  * @param node A partir de onde sera o percurso
	  */
	public void levelOrder(Node<T> node){
		Queue<Node<T>> q = new LinkedList<>();
		q.add(node);
		
		while(!q.isEmpty()){
			node = q.remove();
			vistNode(node);
			if(node.getLeft()!=null){
				q.add(node.getLeft());
			}
			
			if(node.getRight()!=null){
				q.add(node.getRight());
			}
		}
	}
	
	private void vistNode(Node<T> node){
		System.out.print(node.getValue() + " ");
	}
	
	
	
	
}
