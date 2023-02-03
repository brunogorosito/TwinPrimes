package unrn.edu.ar.model;

public class TwinPrime implements Comparable<TwinPrime>{

    int id;
    int firstNumber;
    int secondNumber;

    public TwinPrime(int id, int firstNumber, int secondNumber) {
        this.id = id;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    @Override
    public int compareTo(TwinPrime o) {
        return (int)(this.id - o.getId());
    }

    @Override
    public String toString() {
        return ("(" + this.firstNumber + ", " + this.secondNumber + ")" );
    }
}

