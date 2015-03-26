import java.awt.*;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class FractalTree extends JPanel
{
    private double endLength = .5;
    private double angle = 45;
   
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        double length = 600;
        Line2D.Double firstLine = new Line2D.Double(getWidth(), getHeight(), getWidth(), getHeight()-length);
        g2.draw(firstLine);
        g2.setColor(new Color(153, 76, 0));
        recursiveDraw(g2,800, 900, length, Math.PI/2);
    }
    private void recursiveDraw(Graphics2D g2, double x, double y, double length, double angle)
    {
        if(length<endLength)
        {
            return;
        }
        double x2 = x - (length/2) * Math.cos(angle);
        double y2 = y - (length/2) * Math.sin(angle);
        Line2D.Double line1 = new Line2D.Double(x,y,x2,y2);
        x = x2;
        y = y2;
        g2.draw(line1);
        g2.setColor(new Color(192, 255, 95));
        recursiveDraw(g2, x, y, length/1.5, angle + Math.PI/4);
        g2.setColor(new Color(127,255,95));
        recursiveDraw(g2, x, y, length/1.5, angle - Math.PI/4);
    }
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setTitle("Fractal Trees");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        FractalTree newTree = new FractalTree();
        frame.add(newTree);
        frame.setVisible(true);
    }
}