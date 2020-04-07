public class StringInverter implements StringTransformer {
    private StringDrink drink;

    public StringInverter (StringDrink drink) {
        this.drink = drink;
    }

    public void execute() {
        StringBuffer buffer = new StringBuffer(drink.getText());
        buffer.reverse();
        drink.setText(buffer.toString());
    }

    public void undo() {
        execute();
    }
}
