public class StringReplacer  implements StringTransformer {
    private StringDrink drink;
    private char in, out;

    public StringReplacer (StringDrink drink, char in, char out) {
        this.drink = drink;
        this.in = in;
        this.out = out;
    }

    public void execute() {
        drink.setText(drink.getText().replace(in, out));
    }

    public void undo() {
        drink.setText(drink.getText().replace(out, in));
    }
}
