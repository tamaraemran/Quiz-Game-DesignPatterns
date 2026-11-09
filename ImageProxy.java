package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageProxy implements Icon {
    private final String resourcePath;
    private final int width;
    private final int height;
    private final boolean scale;

    private Icon realIcon;
    private boolean loadAttempted = false;

    public ImageProxy(String resourcePath, int width, int height) {
        this(resourcePath, width, height, false);
    }

    public ImageProxy(String resourcePath, int width, int height, boolean scale) {
        this.resourcePath = resourcePath;
        this.width = width;
        this.height = height;
        this.scale = scale;
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Icon real = getRealIcon();
        if (real != null) {
            int dx = x + (width - real.getIconWidth()) / 2;
            int dy = y + (height - real.getIconHeight()) / 2;
            real.paintIcon(c, g, dx, dy);
        } else {
            paintPlaceholder(g, x, y);
        }
    }

    public boolean isLoaded() {
        return realIcon != null;
    }

    private Icon getRealIcon() {
        if (!loadAttempted) {
            loadAttempted = true;
            URL url = ClassLoader.getSystemResource(resourcePath);
            if (url != null) {
                ImageIcon icon = new ImageIcon(url);
                if (scale) {
                    Image scaled = icon.getImage()
                            .getScaledInstance(width, height, Image.SCALE_DEFAULT);
                    icon = new ImageIcon(scaled);
                }
                realIcon = icon;
            } else {
                System.err.println("ImageProxy: image not found -> " + resourcePath);
            }
        }
        return realIcon;
    }

    private void paintPlaceholder(Graphics g, int x, int y) {
        g.setColor(new Color(235, 243, 255));
        g.fillRect(x, y, width, height);
        g.setColor(new Color(30, 144, 254));
        g.drawRect(x, y, width - 1, height - 1);
        g.setFont(new Font("Tahoma", Font.PLAIN, 14));
        g.drawString("Image not available: " + resourcePath, x + 10, y + height / 2);
    }
}
