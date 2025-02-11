import java.awt.*;

public class BigRectFilter implements Filter {

    @Override
    public boolean accept(Object x) {
        if ( x instanceof Rectangle){
            Rectangle r = (Rectangle) x;
            int perimeter = r.height * 2 + r.width * 2;
            return perimeter > 10;
        }
        return false;
    }
}
