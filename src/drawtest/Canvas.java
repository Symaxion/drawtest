/*
 * Drawtest Library
 * Copyright (C) 2011 Frank "SeySayux" Erens <seysayux@gmail.com>
 *
 * This software is provided 'as-is', without any express or implied
 * warranty. In no event will the authors be held liable for any damages
 * arising from the use of this software.
 *
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it
 * freely, subject to the following restrictions:
 *
 *   1. The origin of this software must not be misrepresented; you must not
 *   claim that you wrote the original software. If you use this software
 *   in a product, an acknowledgment in the product documentation would be
 *   appreciated but is not required.
 *
 *   2. Altered source versions must be plainly marked as such, and must not be
 *   misrepresented as being the original software.
 *
 *   3. This notice may not be removed or altered from any source
 *   distribution.
 *   
 */

package drawtest;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Canvas extends java.awt.Canvas {

    BufferedImage backbuffer;

    private Painter paint;
    private HashMap<String, Shape> shlist = new HashMap<String,Shape>();

    public Canvas(String title, int x, int y) {
        this(title,x,y,4);
    }

    public Canvas(String title, int x, int y, int size) {
        backbuffer = new BufferedImage(x*size, y*size, BufferedImage.TYPE_INT_RGB);
        Graphics backg = backbuffer.getGraphics();
        backg.setColor(Color.white);
        backg.fillRect(0, 0, x*size, y*size);

        paint = new Painter(size, backbuffer);
        JFrame f = new JFrame(title);
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        f.setResizable(false);
        f.setSize(x*size,y*size);

        Container c = f.getContentPane();
        c.add(this);

        f.validate();
        f.setVisible(true);
        new Thread(new Runnable() {
            public void run() {
                while(true) {
                    repaint();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    @Override
    public void paint(Graphics g) {
        paint.g = backbuffer.getGraphics();
        for(Shape s : shlist.values()) {
            s.paint(paint);
        }
        g.drawImage(backbuffer, 0, 0, this);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public void addShape(String name,Shape s) {
        shlist.put(name,s);
    }

    public void removeShape(String s) {
        shlist.remove(s);
    }
}
