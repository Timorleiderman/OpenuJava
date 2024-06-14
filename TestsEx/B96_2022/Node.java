package TestsEx.B96_2022;

public class Node {
    public int _number;
    public Node _leftSon, _rightSon;


    public Node (int number)  {
        _number = number;
        _leftSon = null;
        _rightSon = null;
    }


    public int getNumber() {
        return _number;
    }


    public Node getLeftSon() {
        return _leftSon;
    }


    public Node getRightSon() {
        return _rightSon;
    }

    public void setNumber(int number) {
        _number = number;
    }


    public void setLeftSon(Node node) {
        _leftSon = node;
    }


    public void setRightSon(Node node) {
        _rightSon = node;
    }


}