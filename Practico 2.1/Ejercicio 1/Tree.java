import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream.LongMapMultiConsumer;

public class Tree {

    private int value;
    private Tree left;
    private Tree right;

    public Tree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getRoot() {
        return value;
    }

    public void add(int newValue) {
        if (newValue < this.value) {
            if (this.left == null)
                this.left = new Tree(newValue);
            else
                this.left.add(newValue);
        } else if (newValue > this.value) {
            if (this.right == null)
                this.right = new Tree(newValue);
            else
                this.right.add(newValue);
        }
    }

    public void printPreOrder() {
        System.out.print(this.value + " ");
        if (this.left != null) {
            this.left.printPreOrder();
        } else {
            System.out.print("- ");
        }
        if (this.right != null) {
            this.right.printPreOrder();
        } else {
            System.out.print("- ");
        }
    }

    public void printPosOrder() {
        if (this.left != null) {
            this.left.printPosOrder();
        } else {
            System.out.print("- ");
        }
        if (this.right != null) {
            this.right.printPosOrder();
        } else {
            System.out.print("- ");
        }
        System.out.print(this.value + " ");

    }

    public void printInOrder() {
        if (this.left != null) {
            this.left.printInOrder();
        } else {
            System.out.print("- ");
        }
        System.out.print(this.value + " ");
        if (this.right != null) {
            this.right.printInOrder();
        } else {
            System.out.print("- ");
        }

    }

    public boolean hasElem(Integer elem) {
        if (this == null)
            return false;
        if (this.value == elem)
            return true;
        else if (elem < this.value) {
            if (this.left != null)
                return (this.left.hasElem(elem));
            else
                return false;
        }

        else if (this.right != null)
            return (this.right.hasElem(elem));
        else
            return false;
    }

    public boolean isEmpty() {
        return (this == null);
    }

    public ArrayList<Integer> getFrontera() {
        ArrayList<Integer> frontera = new ArrayList<>();
        getFronteraRecursivo(this, frontera);
        return frontera;
    }

    private void getFronteraRecursivo(Tree nodo, ArrayList<Integer> frontera) {
        if (nodo == null) {
            return;
        }
        if (nodo.left == null && nodo.right == null) {
            frontera.add(nodo.value);
        }
        getFronteraRecursivo(nodo.left, frontera);
        getFronteraRecursivo(nodo.right, frontera);
    }

    public Integer getMaxElem(Tree root) {
        if (root.right == null) {
            return root.value;
        } else {
            return getMaxElem(root.right);
        }
    }

    public int getHeight() {
        return getHeight(this);
    }

    private int getHeight(Tree tree) {
        if (tree == null) {
            return -1;
        }
        return Math.max(getHeight(tree.left), getHeight(tree.right)) + 1;
    }

    public void insert(Integer valor) {
        if (valor < this.value) {
            if (this.left != null) {
                this.left.insert(valor);
            } else
                this.left = new Tree(valor);
        } else {
            if (this.right != null) {
                this.right.insert(valor);
            } else
                this.right = new Tree(valor);
        }
    }

    public ArrayList<Integer> getLongestBranch() {
        ArrayList<Integer> longestBranch = new ArrayList<Integer>();
        ArrayList<Integer> leftBranch = new ArrayList<Integer>();
        ArrayList<Integer> rightBranch = new ArrayList<Integer>();
        longestBranch.add(this.value);
        if (this.isEmpty()) {
            return longestBranch;
        } else {
            if (this.left != null) {
                leftBranch = this.left.getLongestBranch();
            }
            if (this.right != null) {
                rightBranch = this.right.getLongestBranch();
            }
            if (leftBranch.size() >= rightBranch.size())
                longestBranch.addAll(leftBranch);
            else
                longestBranch.addAll(rightBranch);
        }
        return longestBranch;
    }

    public ArrayList<Integer> getElementAtLevel(Integer level) {
        ArrayList<Integer> elements = new ArrayList<Integer>();
        if (this == null)
            return elements;
        else {
            if (level == 0)
                elements.add((this.value));
            if (this.left != null)
                elements.addAll(this.left.getElementAtLevel(level - 1));
            if (this.right != null)
                elements.addAll(this.right.getElementAtLevel(level - 1));
        }
        return elements;
    }

    public boolean isLeaf() {
        return (this.left == null && this.right == null);
    }

    public boolean delete(Integer value) {
        // si es hoja y no lo encontró
        if (this.isLeaf() && this.value != value)
            return false;
        // si estoy parado en el nodo a borrar:
        if (this.value == value) {
            // primero pregunto si es hoja:
            if (this.isLeaf()) {
                this.value = -1;
                return true;

                // veo si tiene un hijo:
            } else if (this.left == null && this.right != null) {
                Integer aux = this.right.value;
                this.value = aux;
                this.right = null;
                return true;

            } else if (this.left != null && this.right == null) {
                Integer aux = this.left.value;
                this.value = aux;
                this.left = null;
                return true;

            }
            // si llego acá es porque tiene dos hijos:
            else {
                Integer aux = getMaxElem(this.left);
                this.value = aux;
                this.left.delete(aux);
                return true;
            }

        } else {
            if (value > this.value) {
                this.right.delete(value);
            } else
                this.left.delete(value);
            return false;
        }
    }

}
