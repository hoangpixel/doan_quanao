package borderRadius;



import javax.swing.border.AbstractBorder;
import java.awt.*;

public class roundedBorder extends AbstractBorder {
    private int radius;

    public roundedBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.GRAY); // Màu viền
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        g2.dispose();
    }
}
