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
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Frank "SeySayux" Erens <seysayux@gmail.com>
 */
public class Painter {

    Graphics g;
    private int size;
    private BufferedImage backbuffer;

    Painter(int size, BufferedImage backbuffer) {
        this.size = size;
        this.backbuffer = backbuffer;
    }

    public void put(Point p, Color c) {
        g.setColor(c);
        g.fillRect(p.x*size, p.y*size, size, size);
        //g.setColor(Color.GRAY);
        //g.drawRect(p.x*size, p.y*size, size, size);
    }

    void addGrid(Color c) {
        g.setColor(c);
        for(int i = 0; i < backbuffer.getWidth() / size; ++i) {
            for(int j = 0; j < backbuffer.getHeight() / size; ++j) {
                g.drawRect(i*size, j*size, size, size);
            }
        }
    }
    public Color get(Point p) {
        return new Color(backbuffer.getRGB(p.x*size, p.y*size));
    }

    public void fill(Point p, Color orig, Color dest) {
        
    }

}
