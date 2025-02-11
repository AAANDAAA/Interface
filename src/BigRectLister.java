import org.w3c.dom.css.Rect;
import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class BigRectLister {
    // Setting the list
    public static void main(String[] args){
        ArrayList <Rectangle> rects = new ArrayList<>();
        rects.add(new Rectangle(1,10));
        rects.add(new Rectangle(2,5));
        rects.add(new Rectangle(3,2));
        rects.add(new Rectangle(1,1));
        rects.add(new Rectangle(1,9));
        rects.add(new Rectangle(2,0));
        rects.add(new Rectangle(8,0));
        rects.add(new Rectangle(1,3));
        rects.add(new Rectangle(6,7));
        rects.add(new Rectangle(2,2));
        // Calling in the class
        Filter filter = new BigRectFilter();
        // Array and  filter if rect > 10
        ArrayList <Rectangle> BigRectangles = new ArrayList<>();
        for (Rectangle rect : rects){
            if (filter.accept(rect)) {
                BigRectangles.add(rect);
            }
        }
        System.out.println("Rectangle with perimeter > 10: ");
        for (Rectangle rect: BigRectangles){
            System.out.println(rect + " (Perimeter: " + (2 * (rect.getWidth() + rect.getHeight())) + ")");
        }
    }
}
