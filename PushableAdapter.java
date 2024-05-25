package test;


public class PushableAdapter implements Pushable {
    private final Moveable moveable;
    public PushableAdapter(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void push(int heading) {
        Moveable.Direction direction;
        if (heading >= 45 && heading <= 134) {
            direction = Moveable.Direction.right;
        } else if (heading >= 135 && heading <= 224) {
            direction = Moveable.Direction.down;
        } else if (heading >= 225 && heading <= 314) {
            direction = Moveable.Direction.left;
        } else {
            direction = Moveable.Direction.up;
        }
        moveable.moveMe(direction);
    }

}
