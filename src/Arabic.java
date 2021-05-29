public class Arabic extends Number {

    private int num1;
    private int num2 ;
    private int result;

    Arabic(int value1, int value2) {
        this.num1 = value1;
        this.num2 = value2;
    }

    public void sum() {
        this.result = num1 +num2;
    }

    public void sub() {
        this.result = num1 - num2;
    }

    public void div() {
        try{
            this.result = num1 /num2 ;
        } catch (ArithmeticException e) {
            System.out.print("ArithmeticException/by zero ");
            return;
        }

    }

    public void multi() {
        this.result = num1 *num2 ;
    }

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public String getStringResult() {
        return "" + result;
    }


}