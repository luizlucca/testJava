package com.lcl;

/**
 * Classe generica para um nó de arvore binaria. Extende Comparable, ou seja a classe a ser inserida na tipagem tem que 
 * necessariamente implementar o metodo compareTo (simplifica a insercao na esquerda ou direita
 * @author luiz
 *
 * @param <T> Tipo dos dados a serem armazenados
 */
public class Node<T extends Comparable<T>> implements Comparable<T> {

	private Node<T> left;
	private Node<T> right;
	private T value;

	public Node() {

	}

	
	@Override
	public int compareTo(T anotherValue) {
	
		return this.value.compareTo(anotherValue);
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * Remove um nó da arvore com a estrategia de pegar o nó a esquerda de uma sub-arvore
	 * @param value Valor a ser removido
	 * @param parent Noh a partir de onde deve-se iniciar a busca e futura remocao
	 * @return
	 */
	public boolean remove(T value, Node<T> parent) {
		if (value.compareTo(this.value) < 0) {
			if (left != null)
				return left.remove(value, this);
			else
				return false;
		} else if (value.compareTo(this.value) > 0) {
			if (right != null)
				return right.remove(value, this);
			else
				return false;
		} else {
			if (left != null && right != null) {
				this.value = right.minValue();
				right.remove(this.value, this);
			} else if (parent.left == this) {
				parent.left = (left != null) ? left : right;
			} else if (parent.right == this) {
				parent.right = (left != null) ? left : right;
			}
			return true;
		}
	}

	/**
	 * @return O menor valor (noh esquerdo extremo)
	 */
	public T minValue() {
		if (left == null)
			return value;
		else
			return left.minValue();
	}
	
}